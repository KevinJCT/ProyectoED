package interfaz.consola;

import validacion.IValidador;
import java.util.Scanner;

public class Consola {

    private static final String ANSI_COLOR_POR_DEFECTO = "\u001B[0m";
    private static final String ANSI_COLOR_ERROR = "\u001B[31m";
    private static final String ANSI_COLOR_NOTIF = "\u001B[32m";

    private static Consola instancia = null;
    public Scanner entrada;

    private Consola() {
        entrada = new Scanner(System.in);
    }

    public static Consola get_() {
        if (instancia == null) {
            instancia = new Consola();
        }
        return instancia;
    }

    public static String ingresarDato(String mensajeEntrada, String mensajeError, IValidador validador) {
        boolean datoValido;
        String dato;
        do {
            System.out.println(mensajeEntrada);
            dato = Consola.get_().entrada.nextLine();
            datoValido = validador.validar(dato);
            if (!datoValido) {
                Consola.notificarError(mensajeError);
            }
        } while (!datoValido);
        return dato;
    }

    public static void notificar(String mensaje) {
        System.out.println(mensaje);
    }

    public static void notificarÉxito(String mensaje) {
        System.out.println(Consola.ANSI_COLOR_NOTIF + mensaje + Consola.ANSI_COLOR_POR_DEFECTO);
    }

    public static void notificarError(String mensajeError) {
        System.out.println(Consola.ANSI_COLOR_ERROR + mensajeError + Consola.ANSI_COLOR_POR_DEFECTO);
    }

}
