package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.widget.ImageView;
import android.widget.TextView;

public class Facil extends Dificultad {

    @Override
    public int obtenerLayout(Interaccion interaccion) {
        return interaccion.obtenerLayoutFacil();
    }

    public int cantidadElementos() { return 2; }

    public Jugada nuevaJugada(JugadaTipo jugadaTipo) {
        return new JugadaDificultadFacil(jugadaTipo);
    }

    @Override
    public int cantidadDeElementos() {
        return 2;
    }


}
