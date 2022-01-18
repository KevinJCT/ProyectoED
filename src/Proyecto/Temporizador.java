/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.util.Scanner;

/**
 *
 * @author byron
 */
public class Temporizador implements Runnable {

    static Scanner tecla = new Scanner(System.in);
    static int seg;

    public Temporizador(int seg) {
        this.seg = seg;
    }

    @Override
    public void run() {
        int segundos = -1;
        for (segundos = seg; segundos >= 0; segundos--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

    }

}
