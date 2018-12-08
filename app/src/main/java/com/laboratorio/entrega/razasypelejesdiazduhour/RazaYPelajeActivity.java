package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RazaYPelajeActivity extends AppCompatActivity {

    private MiniJuego miniJuego;
    private Jugada jugadaActual; //contiene la jugada actual de minijuego

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raza_ypelaje);

        nuevoMiniJuego();
    }

    public void nuevoMiniJuego(){
        this.miniJuego = new MiniJuego();
        this.jugadaActual = this.miniJuego.jugadaActual();
        this.miniJuego.iniciarJuego();
    }

    public void reanudadJugadaActual() {

    }

    public void pasarAPróximaJugada() {

    }

    public void volverAPantallaPrincipal(View view) {
        Intent i = new Intent(RazaYPelajeActivity.this, MainActivity.class);
        startActivity(i);
    }
}
