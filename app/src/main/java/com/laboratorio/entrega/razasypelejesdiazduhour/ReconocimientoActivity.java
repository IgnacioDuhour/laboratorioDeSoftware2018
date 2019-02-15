package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class ReconocimientoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        Boolean b = preferences.getBoolean("lista", true);
        if (b) {
            setContentView(R.layout.activity_reconocimiento);
        } else {
            setContentView(R.layout.activity_reconocimiento_grid);
        }
    }
    public abstract void cargarReconocimiento();
    /*

        Propósito: Evento del boton volver que regresa a la pantalla de Principal (MainActivity)
    */
    public void volver(View view) {
        Intent i = new Intent(ReconocimientoActivity.this, MainActivity.class);
        startActivity(i);
    }

    protected int ubicacionDeImagenDeCaballoPorNombre(String nombre) {
        switch (nombre.toUpperCase()) {
            case "ALBO": return R.drawable.albo;
            case "ATIGRADO": return R.drawable.atigrado;
            case "BAYO": return R.drawable.bayo;
            case "BRAGADO": return R.drawable.bragado;
            case "COLORADO": return R.drawable.colorado;
            case "MELADO": return R.drawable.melado;
            case "PANGARE": return R.drawable.pangare;
            case "ZAINO": return R.drawable.zaino;
            case "ANDALUS": return R.drawable.andaluz;
            case "APPALOSA": return R.drawable.appalosa;
            case "ARABE": return R.drawable.arabe;
            case "AZTECA": return R.drawable.azteca;
            case "CLYDESDALE": return R.drawable.clydesdale;
            case "COMTIOS": return R.drawable.comtios;
            case "CRIOLLO": return R.drawable.criollo;
            case "CRIOLLOARGENTINO": return R.drawable.criolloargentino;
            case "CRIOLLOAMERICANO": return R.drawable.criolloamericano;
            case "CUARTODEMILA": return R.drawable.cuartodemila;
            case "FALABELLA": return R.drawable.falabella;
            case "FRISON": return R.drawable.frison;
            case "HAFLINGER": return R.drawable.haflinger;
            case "HANNOVERIANO": return R.drawable.hannoveriano;
            case "LUSITANO": return R.drawable.lusitano;
            case "MUSTANG": return R.drawable.mustang;
            case "PALOMINO": return R.drawable.palomino;
            case "PASOFINO": return R.drawable.pasofino;
            case "PERCHERON": return R.drawable.percheron;
            case "PONIFELL": return R.drawable.ponifell;
            case "PONIPOLO": return R.drawable.ponipolo;
            case "PURASANGREINGLES": return R.drawable.purasangreingles;
            case "SHIRE": return R.drawable.shire;
            case "SORAIA": return R.drawable.soraia;
            default: return R.drawable.defaultfur;
        }
    }
}
