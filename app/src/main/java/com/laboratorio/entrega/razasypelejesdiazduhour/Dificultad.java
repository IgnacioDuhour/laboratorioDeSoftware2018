package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class Dificultad extends AppCompatActivity { //o extends de AppCompatActivity, ver!!

    public abstract int obtenerLayout(Interaccion interaccion);

    public abstract Jugada nuevaJugada(JugadaTipo jugadaTipo);

    public abstract int cantidadDeElementos();

    /*
        Propósito: carga la palabra a reconocer ubicada en la parte superior.
     */
    public void cargarPalabraAReconocer(MiniJuegoActivity miniJuegoActivity, JugadaTipo jugadaTipo) {
        jugadaTipo.cargarPalabraAReconocer(miniJuegoActivity);
    }

    /*
        Propósito: carga la imagen a reconocer ubicada en la parte superior.
     */
    public void cargarImagenAReconocer(MiniJuegoActivity miniJuegoActivity, JugadaTipo jugadaTipo) {
       jugadaTipo.cargarImagenAReconocer(miniJuegoActivity);
    }

    /*
        Propósito: carga la palabra ganadora en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarPalabraGanadora(MiniJuegoActivity miniJuegoActivity, JugadaTipo jugadaTipo) {
        jugadaTipo.cargarPalabraGanadora(miniJuegoActivity);
    }

    /*
        Propósito: carga la imagen ganadora en la parte inferior del layout, donde se interaccionará para jugar
     */
    public void cargarImagenGanadora (MiniJuegoActivity miniJuegoActivity, JugadaTipo jugadaTipo) {
        jugadaTipo.cargarImagenGanadora(miniJuegoActivity);
    }

    /*
        Propósito: carga las imágenes NO ganadoras en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarImagenesNoGanadoras (MiniJuegoActivity miniJuegoActivity, JugadaTipo jugadaTipo) {
        jugadaTipo.cargarImagenesNoGanadoras(miniJuegoActivity);
    }

    /*
        Propósito: carga las palabras NO ganadoras en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarPalabrasNoGanadoras(MiniJuegoActivity miniJuegoActivity, JugadaTipo jugadaTipo) {
        jugadaTipo.cargarPalabrasNoGanadoras(miniJuegoActivity);
    }

    /*
        Propósito: carga la imagen ganadora de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarImagenGanadoraUltimaJugada (MiniJuegoActivity miniJuegoActivity, JugadaTipo jugadaTipo) {
        jugadaTipo.cargarImagenGanadoraUltimaJugada(miniJuegoActivity);
    }

    /*
        Propósito: carga las imagenes NO ganadoras de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarImagenesNoGanadoraUltimaJugada (MiniJuegoActivity miniJuegoActivity, JugadaTipo jugadaTipo){
        jugadaTipo.cargarImagenesNoGanadorasUltimaJugada(miniJuegoActivity);
    }

    /*
        Propósito: carga la palabra ganadora de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarPalabraGanadoraUltimaJugada (MiniJuegoActivity miniJuegoActivity, JugadaTipo jugadaTipo) {
        jugadaTipo.cargarPalabraGanadoraUltimaJugada(miniJuegoActivity);
    }

    /*
        Propósito: carga las palabras NO ganadoras de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarPalabrasNoGanadorasUltimaJugada (MiniJuegoActivity miniJuegoActivity, JugadaTipo jugadaTipo){
        jugadaTipo.cargarPalabrasNoGanadorasUltimaJugada(miniJuegoActivity);
    }

}