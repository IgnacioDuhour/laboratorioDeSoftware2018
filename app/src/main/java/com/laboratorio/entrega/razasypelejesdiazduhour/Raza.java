package com.laboratorio.entrega.razasypelejesdiazduhour;

import java.util.Random;

public enum Raza {
    CUARTO_DE_MILLA,
    CRIOLLO,
    PETIZO_ARGENTINO,
    MESTIZO_CRUZA_ARABE,
    MESTIZO,
    SILLA_ARGENTINO,
    SANGREPUROCARRERA;

    public static int cantidadDeRazas() {
        return Raza.values().length;
    }

}
