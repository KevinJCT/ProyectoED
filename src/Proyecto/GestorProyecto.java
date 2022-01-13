package Proyecto;

import static Proyecto.Menu.ingresarPos;
import interfaz.consola.Consola;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import validacion.ValidadorExpReg;

public class GestorProyecto {

    LinkedList<Jugador> jugadores;
    LinkedList<Tecla> teclas;
    LinkedList<Integer> tiempos;

    GestorProyecto() {
        this.jugadores = new LinkedList();
        this.teclas = new LinkedList();
        this.tiempos = new LinkedList();
    }

    public void insertarJugador() throws IOException {

        // Para validar el dato ingresado, utiliza el Consola.ingresarDato(1° mesaje es "Nombre jugador", 2° Mensaje de error", 3 solo permite letas° )
        String nickname = (Consola.ingresarDato(Mensajes.INGRESO.NOMBRE_JUGADOR.tx(), // ARGUMENTO
                Mensajes.ERROR.NO_VALIDO_JUGADOR.tx(),
                new ValidadorExpReg(ValidadorExpReg.CADENA_TEXTO)));

        //Guarda una instancia de objeto en la lista dinamica
        if (!this.jugadores.add(new Jugador(nickname))) {
            System.out.println(Mensajes.ERROR.MEMORIA_INSUFICIENTE.tx()); // Se aplica si se tiene un limite
        } else {
            System.out.println(Mensajes.NOTIF.JUGADOR.tx()); // Se guarda exitosamente
        }
    }

    public boolean imprimirJugadores() {
        // Verifica si existe jugadores en la lista
        if (this.jugadores.isEmpty()) {
            System.out.println(Mensajes.ERROR.NO_JUGADOR.tx());
            return false;
        }
        // Imprimi la lista de jugadores
        for (int i = 0; i < this.jugadores.size(); i++) {
            System.out.printf("%10d%s%s\n", i + 1, ".", this.jugadores.get(i).nickname);
        }
        return true;
    }

    public boolean eliminarJugador() {
        // Verifica si existe jugadores en la lista
        if (this.jugadores.isEmpty()) {
            System.out.println(Mensajes.ERROR.NO_VALIDO_JUGADOR.tx());
            return false;
        }
        imprimirJugadores();

        int pos = validarPosicion(jugadores.size());

        // Realiza el control
        this.jugadores.remove(pos - 1); // Remueve la posición anterior ingresada, ya que un lista empieza posicion 0
        System.out.println(Mensajes.NOTIF.ELIMINAR_JUGADOR.tx());
        return true;
    }

    int validarPosicion(int cantidadElementos) {
        int pos;
        do {
            // Se obtiene el valor de posicion ingresada
            pos = ingresarPos();
            // posicion es mayor a la cantidad de jugadores o posicion es menor o igual a cero
            if (pos > cantidadElementos || pos <= 0) {
                System.out.println(Mensajes.ERROR.POS_NO_VALIDA.tx()); // muestra el mensaje
            }
        } while (pos > cantidadElementos || pos <= 0);
        return pos;
    }

    public boolean modificarJugador() {
        // Verifica si existe jugadores en la lista
        if (this.jugadores.isEmpty()) {
            System.out.println(Mensajes.ERROR.NO_JUGADOR.tx());
            return false;
        }
        imprimirJugadores();

        int pos = validarPosicion(jugadores.size());

        // Se ingresa el nickname
        String nickname = (Consola.ingresarDato(Mensajes.INGRESO.NOMBRE_JUGADOR.tx(),
                Mensajes.ERROR.NO_VALIDO_JUGADOR.tx(),
                new ValidadorExpReg(ValidadorExpReg.CADENA_TEXTO)));
        // Se remplaza el dato en la posicion-1
        this.jugadores.get(pos - 1).nickname = nickname;
        System.out.println(Mensajes.NOTIF.DATOSM.tx());
        return true;
    }

    public void insertarTecla() {

        String tecla = (Consola.ingresarDato(Mensajes.INGRESO.INTRODUCIR_TECLA.tx(),
                Mensajes.ERROR.NO_EXISTE_TECLA.tx(),
                new ValidadorExpReg(ValidadorExpReg.CADENA_TEXTO)));

        if (!this.teclas.add(new Tecla(tecla))) {
            System.out.println(Mensajes.ERROR.MEMORIA_INSUFICIENTE.tx());
        } else {
            System.out.println(Mensajes.NOTIF.TECLA.tx());
        }
    }

    public boolean imprimirTeclas() {
        if (this.teclas.isEmpty()) {
            System.out.println(Mensajes.ERROR.NO_EXISTE_TECLA.tx());
            return false;
        }
        for (int i = 0; i < this.teclas.size(); i++) {
            System.out.printf("%10d%s%s\n", i + 1, ".", this.teclas.get(i).tecla);
        }
        return true;
    }

    public boolean eliminarTecla() {
        if (this.teclas.isEmpty()) {
            System.out.println(Mensajes.ERROR.NO_EXISTE_TECLA.tx());
            return false;
        }
        imprimirTeclas();

        int pos = validarPosicion(teclas.size());

        this.teclas.remove(pos - 1);
        System.out.println(Mensajes.NOTIF.ELIMINAR_TECLA.tx());
        return true;
    }

    public boolean modificarTecla() {
        if (this.teclas.isEmpty()) {
            System.out.println(Mensajes.ERROR.NO_EXISTE_TECLA.tx());
            return false;
        }
        imprimirTeclas();

        int pos = validarPosicion(teclas.size());

        String tecla = (Consola.ingresarDato(Mensajes.INGRESO.INTRODUCIR_TECLA.tx(),
                Mensajes.ERROR.NO_EXISTE_TECLA.tx(),
                new ValidadorExpReg(ValidadorExpReg.CADENA_TEXTO)));

        this.teclas.get(pos - 1).tecla = tecla;
        System.out.println(Mensajes.NOTIF.MODIFICAR_TECLA.tx());
        return true;
    }

    public void insertarTiempo() {
        int tiempo = Integer.valueOf(Consola.ingresarDato(Mensajes.INGRESO.INTRODUCIR_TIEMPO.tx(),
                Mensajes.ERROR.NO_EXISTE_TECLA.tx(),
                new ValidadorExpReg(ValidadorExpReg.ENTERO_CON_SIGNO)));

        for (Jugador jugador : jugadores) {
            jugador.tiempo = tiempo;
        }
    }

    public void play() {
        Scanner ingreso = new Scanner(System.in);
        String linea; // Ingresar jugador
        int i = 0;
        while (i < jugadores.size()) {
            System.out.println("------ " + jugadores.get(i).nickname + " ------");
            System.out.println(teclas.get(i).tecla);
            linea = ingreso.nextLine();
            //Metodo para verificar y contar errores 
            verificarSecuenciaTeclas(jugadores.get(i), teclas.get(i).tecla, linea);
            i++;
        }

        for (Jugador jugador : jugadores) {
            System.out.println("\n\n ****** Tabla ******");
            System.out.printf("%10s%20s\n", "Jugador", "Cantidad Aciertos");
//            System.out.printf("%10s%10s%10s\n", jugador.nickname, "........", jugador.cantidadFallos);
            System.out.printf("%10s%10s%10s\n", jugador.nickname, "........", jugador.cantidadAciertos);
        }
        //Preguntar volver a jugar
    }

    private boolean verificarSecuenciaTeclas(Jugador jugador, String secuenciaTecla, String lineaJugador) {

        // Contar cada letra que se equivo
        int i = 0;
//        int contadorErrror = 0;
        int contadorAciertos = 0;
//        int cantidadSecuenciaTecla = secuenciaTecla.length();
//        int cantidadLineaJugador = lineaJugador.length();

        while (i < secuenciaTecla.length() - 1) {
            try {
                if (secuenciaTecla.charAt(i) == lineaJugador.charAt(i)) {
//                    contadorErrror++;
//                    jugador.cantidadFallos = contadorErrror;
                    contadorAciertos++;
//                    System.out.println(contadorAciertos);
                    jugador.cantidadAciertos = contadorAciertos;
                }
            } catch (Exception e) {
                return false;
            }
            i++;
        }
      

//        if (cantidadLineaJugador < cantidadSecuenciaTecla) {
//            contadorAux = cantidadSecuenciaTecla - cantidadLineaJugador - 1;
//            jugador.cantidadFallos = contadorAux + contadorErrror;
//        }
        return true;
    }

    public void insertarArchivoTxt() throws FileNotFoundException, IOException {
        File archivo = new File("Normal.txt");
        FileReader filereader = new FileReader(archivo);
        BufferedReader br = new BufferedReader(filereader);

        String cadena;

        while ((cadena = br.readLine()) != null) {
            teclas.add(new Tecla(cadena));
        }
    }

//    public void insertarArchivo(int op) {
//        File archivo;
//        if (op == 1) {
//            for (Jugador jugador : jugadores) {
//                try {
//                    jugador.letras = new File("Facil.txt");
//                } catch (Exception e) {
//                    Mensajes.ERROR.ARCHIVO_NO_ENCONTRADO.tx();
//                }
//            }
//        } else if (op == 2) {
//            for (Jugador jugador : jugadores) {
//                try {
//                    jugador.letras = new File("Normal.txt");
//                } catch (Exception e) {
//                    Mensajes.ERROR.ARCHIVO_NO_ENCONTRADO.tx();
//                }
//            }
//        } else if (op == 3) {
//            for (Jugador jugador : jugadores) {
//                try {
//                    jugador.letras = new File("Dificil.txt");
//                } catch (Exception e) {
//                    Mensajes.ERROR.ARCHIVO_NO_ENCONTRADO.tx();
//                }
//            }
//        }
//    }
//    public void jugar() throws FileNotFoundException, IOException {
//
//        for (Jugador jugador : jugadores) {
//            
//            System.out.println("Jugador "+jugador.nickname+jugador.tiempo);
//            FileReader filereader = new FileReader(jugador.letras);
//            BufferedReader br = new BufferedReader(filereader);
//            String cadena;
//
//            while ((cadena = br.readLine()) != null) {
//                System.out.println(cadena);
//            }
//
//            System.out.println("");
//        }
//    }
//
//    public boolean modificarTiempo() {
//        if (this.tiempos.isEmpty()) {
//            System.out.println(Mensajes.ERROR.NO_EXISTE_TIEMPO.tx());
//            return false;
//        }
//        imprimirTiempo(); // Aqui tambien
//        int pos;
//        do {
//            pos = ingresarPos();
//            if (pos > this.tiempos.size() || pos <= 0) {
//                System.out.println(Mensajes.ERROR.POS_NO_VALIDA.tx());
//            }
//        } while (pos > this.tiempos.size() || pos <= 0);
//        String tiempo = (Consola.ingresarDato(Mensajes.INGRESO.INTRODUCIR_TIEMPO.tx(),
//                Mensajes.ERROR.NO_EXISTE_TIEMPO.tx(),
//                new ValidadorExpReg(ValidadorExpReg.ENTERO_SIN_SIGNO)));
//
//        this.tiempos.get(pos - 1).tiempo = tiempo;
//        System.out.println(Mensajes.NOTIF.MODIFICAR_TIEMPO.tx());
//        return true;
//    }
//
//    public boolean eliminarTiempo() {
//        if (this.tiempos.isEmpty()) {
//            System.out.println(Mensajes.ERROR.NO_EXISTE_TIEMPO.tx());
//            return false;
//        }
//        imprimirTiempo();
//        int pos;
//        do {
//            pos = ingresarPos();
//            if (pos > this.tiempos.size() || pos <= 0) {
//                System.out.println(Mensajes.ERROR.POS_NO_VALIDA.tx());
//            }
//        } while (pos > this.tiempos.size() || pos <= 0);
//        this.tiempos.remove(pos - 1);
//        System.out.println(Mensajes.NOTIF.ELIMINAR_TIEMPO.tx());
//        return true;
//    }
//
//    public boolean imprimirTiempo() {
//        if (this.tiempos.isEmpty()) {
//            System.out.println(Mensajes.ERROR.NO_EXISTE_TIEMPO.tx());
//            return false;
//        }
//        for (int i = 0; i < this.tiempos.size(); i++) {
//            System.out.printf("%10d%s%s\n", i + 1, ".", this.tiempos.get(i).tiempo);
//        }
//        return true;
//    }
}
