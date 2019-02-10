package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private  MiniJuegoActivity minijuegActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarMinijuegoActual();
        cargarMensajeIntegrantes();
    }

    /*
        Propósito: se inicializa con el primer minijuego.
        Observación: El primer minijuego corresponde a RazaYPelaje
     */
    public void inicializarMinijuegoActual() {
        this.minijuegActual = new RazaYPelajeActivity();
    }


    /*
        Propósito: crea y carga en la pantalla de inicio un boton que despliega un mensaje (pop up) con los integrantes del grupo 5
     */
    public void cargarMensajeIntegrantes() {
        final Activity act = this;

        ImageButton aboutButton = act.findViewById(R.id.imageButton2);
        aboutButton.setOnClickListener((View v) -> {
                    AlertDialog.Builder about = new AlertDialog.Builder(act);
                    about.setMessage(R.string.about_message)
                            .setCancelable(false)
                            .setPositiveButton(R.string.about_dialog_btn, (DialogInterface dialog, int which) ->
                                    dialog.dismiss()
                            );
                    AlertDialog alert = about.create();
                    alert.setTitle(R.string.about_title);
                    alert.show();
                }
        );
    }

    /*
        Propósito: Carga la actividad correspondiente a minijuegoActual pudiendo ser "RazaYPelaje", "RazaYPelajeJuntas" o "Cruzas"
     */
    public void jugarMinijuego(View view) {
        Intent i = new Intent(MainActivity.this, getMiniJuegoActual().getClass());
        startActivity(i);
    }

    /*
        Propósito: obtiene la actividad correspondiente al minijuego según la configuración "Minijuego"
     */
    private MiniJuegoActivity getMiniJuegoActual() {
        //TODO: el minijuego lo debe levantar de la configuracion, pudiente ser RyP, RyPJuntas o Cruzas
        return this.minijuegActual;
    }

    /**Called when the user taps the "Reconocimiento" button */
    public void playRecognitionMode(View view) {
        Intent i = new Intent(MainActivity.this, ReconocimientoActivity.class);
        startActivity(i);
    }

    /**
     * Called when the user taps the icon "configuration"
     */
    public void settings(View view) {
        Intent i = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(i);
    }

}


