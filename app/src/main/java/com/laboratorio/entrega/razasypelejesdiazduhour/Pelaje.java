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

    public static String[] todosLosPelajes() {
        String[] todosLosPelajes = new String[Pelaje.values().length];
        Pelaje[] pelajes = Pelaje.values();
        for (int i=0; i<Pelaje.values().length;i++){
            todosLosPelajes[i] = pelajes[i].toString().toLowerCase();
        }
        return todosLosPelajes;
    }

    public static int cantidadDePelajes(){
        return Pelaje.values().length;
    }
}
