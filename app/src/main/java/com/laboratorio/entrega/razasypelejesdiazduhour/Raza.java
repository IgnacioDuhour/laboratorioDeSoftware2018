package com.laboratorio.entrega.razasypelejesdiazduhour;

import java.util.Random;

public enum Raza {
    ANDALUS,
    APPALOSA,
    ARABE,
    AZTECA,
    CLYDESDALE,
    COMTIOS,
    CRIOLLO,
    CRIOLLOAMERICANO,
    CRIOLLOARGENTINO,
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
    SHIRE,
    SORAIA;

    public static String[] todasLasRazas() {
        String[] todasLasRazas = new String[Raza.values().length];
        Raza[] razas = Raza.values();
        for (int i = 0; i < Raza.values().length; i++) {
            todasLasRazas[i] = razas[i].toString().toLowerCase();
        }
        return todasLasRazas;
    }

    public static int cantidadDeRazas() {
        return Raza.values().length;
    }

    /*
        Propósito: Retorna las razas, pero sin la raza "razaAEliminar"
    */
    private static Raza[] razasSinRaza(Raza razaAEliminar) {
        Raza[] razasSinRaza = new Raza[Raza.cantidadDeRazas() - 1];
        int i = 0;
        for (Raza raza : Raza.values()) {
            if (raza != razaAEliminar) {
                razasSinRaza[i] = raza;
                i++;
            }
        }
        return razasSinRaza;
    }

    /*
        Propósito: Genera una secuencia aleatórea de Razas a partir del parámetro "razas"
    */
    private static Raza[] razasAleatoreas(Raza[] razas) {
        Raza[] razasAleatoreas = new Raza[razas.length];
        for (int i = 0; i < razas.length; i++) {
            razasAleatoreas[i] = razas[i];
        }
        int j;
        Raza aux;
        for (int i = 1; i < razas.length; i++) {
            j = Aleatorio.entreMinyMax(0, i - 1);
            aux = razasAleatoreas[i];
            razasAleatoreas[i] = razasAleatoreas[j];
            razasAleatoreas[j] = aux;
        }
        return razasAleatoreas;
    }

    /*
        Propósito: describe 3 Razas elegidas de forma aleatoreas, pero sin la Raza "raza"
        Precondición: Hay al menos 3 Razas
    */
    private static Raza[] tresRazasAleatoreasSinLaRaza(Raza raza) {
        //razasSinRazaAReconocer = obtener los valores de Razas sin la raza "sinLaRaza"
        Raza[] razasSinLaRaza = Raza.razasSinRaza(raza);
        //generar las razas aleatoreas a partir de  razasSinRazaAReconocer
        Raza[] razasAleatoreasSinLaRaza = Raza.razasAleatoreas(razasSinLaRaza);
        Raza[] tresRazasAleatoreasSinLaRaza = new Raza[3];
        //obtengo las 3 razas
        tresRazasAleatoreasSinLaRaza[0] = razasAleatoreasSinLaRaza[0];
        tresRazasAleatoreasSinLaRaza[1] = razasAleatoreasSinLaRaza[1];
        tresRazasAleatoreasSinLaRaza[2] = razasAleatoreasSinLaRaza[2];
        return tresRazasAleatoreasSinLaRaza;
    }

    /*
        Propósito: describe una cantidad de Razas elegidas de forma aleatoreas, incluyendo la raza del parámetro "raza"
        Precondición: Hay al menos "cantidadDeRazas" definidas en Razas
    */
    public static Raza[] razasAleatoreasConLaRaza(Raza raza, int cantidadDeRazas) {
        Raza[] cuatroRazasAleatoreas = new Raza[cantidadDeRazas];
        Raza[] tresRazasAleatoreas = tresRazasAleatoreasSinLaRaza(raza); //generalizar a cantidadDeRazas-1, no a tres (3)
        cuatroRazasAleatoreas[0] = tresRazasAleatoreas[0];
        cuatroRazasAleatoreas[1] = tresRazasAleatoreas[1];
        cuatroRazasAleatoreas[2] = tresRazasAleatoreas[2];
        cuatroRazasAleatoreas[3] = raza;
        return Raza.razasAleatoreas(cuatroRazasAleatoreas);
    }

    public static void main(String[] args) {
        //imprimirValores(Raza.razasSinRaza(Raza.FRISON));
        //imprimirValores(Raza.razasAleatoreas(Raza.values()));
        //System.out.println(Raza.razasAleatoreas(Raza.values()).length); //20
        //imprimirValores(Raza.tresRazasAleatoreasSinLaRaza(Raza.HAFLINGER));
        //imprimirValores(Raza.cuatroRazasAleatoreasConLaRaza(Raza.ARABE));

    }

    private static void imprimirValores(Raza[] r) {
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }
}