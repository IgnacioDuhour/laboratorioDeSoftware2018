package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CruzaActivity extends MiniJuegoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cruza);
        comenzarAJugar();
    }

    /*
        Propósito: crea un nuevo miniJuego y lo inicia inicia (por defecto es "Razas y Pelajes")
    */
    public void iniciarMiniJuego(){
        this.miniJuego = new MiniJuegoCruza();
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
        ImageView imagenPrincipal = (ImageView) findViewById(R.id.cruzaImagenPrincipal);
        imagenPrincipal.setImageResource(ubicacionDeImagenDeCaballoPorNombre(this.miniJuego.nombreAReconocerDeLaJugadaActual()));
    }

    /*
        * Propósito: Carga la próxima jugada para la jugada actual
        * Precondición: Existe una próxima jugada en el minijuego
     */
    @Override
    public void cargarJugadaSiguiente() {
        if (!this.miniJuego.esUltimaJugada()) {
            this.miniJuego.jugadaSiguiente(); //ver si puedo eliminar el if, viendo si puedo conocer cual es la ultima jugada, y a la última jugada definirle el evento "mensajeDeMiniJuegoFinalizado"
            cargarJugadaActual();
        } else {
            cargarMensajejeDeMiniJuegoFinalizado();
        }
    }

    protected int idImageViewParaPosicionDeJugada(int posicion) {
        switch (posicion) {
            case 0: return R.id.cruzaImageView0;
            case 1: return R.id.cruzaImageView1;
            case 2: return R.id.cruzaImageView2;
            case 3: return R.id.cruzaImageView3;
            default: throw new IllegalArgumentException("Posicion de jugada inválida");
        }
    }

}
