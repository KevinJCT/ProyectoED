package Proyecto;

import static Proyecto.Menu.registrarJugadores;
import interfaz.consola.Consola;
import validacion.ValidadorExpReg;

public class Menu {

    private static final String EXPR_REG_MENU_PCPAL = "[0-5]";
    private static final String EXPR_REG_MENU_REGISTROS_JUGADORES = "[0-3]";
    private static final String EXPR_REG_MENU_REGISTRO_TECLAS = "[0-3]";
     private static final String EXPR_REG_MENU_CONFIGURACION = "[0-2]";
       private static final String EXPR_REG_MENU_CONFIGURACION_MODOJUEGO= "[0-3]";
     private static final String EXPR_REG_MENU_CONFIGURACION_TIEMPO= "[0-3]";  

//    private static final String EXPR_REG_NOTA = "^[0-9]+(\\.[0-9]{1,2})?$";
    private static final String EXPR_REG_CONFIRM = "[ssnN]";

    private static final String VALOR_CONFIRMACIÓN = "S";

    static void menuPrincipal(GestorProyecto gestorProyecto) {
        int opcion;
        do {
            Menu.imprimirMenuPcpal();
            opcion = Integer.parseInt(Consola.ingresarDato(
                    Mensajes.INGRESO.OPCION.tx(), Mensajes.ERROR.OPCION.tx(),
                    new ValidadorExpReg(EXPR_REG_MENU_PCPAL)));

            switch (opcion) {
                case 1:
                    registrarJugadores(gestorProyecto);
                    break;
                case 2:
                    registrarTeclas(gestorProyecto);

                    break;
                case 3:
                    configuracionJuego(gestorProyecto);
                   
                    
                    break;
                case 4:
                    // Play
                    System.out.println(Mensajes.ERROR.NO_TERMINADO_JUEGO.tx());
                    break;
            }

        } while (opcion != 0);

    }

   

    public static void play() {

    }

    public static void registrarJugadores(GestorProyecto gestorProyecto) {
        int opcion;
        do {
            Menu.imprimirMenuRegistroJugadores();
            opcion = Integer.parseInt(Consola.ingresarDato(
                    Mensajes.INGRESO.OPCION.tx(), Mensajes.ERROR.OPCION.tx(),
                    new ValidadorExpReg(EXPR_REG_MENU_PCPAL)));

            switch (opcion) {
                case 1:
                    gestorProyecto.insertarJugador();
                    break;
                case 2:
                    gestorProyecto.imprimirJugadores();
                    break;
                case 3:
                    gestorProyecto.modificarJugador();
                    break;
                case 4:
                    gestorProyecto.eliminarJugador();
                    break;

            }
        } while (opcion != 0);
    }

    public static void registrarTeclas(GestorProyecto gestorProyecto) {
        int opcion;
        do {
            Menu.imprimirMenuRegistroTeclas();
            opcion = Integer.parseInt(Consola.ingresarDato(
                    Mensajes.INGRESO.OPCION.tx(), Mensajes.ERROR.OPCION.tx(),
                    new ValidadorExpReg(EXPR_REG_MENU_PCPAL)));

            switch (opcion) {
                case 1:
                    gestorProyecto.insertarTecla();
                    break;
                case 2:
                    gestorProyecto.imprimirTeclas();
                    break;
                case 3:
                    gestorProyecto.modificarTecla();
                    break;
                case 4:
                    gestorProyecto.eliminarTecla();
                    break;

            }
        } while (opcion != 0);
    }
    public static void configuracionJuego(GestorProyecto gestorProyecto) {
        int opcion;
        do {
            Menu.imprimirMenuConfiguración();
            opcion = Integer.parseInt(Consola.ingresarDato(
                    Mensajes.INGRESO.OPCION.tx(), Mensajes.ERROR.OPCION.tx(),
                    new ValidadorExpReg(EXPR_REG_MENU_CONFIGURACION)));

            switch (opcion) {
                case 1:
                    // Modo de guejo
                   modoJuego(gestorProyecto);
                    break;
                case 2:
                    // Configuración tiempo 
                    configuracionTiempo(gestorProyecto);
                    break;
            }
        } while (opcion != 0);
    }
    
    
    public static void modoJuego(GestorProyecto gestorProyecto) {
          int opcion;
        do {
            Menu.imprimirMenuConfiguraciónModalidad();
            opcion = Integer.parseInt(Consola.ingresarDato(
                    Mensajes.INGRESO.OPCION.tx(), Mensajes.ERROR.OPCION.tx(),
                    new ValidadorExpReg(EXPR_REG_MENU_CONFIGURACION_MODOJUEGO)));

            switch (opcion) {
                case 1:
                    //Facil                 
                    break;
                case 2:
                    //Normal
                    break;
                case 3:
                    //Dificil
                    break;
            }
        } while (opcion != 0);
    }
     public static void configuracionTiempo(GestorProyecto gestorProyecto) {
          int opcion;
        do {
            Menu.imprimirMenuConfiguraciónTiempo();
            opcion = Integer.parseInt(Consola.ingresarDato(
                    Mensajes.INGRESO.OPCION.tx(), Mensajes.ERROR.OPCION.tx(),
                    new ValidadorExpReg(EXPR_REG_MENU_CONFIGURACION_TIEMPO)));

            switch (opcion) {
                case 1:
                    //Ingreso
                    gestorProyecto.insertarTiempo();
                    break;
                case 2:
                // Modificar
                    gestorProyecto.modificarTiempo();
                    break;
                case 3:
               // Eliminar
                    gestorProyecto.eliminarTiempo();
                    break;
               
            }
        } while (opcion != 0);
    }
    
     private static void imprimirMenuPcpal() {
        System.out.println(Mensajes.MENU.ENCABEZADO_MENU_PRINCIPAL.tx());
        System.out.println(Mensajes.MENU.REGISTRAR_JUGADORES.tx());
        System.out.println(Mensajes.MENU.REGISTRAR_TECLAS.tx());
        System.out.println(Mensajes.MENU.CONFIGURACION.tx());
        System.out.println(Mensajes.MENU.PLAY.tx());
        System.out.println(Mensajes.MENU.SALIR.tx());
    }

    private static void imprimirMenuRegistroJugadores() {
        System.out.println(Mensajes.MENU.ENCABEZADO_REGISTRO_JUGADORES.tx());
        System.out.println(Mensajes.MENU.REGISTRAR_JUGADOR.tx());
        System.out.println(Mensajes.MENU.IMPRIMIR_JUGADOR.tx());
        System.out.println(Mensajes.MENU.MODIFICAR_JUGADOR.tx());
        System.out.println(Mensajes.MENU.ELIMINAR_JUGADOR.tx());
        System.out.println(Mensajes.MENU.REGRESAR.tx());
    }

    private static void imprimirMenuRegistroTeclas() {
        System.out.println(Mensajes.MENU.ENCABEZADO_REGISTRO_TECLAS.tx());
        System.out.println(Mensajes.MENU.INGRESAR_TECLA.tx());
        System.out.println(Mensajes.MENU.IMPRIMIR_TECLA.tx());
        System.out.println(Mensajes.MENU.MODIFICAR_TECLA.tx());
        System.out.println(Mensajes.MENU.ELIMINAR_TECLA.tx());
        System.out.println(Mensajes.MENU.REGRESAR.tx());
    }

    private static void imprimirMenuConfiguración() {
        System.out.println(Mensajes.MENU.ENCABEZADO_REGISTRO_CONFIGURACIÓN.tx());
        System.out.println(Mensajes.MENU.CONFIGURAR_MODALIDAD.tx());
        System.out.println(Mensajes.MENU.CONFIGURAR_TIEMPO.tx());
        System.out.println(Mensajes.MENU.REGRESAR.tx());

    }

    private static void imprimirMenuConfiguraciónTiempo() {
        System.out.println(Mensajes.MENU.ENCABEZADO_REGISTRO_CONFIGURACIÓN_TIEMPO.tx());
        System.out.println(Mensajes.MENU.INGRESAR_TIEMPO.tx());
       // System.out.println(Mensajes.MENU.IMPRIMIR_TIEMPO.tx());
        System.out.println(Mensajes.MENU.MODIFICAR_TIEMPO.tx());
        System.out.println(Mensajes.MENU.ELIMINAR_TIEMPO.tx());
        System.out.println(Mensajes.MENU.REGRESAR.tx());

    }

    private static void imprimirMenuConfiguraciónModalidad() {
        System.out.println(Mensajes.MENU.ENCABEZADO_REGISTRO_CONFIGURACIÓN_MODALIDAD.tx());
        System.out.println(Mensajes.MENU.MODALIDAD_FACIL.tx());
        System.out.println(Mensajes.MENU.MODALIDAD_NORMAL.tx());
        System.out.println(Mensajes.MENU.MODALIDAD_DIFICIL.tx());
        System.out.println(Mensajes.MENU.REGRESAR.tx());
    }

    static int ingresarPos() {
        return Integer.parseInt(Consola.ingresarDato(Mensajes.INGRESO.POS.tx(),
                Mensajes.ERROR.POS_NO_VALIDA.tx(),
                new ValidadorExpReg(ValidadorExpReg.ENTERO_SIN_SIGNO)));
    }
}
