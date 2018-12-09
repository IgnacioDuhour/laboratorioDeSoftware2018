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

    /*
    Propósito: Retorna los pelajes, pero sin el pelaje "pelajeAEliminar"
*/
    private static Pelaje[] pelajesSinPelaje(Pelaje pelajeAEliminar){
        Pelaje[] pelajesSinPelaje = new Pelaje[Pelaje.cantidadDePelajes()-1];
        int i=0;
        for (Pelaje pelaje : Pelaje.values()) {
            if (pelaje!=pelajeAEliminar)  {
                pelajesSinPelaje[i] = pelaje;
            }
        }
        return pelajesSinPelaje;
    }

    /*
        Propósito: Genera una secuencia aleatórea de Pelajes a partir del parámetro "pelajes"
    */
    private static Pelaje[] pelajesAleatoreos(Pelaje[] pelajes) {
        Pelaje[] pelajesAleatoreos = new Pelaje[pelajes.length];
        for(int i=0; i<pelajes.length;i++) {
            pelajesAleatoreos[i] = pelajes[i];
        }
        int j;
        Pelaje aux;
        for(int i=0; i<pelajes.length;i++) {
            j = Aleatorio.entreMinyMax(0,i-1);
            aux = pelajesAleatoreos[i];
            pelajesAleatoreos[i] = pelajesAleatoreos[j];
            pelajesAleatoreos[j] = aux;
        }
        return pelajesAleatoreos;
    }

    /*
        Propósito: describe 3 Pelajes elegidas de forma aleatoreas, pero sin el Pelaje "pelaje"
        Precondición: Hay al menos 3 Pelajes
    */
    private static Pelaje[] tresPelajesAleatoreosSinElPelaje(Pelaje pelaje){
        Pelaje[] pelajesSinPelaje = Pelaje.pelajesSinPelaje(pelaje);
        Pelaje[] pelajesAleatoreosSinElPelaje = Pelaje.pelajesAleatoreos(pelajesSinPelaje);
        Pelaje[] tresPelajesAleatoreosSinElPelaje = new Pelaje[3];
        tresPelajesAleatoreosSinElPelaje[0] = pelajesAleatoreosSinElPelaje[0];
        tresPelajesAleatoreosSinElPelaje[1] = pelajesAleatoreosSinElPelaje[1];
        tresPelajesAleatoreosSinElPelaje[2] = pelajesAleatoreosSinElPelaje[2];
        return tresPelajesAleatoreosSinElPelaje;
    }

    /*
        Propósito: describe 4 Pelajes elegidos de forma aleatoreas, incluyendo el Pelaje del parámetro "pelaje"
        Precondición: Hay al menos 3 Pelajes
    */
    public static Pelaje[] cuatroPelajesAleatoreosConElPelaje(Pelaje pelaje) {
        Pelaje[] cuatroPelajesConElPelaje = new Pelaje[4];
        Pelaje [] tresPelajesAleatoreos = tresPelajesAleatoreosSinElPelaje(pelaje);
        cuatroPelajesConElPelaje[0] = tresPelajesAleatoreos[0];
        cuatroPelajesConElPelaje[1] = tresPelajesAleatoreos[1];
        cuatroPelajesConElPelaje[2] = tresPelajesAleatoreos[2];
        cuatroPelajesConElPelaje[3] = pelaje;
        return Pelaje.pelajesAleatoreos(cuatroPelajesConElPelaje);
    }

}
