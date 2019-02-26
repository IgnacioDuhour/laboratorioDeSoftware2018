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

    /*
     * Propósito: describe el número que representa la ubicación de una imagen a partir del nombre de la imagen
     * Parámetro: "nombre" representa el nombre de una imágen ubicada en "res/drawable"
     */
    public int ubicacionDeImagenDeCaballo(String nombre) {
        switch (nombre.toUpperCase()) {
            case "CUARTO_DE_MILLA":
                return R.drawable.juana_cuarto_de_milla_bayo;
            case "CRIOLLO":
                return R.drawable.hualfin_criollo_picaso;
            case "PETISO_ARGENTINO":
                return R.drawable.pamperito_petiso_argentino_zaino;
            case "MESTIZO_CRUZA_ARABE":
                return R.drawable.ambar_mestizo_cruza_arabe_alazan_tostado;
            case "MESTIZO":
                return R.drawable.bionda_mestizo_alazan_ruano;
            case "SILLA_ARGENTINO":
                return R.drawable.primavera_silla_argentino_alazan;
            case "SANGREPUROCARRERA":
                return R.drawable.angola_sangrepuracarrera_zaino_colorado;
            default:
                return R.drawable.defaultfur;
        }
    }

}
