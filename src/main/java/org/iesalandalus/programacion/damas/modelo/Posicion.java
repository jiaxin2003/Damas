package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

public class Posicion {

    private int fila;
    private char columna;




    public Posicion(int fila, char columna){
        setFila(fila);
        setColumna(columna);
    }

    public Posicion(Posicion posicion){
        setFila(posicion.fila);
        setColumna(posicion.columna);
    }




    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if(fila<1 | fila>8) {
            throw new IllegalArgumentException("ERROR: introduce un numero de fila valida de entre 1 y 8");
        }
        this.fila=fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna){
        if(columna<'a' | columna>'h') {
            throw new IllegalArgumentException("ERROR: introduce una letra de columna valida de fila valida de entre 1 y 8");
        }
        this.columna = columna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicion posicion)) return false;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}

