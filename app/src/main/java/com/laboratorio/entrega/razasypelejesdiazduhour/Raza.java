package com.laboratorio.entrega.razasypelejesdiazduhour;

public enum Raza {
    ANDALUS,
    APPALOSA,
    ARABE,
    AZTECA,
    CLYDESDALE,
    CRIOLLOAMERICANO,
    CUARTODEMILA,
    FALABELLA,
    FRISON,
    HAFLINGER,
    HANNOVERIANO,
    LUSITANO,
    MUSTANG,
    PALOMINO,
    PASOFINO,
    PERCHERON,
    PONIFELL,
    PONIPOLO,
    PURASANGRE,
    SHIRE;

    public static String[] todasLasRazas() {
        String[] todasLasRazas = new String[Raza.values().length];
        Raza[] razas = Raza.values();
        for (int i=0; i<Raza.values().length;i++){
            todasLasRazas[i] = razas[i].toString().toLowerCase();
        }
        return todasLasRazas;
    }

    public static int cantidadDeRazas(){
        return Raza.values().length;
    }
}
