package com.laboratorio.entrega.razasypelejesdiazduhour;

public class TipoPelaje extends TipoCaballo {

    private Pelaje pelaje;

    /*
        Propósito: Constructor de la clase
     */
    public TipoPelaje(Pelaje pelaje) {
        this.pelaje = pelaje;
        this.nombre = pelaje.toString().toLowerCase();
    }

    /*
        Propósito: describe todos nombres de los pelajes (en minúscula)
    */
    public static String[] nombresDeLosPelajes() {
        String[] todosLosPelajes = new String[Pelaje.values().length];
        Pelaje[] pelajes = Pelaje.values();
        for (int i = 0; i < Pelaje.values().length; i++) {
            todosLosPelajes[i] = pelajes[i].toString().toLowerCase();
        }
        return todosLosPelajes;
    }

    /*
        Propósito: Describe la cantidad de pelajes existentes
     */
    public static int cantidadDePelajes() {
        return Pelaje.values().length;
    }

    /*
        Propósito: describe los tipos de pelajes elegidas de forma aleatoreas, incluyendo el tipo de pelaje "tipoPelaje"
        Precondición: Hay al menos "cantidadDePelajes" definidas en TipoPelaje
    */
    public static TipoPelaje[] tiposDePelajesAleatoreasConElPelaje(TipoPelaje tipoPelaje, int cantidadDePelajes) {
        TipoPelaje[] cuatroTiposDePelajesAleatoreas = new TipoPelaje[cantidadDePelajes];
        TipoPelaje[] tresTiposDePelajesAleatoreas = tresTiposDePelajesAleatoreasSinElPelaje(tipoPelaje); //generalizar a cantidadDePelajes-1, no a tres (3)
        cuatroTiposDePelajesAleatoreas[0] = tresTiposDePelajesAleatoreas[0];
        cuatroTiposDePelajesAleatoreas[1] = tresTiposDePelajesAleatoreas[1];
        cuatroTiposDePelajesAleatoreas[2] = tresTiposDePelajesAleatoreas[2];
        cuatroTiposDePelajesAleatoreas[3] = tipoPelaje;
        return TipoPelaje.tiposDePelajesAleatoreas(cuatroTiposDePelajesAleatoreas);
    }

    /*
        Propósito: describe todos los tipos de pelajes en función de la cantidad de pelajes existentes
     */
    public static TipoPelaje[] todosLosTiposDePelajes() {
        TipoPelaje[] todosLosTiposDePelajes = new TipoPelaje[Pelaje.cantidadDePelajes()];
        int i = 0;
        for (Pelaje pelaje : Pelaje.values()) {
            todosLosTiposDePelajes[i] = new TipoPelaje(pelaje);
            i++;
        }
        return todosLosTiposDePelajes;
    }

    /*
        Propósito: describe la pelaje
     */
    public Pelaje getPelaje() {
        return this.pelaje;
    }
    /*
        Propósito: Retorna las pelajes, pero sin la pelaje "pelajeAEliminar"
    */
    private static TipoPelaje[] tipoDePelajesSinTipoDePelaje(TipoPelaje[] tiposDePelajes, TipoPelaje tipoPelajeAEliminar) {
        TipoPelaje[] tiposDePelajesSinElTipoPelaje = new TipoPelaje[Pelaje.cantidadDePelajes() - 1];
        int i = 0;
        for (TipoPelaje tipoDePelaje : tiposDePelajes) {
            if (tipoDePelaje.pelaje != tipoPelajeAEliminar.pelaje) {
                tiposDePelajesSinElTipoPelaje[i] = tipoDePelaje;
                i++;
            }
        }
        return tiposDePelajesSinElTipoPelaje;
    }

    /*
        Propósito: Genera una secuencia aleatórea de Pelajes a partir del parámetro "pelajes"
    */
    private static TipoPelaje[] tiposDePelajesAleatoreas(TipoPelaje[] tipoPelajes) {
        TipoPelaje[] tipoDePelajesAleatoreas = tipoPelajes;
        for (int i = 0; i < tipoPelajes.length; i++) {
            tipoDePelajesAleatoreas[i] = tipoPelajes[i];
        }
        int j;
        TipoPelaje aux;
        for (int i = 1; i < tipoDePelajesAleatoreas.length; i++) {
            j = Aleatorio.entreMinyMax(0, i - 1);
            aux = tipoDePelajesAleatoreas[i];
            tipoDePelajesAleatoreas[i] = tipoDePelajesAleatoreas[j];
            tipoDePelajesAleatoreas[j] = aux;
        }
        return tipoDePelajesAleatoreas;
    }

    /*
        Propósito: describe 3 Pelajes elegidas de forma aleatoreas, pero sin la Pelaje "pelaje"
        Precondición: Hay al menos 3 Pelajes
    */
    private static TipoPelaje[] tresTiposDePelajesAleatoreasSinElPelaje(TipoPelaje tipoPelaje) {
        //obtengo todos los pelajes sin la pelaje "tipoPelaje"
        TipoPelaje[] tipoDePelajesSinTipoDePelaje = TipoPelaje.tipoDePelajesSinTipoDePelaje(TipoPelaje.todosLosTiposDePelajes(), tipoPelaje);
        //generar los pelajes aleatoreas a partir de  pelajesSinPelajeAReconocer
        TipoPelaje[] tiposDePelajesAleatoreasSinElTipoPelaje = TipoPelaje.tiposDePelajesAleatoreas(tipoDePelajesSinTipoDePelaje);
        TipoPelaje[] tresTiposDePelajesAleatoreasSinElPelaje = new TipoPelaje[3];
        //obtengo los 3 pelajes
        tresTiposDePelajesAleatoreasSinElPelaje[0] = tipoDePelajesSinTipoDePelaje[0];
        tresTiposDePelajesAleatoreasSinElPelaje[1] = tipoDePelajesSinTipoDePelaje[1];
        tresTiposDePelajesAleatoreasSinElPelaje[2] = tipoDePelajesSinTipoDePelaje[2];
        return tresTiposDePelajesAleatoreasSinElPelaje;
    }

}
