package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
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
        cargarJugadaActual();
    }

    /*
        Propósito: inicia el minijuego definido en Settings (inicialmente por defecto en "Razas y Pelajes").
     */
    public void nuevoMiniJuego(){
        this.miniJuego = new MiniJuego();
        this.miniJuego.iniciarJuego();
    }

    /*
        Propósito: Carga la jugada actual compuesta por
        * 1. nombre de una Raza o de un Pelaje
        * 2. cuatro (4) imágenes con las que se interaccionará
     */
    public void cargarJugadaActual() {
        cargarNombreDeLaJugadaActual();
        cargarImagenesDeLaJugadaActual();
    }

    /*
        Propósito: Carga el nombre de una Raza o Pelaje de la jugada actual de una partida de tipo Interacción B. El nombre representa el texto que se reconocerá en las imágenes.
     */
    public void cargarNombreDeLaJugadaActual() {
        TextView itemTextView = (TextView) findViewById(R.id.razaypelajeAReconocer);
        String str = this.miniJuego.tipoDeLaJugadaActual() +": "+ this.miniJuego.nombreAReconocerDeLaJugadaActual();
        itemTextView.setText(str);
    }

    /*
        Propósito: Carga las imágenes de los caballos con las que interaccionará el jugador. Por defecto toma el nivel de dificuld 2 (4 imágenes)
     */
    public void cargarImagenesDeLaJugadaActual(){
        cargarImagenGanadora();
        cargarImagenesNoGanadoras();
    }

    /*
        Propósito: Carga la imágen del caballo ganadora en la posición correspondiente, pudiendo ser alguna de las posiciones 1,2,3 ó 4.
        Precondición: Existe la imagen ganadora
     */
    public void cargarImagenGanadora() {
        ImageView imagenGanadora = imageViewParaImagenGanadora();
        cargarEventoOnClickParaImagenGanadora(imagenGanadora);
    }

    /*
        Propósito: Carga las imágenes de los caballos NO ganadoras y cada una carga su evento correspondiente.
                    * Por defecto se toma el nivel de dificultad 2, es decir, son 3 imágenes no ganadora.
                    * Cualquiera de las 3 imágenes toma alguna de las posiciones 1, 2, 3 ó 4
     */
    public void cargarImagenesNoGanadoras(){
        ImageView imagenNoGanadora1 = imageViewParaImagenNoGanadora();
        cargarEventoOnClickParaImagenNoGanadora(imagenNoGanadora1);
        ImageView imagenNoGanadora2 = imageViewParaImagenNoGanadora();
        cargarEventoOnClickParaImagenNoGanadora(imagenNoGanadora2);
        ImageView imagenNoGanadora3 = imageViewParaImagenNoGanadora();
        cargarEventoOnClickParaImagenNoGanadora(imagenNoGanadora3);
    }


    /*
        Propósito: Carga el evento OnClick para la imágen ganadora
        * se define "imagen ganadora" como aquella que coincide con el "nombre a reconoce" VER DE BUSCAR UN NOMBRE PARA IDENTIFICAR "NOMBRE A RECONOCER"
     */
    public void cargarEventoOnClickParaImagenGanadora(final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensajeDeJuagaGanada();
            }
        });
    }

    /*
      Propósito: Carga el evento OnClick para una imágen no ganadora
      * se define imagen NO ganadora como aquella que no coincide con el "NOMBRE A RECONOCER"S
   */
    public void cargarEventoOnClickParaImagenNoGanadora(final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hacer sonar relinche de caballo
            }
        });
    }

    //int posicionGanadora = this.miniJuego.posicionItemGanadorDeLaJugadaActual();
    //ImageView imagenGanadora  = imagenEnPosicion(posicionGanadora);
    //imagenGanadora.setImageResource(ubicacionPorNombreDeImagenDeCaballo(nombresDeLaJugadaActual[0]));

    public ImageView imageViewParaImagenGanadora() {
        ImageView imageViewGanadora = (ImageView) findViewById(idImageViewParaPosicionDeJugada(this.miniJuego.posicionJugadaGanadora()));
        imageViewGanadora.setImageResource(ubicacionDeImagenDeCaballoPorNombre(this.miniJuego.nombreAReconocerDeLaJugadaActual()));
        return imageViewGanadora;
    }

    public ImageView imageViewParaImagenNoGanadora() {

    }

    public void mensajeDeJuagaGanada() {
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
        Propósito: Reanuda la jugada actual
     */
    public void reanudadJugadaActual() {
        this.miniJuego.reanudarJugada();
        cargarJugadaActual();
    }

    /*
        Propósito: Carga la próxima jugada para la jugada actual
        Precondición: Existe una próxima jugada en el minijuego
     */
    public void cargarJugadaSiguiente() {
        this.miniJuego.jugadaSiguiente();
        cargarJugadaActual();
    }

    /*
        Propósito: emite el sonido de un caballo relinchando que representa una interacción NO acertada para la jugada actual
     */
    public void mensajeDeJugadaNoGanada(){

    }



    private int ubicacionDeImagenDeCaballoPorNombre(String nombre) {
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

    private int idImageViewParaPosicionDeJugada(int posicion) {
        switch (posicion) {
            case 0: return R.id.razaypelajeImageView0;
            case 1: return R.id.razaypelajeImageView1;
            case 2: return R.id.razaypelajeImageView2;
            case 3: return R.id.razaypelajeImageView3;
        }
    }

    /*
        Propósito: Regresa a la pantalla de Inicio (MainActivity) cuando se dispara el evento onClick del boton "Volver"
    */
    public void volverAPantallaPrincipal(View view) {
        Intent i = new Intent(RazaYPelajeActivity.this, MainActivity.class);
        startActivity(i);
    }

}
