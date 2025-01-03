package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
import java.beans.beancontext.BeanContextServicesListener;
import java.io.ObjectStreamException;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;



    public Dama(int opcionElegida) {
    }

    private Posicion crearPosicionInicial(){
        int fila;
        if (color.equals(Color.BLANCO)) {
            fila = (int) (Math.random() * 3) + 1;
        } else  {
            fila = (int) (Math.random() * 3) + 6;
        }


            int columna;
            if (fila % 2 == 0) {
                do {
                    columna = (int) (Math.random() * 8) + 1;
                } while (columna % 2 != 0);
            } else {
                do {
                    columna = (int) (Math.random() * 8) + 1;
                } while (columna % 2 == 0);
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

    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        if (direccion==null)
            throw new NullPointerException("ERROR: la direccion no puede estar vacia ");
        if (pasos <1){
            throw new OperationNotSupportedException("ERROR: el numero introducido es negativo tienes que introducir un numero positivo mayor que uno");
        }
        if (!esDamaEspecial){
            if (color == Color.BLANCO) {
                if (direccion == Direccion.SURESTE || direccion == Direccion.SUROESTE) {
                    throw new OperationNotSupportedException("El movimiento que haces no esta permitido las damas solo pueden ir hacia delante y en diagonal");
                } else if (pasos > 1) {
                    throw new OperationNotSupportedException("ERROR: la dama no es dama especial lo cual ahce que no pueda moverse mas de una casilla");
                }

                switch (direccion){
                    case NORESTE -> this.setPosicion(new Posicion(getPosicion().getFila() + 1, (char) (getPosicion().getColumna() + 1)));
                    case NOROESTE -> this.setPosicion(new Posicion(getPosicion().getFila()+1, (char)(getPosicion().getColumna()-1)));
                }
                if(this.posicion.getFila() ==8){
                    this.esDamaEspecial=true;

                }
                }else if (color ==Color.NEGRO){
                if (direccion== Direccion.NORESTE || direccion == Direccion.NOROESTE) {
                    throw new OperationNotSupportedException("ERROR: El movimiento que haces no esta permitido las damas solo pueden ir hacia delante y diogonal");
                }
            } else if (pasos>1) {
                throw new OperationNotSupportedException("ERROR: la Dama no es Dama especial lo cuál hace que no pueda moverse mas de una casilla");
            } switch (direccion) {
                case SURESTE ->
                        this.setPosicion(new Posicion(getPosicion().getFila() - 1, (char) (getPosicion().getColumna() + 1)));
                case SUROESTE ->
                        this.setPosicion(new Posicion(getPosicion().getFila() - 1, (char) (getPosicion().getColumna() - 1)));
            }
            if(this.posicion.getFila()==1){
                this.esDamaEspecial=true;
            }
        }else {
            switch (direccion) {
                case NORESTE -> this.setPosicion(new Posicion(getPosicion().getFila() + 1, (char) (getPosicion().getColumna() + 1)));
                case NOROESTE -> this.setPosicion(new Posicion(getPosicion().getFila()+1, (char)(getPosicion().getColumna()-1)));
                case SURESTE -> this.setPosicion(new Posicion(getPosicion().getFila() - 1, (char) (getPosicion().getColumna() + 1)));
                case SUROESTE -> this.setPosicion(new Posicion(getPosicion().getFila() - 1, (char) (getPosicion().getColumna() - 1)));
            }
        }
    }


    public Dama(){
        Posicion posicionInicial=crearPosicionInicial();
        setColor(Color.BLANCO);
        setPosicion(posicionInicial);
        setEsDamaEspecial(setEsDamaEspecial());
    }
    public Dama(Color color){
        Posicion posicionInicial=crearPosicionInicial();
        setColor(color);
        setPosicion(posicionInicial);
        setEsDamaEspecial(setEsDamaEspecial());
    }



    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color ==null)
            throw new NullPointerException();
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }

    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }
    private boolean setEsDamaEspecial() {
        return false;
    }

    @Override
    public String toString() {
        return "Dama{" +
                "color=" + color +
                ", posicion=" + posicion +
                ", esDamaEspecial=" + esDamaEspecial +
                '}';
    }
}
