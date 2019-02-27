package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Intent;

public class CruzaActivity extends MiniJuegoActivity {


    /*
        Propósito: Crea e iniciar el minijuego "Raza y Pelaje"
        Precondición: Ninguna
     */
    @Override
    public void iniciarMiniJuego() {
        this.miniJuego = new CruzaMiniJuego(this.dificultad);
        this.miniJuego.iniciar();
    }

    @Override
    public void reIniciarMiniJuego() {
        //TODO: completar
    }

    @Override
    public void feedbackVisualMiniJuegoGanado() {
        Intent i = new Intent(CruzaActivity.this, MiniJuegoCruzaGanadoActivity.class);
        startActivity(i);
    }

    /*
        Propósito: como no hay siguiente minijuego, regresa a Inicio
    */
    @Override
    public void cargarSiguienteMiniJuego() {
        Intent i = new Intent(CruzaActivity.this, MainActivity.class);
        startActivity(i);
    }
}
