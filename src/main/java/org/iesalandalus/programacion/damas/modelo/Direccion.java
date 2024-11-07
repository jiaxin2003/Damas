package org.iesalandalus.programacion.damas.modelo;

public enum Direccion {
    NORESTE ("Noreste"), SURESTE("Sureste"), SUROESTE("Suroeste"), NOROESTE("Noroeste");

    private String cadenaAMostrar;
    private Direccion(String cadenaAMostrar)
    {
        this.cadenaAMostrar= this.cadenaAMostrar;
    }

    @Override
    public String toString() {
        return ordinal()+".-"+cadenaAMostrar;
    }
}
