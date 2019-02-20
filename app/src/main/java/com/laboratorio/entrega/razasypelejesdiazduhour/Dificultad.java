package com.laboratorio.entrega.razasypelejesdiazduhour;

public abstract class Dificultad {
    public abstract int obtenerLayout(Interaccion interaccion);

    public abstract Jugada nuevaJugada(JugadaTipo jugadaTipo);
}