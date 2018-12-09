package com.laboratorio.entrega.razasypelejesdiazduhour;

import java.util.Random;

abstract class Jugada {

    //private TipoJugada tipoJugada; //describe si  la jugada es de tipo "RAZA" o "PELAJE"
    protected String nombreAReconocer; //nombre que reconocerá el jugador: corresponde a una RAZA o PELAJE

    public boolean esJugadaGanada(String nombreJugadaActual){
        return this.nombreAReconocer.compareTo(nombreJugadaActual) == 0;
    }

    /*
        Propósito: describe el tipo de jugada que corresponde a la subclase
     */
    public abstract String tipoDeJugada();


    /*
        Propósito: Reanuda la jugada de la partida
     */
    public abstract Jugada reanudadJugada();

    public abstract String[] nombreDeLasJugadas();

}
