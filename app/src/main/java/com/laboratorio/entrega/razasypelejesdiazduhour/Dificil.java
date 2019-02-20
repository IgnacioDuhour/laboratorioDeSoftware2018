package com.laboratorio.entrega.razasypelejesdiazduhour;

public class Dificil extends Dificultad {
    @Override
    public int obtenerLayout(Interaccion interaccion) {
        return interaccion.obtenerLayoutDificil();
    }

    public int cantidadElementos() { return 4; }

    public Jugada nuevaJugada(JugadaTipo jugadaTipo) {
        return new JugadaDificultadDificil(jugadaTipo);
    }
}
