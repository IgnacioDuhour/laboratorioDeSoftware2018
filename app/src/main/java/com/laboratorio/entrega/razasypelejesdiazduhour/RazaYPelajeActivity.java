package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.os.Bundle;
import android.widget.TextView;

public class RazaYPelajeActivity extends MiniJuegoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.palabra_imagen_dificil);
        comenzarAJugar();
    }

    /*
        Propósito: crea un nuevo miniJuego y lo inicia inicia (por defecto es "Razas y Pelajes")
    */
    public void iniciarMiniJuego() {
        this.miniJuego = new MiniJuegoRazayPelaje();
        this.miniJuego.iniciarJuego();
    }

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
