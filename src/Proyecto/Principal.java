package Proyecto;

import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {
        GestorProyecto g = new GestorProyecto();
        Menu.menuPrincipal(g);
    }
}
