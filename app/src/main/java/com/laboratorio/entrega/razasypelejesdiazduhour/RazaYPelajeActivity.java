package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RazaYPelajeActivity extends AppCompatActivity {

    private MiniJuego miniJuego;
    //private Jugada jugadaActual; //contiene la jugada actual de minijuego

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raza_ypelaje);

        nuevoMiniJuego();
        cargarTextoAReconocer();
        cargarImagenesDeCaballos();
    }

    public void nuevoMiniJuego(){
        this.miniJuego = new MiniJuego();
        //this.jugadaActual = this.miniJuego.jugadaActual();
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

    public void cargarTextoAReconocer() {
        TextView itemTextView = (TextView) findViewById(R.id.razaypelajeAReconocer);
        String str = this.miniJuego.tipoDeLaJugadaActual() +": "+ this.miniJuego.nombreAReconocerDeLaJugadaActual();
        itemTextView.setText(str);
    }

    public void cargarImagenesDeCaballos(){
        //this.miniJuego.imagenesDeCaballos();
        //obtener de minijuego las 4 imagenes de caballos
        // encontrar en el layout por id
        // setear el recurso img con los valores obtenidos
        String[] nombresDeLaJugadaActual = this.miniJuego.nombresDeLaJugadaActual();
        final ImageView imgCaballo1 = (ImageView) findViewById(R.id.razaypelajeImageView1);
        imgCaballo1.setImageResource(getDrawableValueByImage(nombresDeLaJugadaActual[0]));
        final ImageView imgCaballo2 = (ImageView) findViewById(R.id.razaypelajeImageView2);
        imgCaballo2.setImageResource(getDrawableValueByImage(nombresDeLaJugadaActual[1]));
        final ImageView imgCaballo3 = (ImageView) findViewById(R.id.razaypelajeImageView3);
        imgCaballo3.setImageResource(getDrawableValueByImage(nombresDeLaJugadaActual[2]));
        final ImageView imgCaballo4 = (ImageView) findViewById(R.id.razaypelajeImageView4);
        imgCaballo4.setImageResource(getDrawableValueByImage(nombresDeLaJugadaActual[3]));
    }

    private int getDrawableValueByImage(String nameImg) {
        //pasar los cases a minuscula
        switch (nameImg.toUpperCase()) {
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
            case "PURASANGRE": return R.drawable.purasangre;
            case "SHIRE": return R.drawable.shire;
            default: return R.drawable.defaultfur;
        }
    }

    /*
    public String[] idsImageViewCaballos() {
        return new String[]{"razaypelajeImageView1", "razaypelajeImageView2", "razaypelajeImageView3", "razaypelajeImageView4"};
    }*/

}
