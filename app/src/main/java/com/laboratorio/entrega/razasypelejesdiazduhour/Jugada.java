package com.laboratorio.entrega.razasypelejesdiazduhour;

abstract class Jugada {

    //private TipoJugada tipoJugada; //describe si  la jugada es de tipo "RAZA" o "PELAJE"
    protected String nombreAReconocer; //nombre que reconocerá el jugador: corresponde a una RAZA o PELAJE
    protected InteraccionConImagenesDeCaballos[] interaccionConimagenesDeCaballos; //colleción de imágenes con las que interaccionará el jugador
    protected ReconocimientoTexto reconocimientoTexto; //texto que reconocerá el jugador en las imágenes con las que interaccionará
    protected int NIVEL_DIFICULTAD_2 = 4; //describe el n° 4  que representa la cantidad de imágenes con las que interaccionará el jugador



    public boolean esJugadaGanada(String nombreJugadaActual){
        return this.nombreAReconocer.compareTo(nombreJugadaActual) == 0;
    }

    public abstract String tipoDeJugada();

}
