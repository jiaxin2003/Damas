package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola() {

    }
    public static void mostrarMenu(){
        System.out.println("1. Crear Dama por Defecto");
        System.out.println("2. Crear Dama Eligiendo color");
        System.out.println("3. Movimiento");
        System.out.println("4. Salir del Programa");
    }
    public static int elegirOpcionMenu(){
        int opcion;
            do {
                System.out.println("Elige la opcion que quieres del 1 al 4");
                opcion= Entrada.entero();
            }while (opcion<1 || opcion>4);
            return opcion;
    }
    public static int elegirOpcion(){
        int colorOpcion;
        do {
            System.out.println("Elige un color entre Negro y Blanco");
            System.out.println("1. Blanco");
            System.out.println("2. negro");
            colorOpcion=Entrada.entero();
        }while (colorOpcion<1||colorOpcion>2);
        return colorOpcion;
    }
}
