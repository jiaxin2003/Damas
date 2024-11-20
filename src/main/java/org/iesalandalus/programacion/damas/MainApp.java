package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;
import java.awt.*;

public class MainApp {
    private static Dama dama;

    public static void main(String[] args) {
        int opcionPuesta;
        do {
            mostrarDama();
            Consola.mostrarMenu();
            opcionPuesta = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcionPuesta);
        } while (opcionPuesta != 4);



    }
        private static void ejecutarOpcion ( int opcionElegida) {

            switch (opcionElegida) {
                case 1:
                    crearDamaPorDefecto();
                    break;
                case 2:
                    crearDamaColor();
                    break;
                case 3:
                    mover();
                case 4:
                    Consola.despedirse();
                    break;
            }
        }
    private static void crearDamaPorDefecto(){
        dama=new Dama();
    }
    private static void crearDamaColor(){

        dama=new Dama(Consola.elegirOpcionColor());
    }

    private static void mover(){
        Consola.mostrarMenuDirecciones();
        try {

            int recuadrosAMover;
            if(dama.isEsDamaEspecial()){
                System.out.println("Eres Dama especial ");
                System.out.println("Cuanto te quieres mover");
                recuadrosAMover= Entrada.entero();
                dama.mover(Consola.elegirDireccion(), recuadrosAMover);

            }else dama.mover(Consola.elegirDireccion(),1);


        }catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }


    }
    private static void mostrarDama(){
        System.out.println(dama);
    }
}

