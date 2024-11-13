package org.iesalandalus.programacion.damas.modelo;

import java.util.EventListener;

public class Dama {
    private Color colorDama;
    private Posicion posicionDama;
    private boolean esDamaEspecial;


    private Posicion crearPosicionInicial(){
        int fila;
        if (colorDama == Color.BLANCO) {
            fila = (int) (Math.random() * 3) + 1;
        } else  {
            fila = (int) (Math.random() * 3) + 6;
        }


            int columna;
            if (fila % 2 == 0) {
                do {
                    columna = (int) (Math.random() * 8) + 1;
                } while (columna % 2 == 0);
            } else {
                do {
                    columna = (int) (Math.random() * 8) + 1;
                } while (columna % 2 != 0);
            }
            char letra = switch (columna) {
                case 1 -> 'A';
                case 2 -> 'B';
                case 3 -> 'C';
                case 4 -> 'D';
                case 5 -> 'E';
                case 6 -> 'F';
                case 7 -> 'G';
                case 8 -> 'H';
                default -> ' ';
            };
        return new Posicion(fila,letra);
    }


    public Dama(){
        Posicion posicion=crearPosicionInicial();
        setColorDama(Color.BLANCO);
        setPosicionDama(posicion);
    }




    public Color getColorDama() {
        return colorDama;
    }

    public void setColorDama(Color colorDama) {
        this.colorDama = colorDama;
    }

    public Posicion getPosicionDama() {
        return posicionDama;
    }

    public void setPosicionDama(Posicion posicionDama) {
        this.posicionDama = posicionDama;
    }

    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }

    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }
}
