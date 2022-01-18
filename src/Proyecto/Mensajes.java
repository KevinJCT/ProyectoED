package Proyecto;

public class Mensajes {

    static String ANSI_RED = "\u001B[31m";
    static String ANSI_GREEN = "\u001B[32m";
//    static String ANSI_YELLOW = "\u001B[33m";
    static String ANSI_BLUE = "\u001B[34m";
    static String ANSI_PURPLE = "\u001B[35m";
//    static String ANSI_CYAN = "\u001B[36m";

    public enum INGRESO {
        OPCION(ANSI_BLUE + "\n" + "Opción: " + ANSI_BLUE),
        OPCION_CANCELAR(ANSI_BLUE + "Presione 0 para cancelar " + ANSI_BLUE),
        CEDULA(ANSI_BLUE + "Cédula: " + ANSI_BLUE),
        JUGADOR_NO_ELIMINADO(ANSI_BLUE + "Este jugador no se puede eliminar, tiene puntuaciones asignadas" + ANSI_BLUE),
        NOMBRE_JUGADOR(ANSI_BLUE + "Introduzca el nickname del jugador: " + ANSI_BLUE),
        POS(ANSI_BLUE + "Intruducir posicion: " + ANSI_BLUE),
        INTRODUCIR_TECLA(ANSI_BLUE + "Introduzca la tecla(s): " + ANSI_BLUE),
        INTRODUCIR_TIEMPO(ANSI_BLUE + "Introduzca el tiempo (seg): " + ANSI_BLUE);
        private String valor;

        private INGRESO(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }
    }

    public enum ERROR {
//        OPCION(ANSI_RED + "Número de opción no válida." + ANSI_RED),
        OPCION(ANSI_RED + "Número de opción no válida." + ANSI_RED),
        NO_EXISTE_PARAMETROS(ANSI_RED+"ERROR: Llenar parametros..."),
        NO_VALIDO_JUGADOR(ANSI_RED + "Nombre del jugador no válido: " + ANSI_RED),
        NO_JUGADOR(ANSI_RED + "No existen jugadores" + ANSI_RED),
        //CEDULA("El número de cédula especificado no es válido."),
        CONFIRMACIÓN(ANSI_RED + "Valor ingresado no válido. Ingrese sí (S) o no (N)." + ANSI_RED),
        MEMORIA(ANSI_RED + "No hay memoria suficiente para el registro solicitado." + ANSI_RED),
        MEMORIA_INSUFICIENTE(ANSI_RED + "Memoria insuficiente" + ANSI_RED),
        POS_NO_VALIDA(ANSI_RED + "Posición invalida: " + ANSI_RED),
        NO_EXISTE_TECLA(ANSI_RED + "No existe palabras" + ANSI_RED),
        NO_VALIDO_TECLA(ANSI_RED + "Tecla no valido." + ANSI_RED),
        NO_EXISTE_TIEMPO(ANSI_RED + "No existe tiempo" + ANSI_RED),
        NO_TERMINADO_JUEGO(ANSI_RED + "El juego no está terminado" + ANSI_RED),
        ARCHIVO_NO_ENCONTRADO(ANSI_RED + "Archivo no encontrado" + ANSI_RED);

        private String valor;

        private ERROR(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }
    }

    public enum NOTIF {
        DESPEDIDA(ANSI_GREEN + "¡HASTA PRONTO!" + ANSI_GREEN),
        DATOSE(ANSI_GREEN + "Datos eliminados" + ANSI_GREEN),
        DATOSM(ANSI_GREEN + "Datos modificados" + ANSI_GREEN),
        JUGADOR(ANSI_GREEN + "Datos del jugador registrados exitosamente" + ANSI_GREEN),
        TECLA(ANSI_GREEN + "Tecla(s) registrada correctamente" + ANSI_GREEN),
        ELIMINAR_TECLA(ANSI_GREEN + "Tecla(s) eliminado con éxito" + ANSI_GREEN),
        ELIMINAR_JUGADOR(ANSI_GREEN + "Jugador eliminado con éxito" + ANSI_GREEN),
        MODIFICAR_TECLA(ANSI_GREEN + "Tecla(s) modificada con éxito" + ANSI_GREEN),
        MODIFICAR_TIEMPO(ANSI_GREEN + "Tiempo modificada con éxito" + ANSI_GREEN),
        TIEMPO(ANSI_GREEN + "Tiempo registrado correctamente" + ANSI_GREEN),
        ELIMINAR_TIEMPO(ANSI_GREEN + "Tiempo eliminado con éxito" + ANSI_GREEN);

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
                + ANSI_PURPLE + "\n     *       MECANOGRAFIA GAME       * " + ANSI_PURPLE
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
//        IMPRIMIR_TECLA("2. Imprimir teclas."),
        MODIFICAR_TECLA("2. Modificar teclas."),
        ELIMINAR_TECLA("3. Eliminar teclas."),
        IMPORTAR_SECUENCIAS_TECLAS("4. Importar Secuencia de teclas"),
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
