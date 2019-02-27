package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Intent;
import android.os.Bundle;

public class RazayPelajeJuntasActivity extends MiniJuegoActivity {


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
        this.miniJuego = new RazayPelajeJuntasMiniJuego(this.dificultad);
        this.miniJuego.iniciar();
    }

    /*
        Propósito: Reinicia el MiniJuego Razas y Pelajes
        Precondición: Ninguna
    */
    @Override
    public void reIniciarMiniJuego() {
        Intent i = new Intent(RazayPelajeJuntasActivity.this, RazaYPelajeActivity.class);
        startActivity(i);
    }

    /*
        Propósito: carga el siguiente minijuego siendo este Cruza
    */
    @Override
    public void cargarSiguienteMiniJuego() {
        Intent i = new Intent(RazayPelajeJuntasActivity.this, CruzaActivity.class);
        startActivity(i);
    }

    @Override
    public void feedbackVisualMiniJuegoGanado() {
        //mostrar papel picado
        /*
        pasos:
        1. nueva acitvity: MiniJuegoGanado
        2. 2 componentes: Gif y boton "ir a inicio" y boton "ir a siguiente minijuego"
         */
        Intent i = new Intent(RazayPelajeJuntasActivity.this, MiniJuegoGanado.class);
        startActivity(i);
    }
}
