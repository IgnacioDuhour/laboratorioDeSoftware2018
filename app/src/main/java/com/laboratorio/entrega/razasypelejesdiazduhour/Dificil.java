package com.laboratorio.entrega.razasypelejesdiazduhour;

public class Dificil extends Dificultad {
    @Override
    public int obtenerLayout(Interaccion interaccion) {
        return interaccion.obtenerLayoutDificil();
    }
}
