package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RazaYPelajeActivity extends MiniJuegoActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*
        Propósito: Crea e iniciar el minijuego "Raza y Pelaje"
        Precondición: Ninguna
     */
    @Override
    public void iniciarMiniJuego() {
        this.miniJuego = new RazayPelajeMinijuego(this.dificultad);
        this.miniJuego.iniciar();
    }

    /*
        Propósito: Reinicia el MiniJuego Razas y Pelajes
        Precondición: Ninguna
    */
    public void reIniciarMiniJuego() {
        Intent i = new Intent(RazaYPelajeActivity.this, RazaYPelajeActivity.class);
        startActivity(i);
    }

    /*
        Propósito: genera un feedback visual para el minijuego ganado (papel picado)
        Precondición: Hay un minijuego ganado
    */
    @Override
    public void feedbackVisualMiniJuegoGanado() {
        //mostrar papel picado
    }
}


