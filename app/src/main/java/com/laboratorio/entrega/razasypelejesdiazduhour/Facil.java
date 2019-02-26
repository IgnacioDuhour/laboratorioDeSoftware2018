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
    public void cargarImagenesNoGanadoras(MiniJuegoActivity miniJuegoActivity) {

    }

    @Override
    public void cargarPalabrasNoGanadoras(MiniJuegoActivity miniJuegoActivity) {

    }

    /*
        Propósito: describe el identificador de una ImageView en el layout según una posicion, que representa la ubicación dentro de los elementos a interaccionar
    */
    @Override
    protected int idImageViewSegunPosicion(int posicion) {
        switch (posicion) {
            case 0:
                return R.id.imagenInteraccion0;
            case 1:
                return R.id.imagenInteraccion1;
            default:
                throw new IllegalArgumentException("Posicion de item inválida");
        }
    }

    /*
        Propósito: describe el identificador de una Textview en el layout según una posicion, que representa la ubicación dentro de los elementos a interaccionar
     */
    @Override
    protected int idTextViewSegunPosicion(int posicion) {
        switch (posicion) {
            case 0:
                return R.id.palabraInteraccion0;
            case 1:
                return R.id.palabraInteraccion1;
            default:
                throw new IllegalArgumentException("Posicion de item inválida");
        }
    }



}
