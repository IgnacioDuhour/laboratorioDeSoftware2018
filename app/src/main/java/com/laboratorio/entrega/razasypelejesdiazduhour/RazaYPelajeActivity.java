package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.os.Bundle;
import android.widget.TextView;

public class RazaYPelajeActivity extends MiniJuegoActivity {

    /*
        Propósito: Crea e iniciar el minijuego "Raza y Pelaje"
        Precondición: Ninguna
     */
    @Override
    public void iniciarMiniJuego() {
        this.miniJuego = new RazayPelajeMinijuego();
        this.miniJuego.iniciar();
    }

    /*
    * Propósito: Selecciona el layout segun configuración
    * Precondición: Hay un minijuego de "Raza y Pelaje" incializado
    * Observación: Existen 4 (cuatro) tipos de layouts:
            1. layout imagen_palabra_facil
            2. layout imagen_palabra_dificil
            3. layout palabra_imagen_facil
            4. layout palabra_imagen_dificil
     */
    @Override
    public void definirLayoutSegunConfiguracion() {
        setContentView(R.layout.palabra_imagen_dificil);
    }

    @Override
    public void cargarItemGanadorUltimaJugada() {

    }

    @Override
    public void cargarItemsNoGanadoresUltimaJugada() {

    }

    //se encuentra el imageview
    //ImageView imagenGanadora = (ImageView) findViewById(idImageViewParaPosicionDeJugada(posicionItemGanadorDeJugadaActual()));
    //se setea el source del imageview
    //imagenGanadora.setImageResource(ubicacionDeImagenDeCaballoPorNombre(this.miniJuego.nombreAReconocerDeLaJugadaActual()));
    //se define el evento para el imageview
    //cargarEventoOnClickParaImagenGanadora(imagenGanadora);


    /*
     * Propósito: Carga el item principal de la jugada actual de una partida
     * Observación:
        * "item":  puede ser texto o imagen.
        * "cargar": hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla.
     */
    @Override
    public void cargarItemPrincipalDeLaJugadaActual() {
        TextView itemTextView = (TextView) findViewById(R.id.minijuegoPrincipal);
        String str = this.miniJuego.tipoDeLaJugadaActual() + ": " + this.miniJuego.nombreAReconocerDeLaJugadaActual();
        itemTextView.setText(str);
    }
}
