package com.laboratorio.entrega.razasypelejesdiazduhour;

public enum Pelaje {
    ALBO,
    ATIGRADO,
    BAYO,
    BRAGADO,
    COLORADO,
    MELADO,
    PANGARE,
    ZAINO;

    /*
        Propósito: Describe la cantidad de pelajes existentes
    */
    public static int cantidadDePelajes() {
        return Pelaje.values().length;
    }

}