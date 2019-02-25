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

    /*
        Propósito: carga la palabra a reconocer ubicada en la parte superior.
     */
    @Override
    public void cargarPalabraAReconocer(MiniJuegoActivity miniJuegoActivity, String nombrePalabra){
        TextView palabraAReconocerFacil = (TextView) miniJuegoActivity.findViewById(R.id.palabraAReconocerFacil);
        palabraAReconocerFacil.setText(nombrePalabra);
    }

    /*
        Propósito: carga la imagen a reconocer ubicada en la parte superior.
     */
    @Override
    public void cargarImagenAReconocer(MiniJuegoActivity miniJuegoActivity, String nombreImagen){
        //se encuentra el imageview
        ImageView imagenGanadora = (ImageView) miniJuegoActivity.findViewById(R.id.imagenAReconocerFacil);
        //se setea el source del imageview
        imagenGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballoPorNombre(nombreImagen));
    }

    @Override
    public void cargarImagenGanadora(MiniJuegoActivity miniJuegoActivity, String nombreImagen) {

    }

    @Override
    public void cargarPalabraGanadora(MiniJuegoActivity miniJuegoActivity, String nombrePalabra) {

    }

    @Override
    public void cargarImagenesNoGanadoras(MiniJuegoActivity miniJuegoActivity) {

    }

    @Override
    public void cargarPalabrasNoGanadoras(MiniJuegoActivity miniJuegoActivity) {

    }


}
