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

    @Override
    public void definirLayoutSegunConfiguracion() {

    }

}
