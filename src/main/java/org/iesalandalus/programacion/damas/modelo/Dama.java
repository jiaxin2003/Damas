package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
import java.beans.beancontext.BeanContextServicesListener;
import java.io.ObjectStreamException;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;


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

                int nuevaFila = posicion.getFila();
                char nuevaColumna = posicion.getColumna();

                switch (direccion) {
                    case NORESTE -> {
                        nuevaFila++;
                        nuevaColumna++;
                    }
                    case NOROESTE -> {
                        nuevaFila++;
                        nuevaColumna--;
                    }
                }
                }else if (color ==Color.NEGRO){
                if (direccion== Direccion.NORESTE || direccion == Direccion.NOROESTE) {
                    throw new OperationNotSupportedException("ERROR: El movimiento que haces no esta permitido las damas solo pueden ir hacia delante y diogonal");
                }
            } else if (pasos>1) {
                throw new OperationNotSupportedException("ERROR: la Dama no es Dama especial lo cuál hace que no pueda moverse mas de una casilla");
            } int nuevaFila = posicion.getFila();
            char nuevaColumna = posicion.getColumna();
            switch (direccion) {
                case SURESTE -> {
                    nuevaFila--;
                    nuevaColumna++;
                }
                case SUROESTE -> {
                    nuevaFila--;
                    nuevaColumna--;
                }
            }
        }else {
            int nuevaFila = posicion.getFila();
            char nuevaColumna = posicion.getColumna();
            switch (direccion) {
                case NORESTE -> {
                    nuevaFila++;
                    nuevaColumna++;
                }
                case NOROESTE -> {
                    nuevaFila++;
                    nuevaColumna--;
                }
                case SURESTE -> {
                    nuevaFila--;
                    nuevaColumna++;
                }
                case SUROESTE -> {
                    nuevaFila--;
                    nuevaColumna--;
                }
            }
        }
    }


    public Dama(){
        Posicion posicionInicial=crearPosicionInicial();
        setColor(Color.BLANCO);
        setPosicion(posicionInicial);
        this.esDamaEspecial=false;
    }
    public Dama(Color color){
        Posicion posicionInicial=crearPosicionInicial();
        setColor(color);
        setPosicion(posicionInicial);
        this.esDamaEspecial=false;
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

    @Override
    public String toString() {
        return "Dama{" +
                "color=" + color +
                ", posicion=" + posicion +
                ", esDamaEspecial=" + esDamaEspecial +
                '}';
    }
}
