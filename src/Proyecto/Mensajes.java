package Proyecto;

public class Mensajes {

    public enum INGRESO {
        OPCION("\n" + "Opción: "),
        OPCION_CANCELAR("Presione 0 para cancelar "),
        CEDULA("Cédula: "),
        JUGADOR_NO_ELIMINADO("Este jugador no se puede eliminar, tiene puntuaciones asignadas"),
        NOMBRE_JUGADOR("Introduzca el nickname del jugador: "),
        POS("Intruducir posicion: "),
        INTRODUCIR_TECLA("Introduzca la tecla(s): "),
        INTRODUCIR_TIEMPO("Introduzca el tiempo (seg): ");
        private String valor;

        private INGRESO(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }
    }

    public enum ERROR {
        OPCION("Número de opción no válida."),
        NO_VALIDO_JUGADOR("Nombre del jugador no válido: "),
        NO_JUGADOR("No existen jugadores"),
        //CEDULA("El número de cédula especificado no es válido."),
        CONFIRMACIÓN("Valor ingresado no válido. Ingrese sí (S) o no (N)."),
        MEMORIA("No hay memoria suficiente para el registro solicitado."),
        MEMORIA_INSUFICIENTE("Memoria insuficiente"),
        POS_NO_VALIDA("Posición invalida: "),
        NO_EXISTE_TECLA("No existe palabras"),
        NO_VALIDO_TECLA("Tecla no valido."),
        NO_EXISTE_TIEMPO("No existe tiempo"),
        NO_TERMINADO_JUEGO("El juego no está terminado"),
        ARCHIVO_NO_ENCONTRADO("Archivo no encontrado");
        
        private String valor;

        private ERROR(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }
    }

    public enum NOTIF {
        DESPEDIDA("¡HASTA PRONTO!"),
        DATOSE("Datos eliminados"),
        DATOSM("Datos modificados"),
        JUGADOR("Datos del jugador registrados exitosamente"),
        TECLA("Tecla(s) registrada correctamente"),
        ELIMINAR_TECLA("Tecla(s) eliminado con exito"),
        ELIMINAR_JUGADOR("Jugador eliminado con exito"),
        MODIFICAR_TECLA("Tecla(s) modificada con exito"),
        MODIFICAR_TIEMPO("Tiempo modificada con exito"),
        TIEMPO("Tiempo registrado correctamente"),
        ELIMINAR_TIEMPO("Tiempo eliminado con exito");

        private String valor;

        private NOTIF(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }
    }

    public enum MENU {
        ENCABEZADO_MENU_PRINCIPAL("     *********************************    "
                + "\n     *       MECANOGRAFIA GAME       *    "
                + "\n     *********************************    "),
        
        REGISTRAR_JUGADORES(" 1. Registrar jugadores"),
        REGISTRAR_TECLAS(" 2. Registrar teclas"),
        CONFIGURACION(" 3. Configuración"),
        PLAY(" 4. Play ."),
        SALIR(" 0. SALIR."),
        
        ENCABEZADO_REGISTRO_JUGADORES("----- REGISTRO DE JUGADORES -----"),
        ENCABEZADO_REGISTRO_TECLAS("----- REGISTRO DE TECLAS -----"),
        ENCABEZADO_REGISTRO_CONFIGURACIÓN("-----CONFIGURACIÓN DEL JUEGO----"),
        ENCABEZADO_REGISTRO_CONFIGURACIÓN_TIEMPO("-----CONFIGURACIÓN DEL TIEMPO----"),
        ENCABEZADO_REGISTRO_CONFIGURACIÓN_MODALIDAD("-----CONFIGURACIÓN DE MODALIDAD----"),

        INGRESAR_TECLA("1. Ingresar teclas."),
        IMPRIMIR_TECLA("2. Imprimir teclas."),
        MODIFICAR_TECLA("3. Modificar teclas."),
        ELIMINAR_TECLA("4. Eliminar teclas."),
        
        REGISTRAR_JUGADOR("1. Registrar jugador."),
        IMPRIMIR_JUGADOR("2. Imprimir jugador."),
        MODIFICAR_JUGADOR("3. Modificar jugador."),
        ELIMINAR_JUGADOR("4. Eliminar jugador."),
        
        CONFIGURAR_MODALIDAD("1. Modalidad"),
        CONFIGURAR_TIEMPO("2. Tiempo"),
        
       INGRESAR_TIEMPO("1. Ingresar tiempo."),
       // IMPRIMIR_TIEMPO("2. Imprimir tiempo."),
        MODIFICAR_TIEMPO("2. Modificar tiempo."),
        ELIMINAR_TIEMPO("3. Eliminar tiempo."),

        MODALIDAD_FACIL("1. Facil."),
         MODALIDAD_NORMAL("2. Normal."),
         MODALIDAD_DIFICIL("3. Dificil."),
         
         ENCABEZADO_REGISTRO_ARCHIVO_TXT("---------Importar secuencia de teclas----------"),
         INSERTAR_ARCHIVO("1. Importar secuencia de teclas"),
         
         REGRESAR("0. REGRESAR.");

        private String valor;

        private MENU(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }

    }

}
