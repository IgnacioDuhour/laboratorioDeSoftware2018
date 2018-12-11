package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RazaYPelajeActivity extends MiniJuegoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raza_ypelaje);
        comenzarAJugar();
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
        String str = this.miniJuego.tipoDeLaJugadaActual() +": "+ this.miniJuego.nombreAReconocerDeLaJugadaActual();
        itemTextView.setText(str);
    }

    /*
        Propósito: Carga el mensaje de la jugada ganada.
    */
    @Override
    public void cargarMensajeDeJugaGanada() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Jugada Ganada");
        //builder.setMessage("This is my message.");
        builder.setPositiveButton("Siguiente jugada", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                cargarJugadaSiguiente();
            }
        });
        builder.setNeutralButton("Volver a jugar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                reanudadJugadaActual();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /*
        * Propósito: Carga la próxima jugada para la jugada actual
        * Precondición: Existe una próxima jugada en el minijuego
    */
    @Override
    public void cargarJugadaSiguiente() {
        if (!this.miniJuego.esUltimaJugada()) {
            this.miniJuego.jugadaSiguiente(); //ver si puedo eliminar el if, viendo si puedo conocer cual es la ultima jugada
            cargarJugadaActual();
        } else {
            cargarSiguienteMiniJuego();
        }
    }
}
