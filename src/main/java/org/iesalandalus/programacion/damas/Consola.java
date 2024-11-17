package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.damas.modelo.Direccion;
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
    public static void mostrarMenuDirecciones(){
        System.out.println("Estos son los movimientos que puedes hacer");
        System.out.println("1. NORESTE");
        System.out.println("2. NOROESTE");
        System.out.println("3. SURESTE");
        System.out.println("4. SUROESTE");
    }
    public static Direccion elegirDireccion(){
        int direccion;
        do {

            System.out.println("Elige que movimiento quieres hacer");
            System.out.println("1. NORESTE");
            System.out.println("2. NOROESTE");
            System.out.println("3. SURESTE");
            System.out.println("4. SUROESTE");
            direccion = Entrada.entero();
        }while (direccion<1||direccion>4);
        switch (direccion){
            case 1:
                return Direccion.NORESTE;
            case 2:
                return Direccion.NOROESTE;
            case 3:
                return Direccion.SURESTE;
            case 4:
                return Direccion.SUROESTE;
        }
        return null;
    }
    public static int elegirPasos(){
        int pasos;
        do {
            System.out.println("introduce los pasos que quieras realizar");
            pasos=Entrada.entero();
        }while (pasos<1 || pasos>8);
        return pasos;
    }
    public static void despedirse(){
        System.out.println("saliendo del programa, espero que tuviese una estancia agradable");
    }
}
