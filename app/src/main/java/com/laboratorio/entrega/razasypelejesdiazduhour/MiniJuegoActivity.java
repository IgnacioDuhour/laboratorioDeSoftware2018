package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class MiniJuegoActivity extends AppCompatActivity {


    protected MiniJuego miniJuego;
    protected MediaPlayer sonidoRelincheCaballo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*
     * Propósito: Inicia un nuevo minijuego y carga los elementos necesarios en la actividad correspondiente (RazayPelaje o Cruza)
     * Observación: "cargar" hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla
     */
    public void comenzarAJugar() {
        iniciarMiniJuego();
        cargarElementosEnActividad();
    }

    /*
        Propósito: crea un nuevo miniJuego y lo inicia inicia (por defecto es "Razas y Pelajes")
     */
    public void iniciarMiniJuego(){
        this.miniJuego = new MiniJuego();
        this.miniJuego.iniciarJuego();
    }

    /*
     * Propósito: Carga la jugada actual y el sonido del caballo relinchando en la actividad correspondiente (RazayPelaje o Cruza)
     * Observación: "cargar" hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla
     */
    public void cargarElementosEnActividad() {
        cargarJugadaActual();
        cargarSonidoCaballoRelinchando();
    }

    /*
     * Propósito: carga el sonido del caballo relinchando que representa el mensaje de una interacción NO acertada
     * Precondición: Existe una judaga cargada
     */
    public void cargarSonidoCaballoRelinchando() {
        sonidoRelincheCaballo = MediaPlayer.create(this, R.raw.caballorelinchando);
    }

    /*
     * Propósito: Carga la jugada actual compuesta por
          * 1. Nombre de la Juagda (RazayPelaje o Cruza)
          * 2. Item principal
          * 3. cuatro (4) Items con los que interaccionará el jugador
     * Observación:
          * "item":  puede ser texto o imagen.
          * "cargar": hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla

     */
    public void cargarJugadaActual() {
        cargarNombreDelJuego();
        cargarItemPrincipalDeLaJugadaActual();
        cargarImagenesAInteraccionarDeLaJugadaActual();
    }

    /*
     * Propósito: carga el nombre del juego ("Raza y Pelaje" o  "Cruza)
     * Observación: "cargar" hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla
     */
    public void cargarNombreDelJuego() {
        TextView nombreDelJuego = (TextView) findViewById(R.id.nombreDelJuego);
        String str = "Juego de " + this.miniJuego.tipoDeLaJugadaActual();
        nombreDelJuego.setText(str);
    }

    /*
     * Propósito: Carga el item principal de la jugada actual de una partida
     * Observación:
        * "item":  puede ser texto o imagen.
        * "cargar": hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla.
     */
    public abstract void cargarItemPrincipalDeLaJugadaActual();

    /*
     * Propósito: Carga las imágenes de los caballos con las que interaccionará el jugador. (por defecto, nivel de dificuld 2 (4 items))
     * Observación: "cargar" hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla
     */
    public void cargarImagenesAInteraccionarDeLaJugadaActual(){
        cargarImagenGanadora();
        cargarImagenesNoGanadoras();
    }

    /*
     * Propósito: Carga la imágen del caballo ganador en la posición correspondiente.
     * Precondición: Existe la imagen ganadora
     * Observación:
     * "cargar": hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla
     * "posición": es un número aleatorio entre 1,2,3 ó 4, donde se ubicará el item ganador.
     */
    public void cargarImagenGanadora() {
        //se encuentra el imageview
        ImageView imagenGanadora = (ImageView) findViewById(idImageViewParaPosicionDeJugada(posicionItemGanadorDeJugadaActual()));
        //se setea el source del imageview
        imagenGanadora.setImageResource(ubicacionDeImagenDeCaballoPorNombre(this.miniJuego.nombreAReconocerDeLaJugadaActual()));
        //se define el evento para el imageview
        cargarEventoOnClickParaImagenGanadora(imagenGanadora);
    }

    /*
     * Propósito: Carga las imágenes de los caballos NO ganadoras en su posición correspondiente.
     * Por defecto, nivel de dificuld 2 (3 items no ganadores)
     * Observación:
     * "cargar": hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla
     * "posición":  los 3 items pueden tomar alguna de las posiciones 1, 2, 3 o 4
    */
    public void cargarImagenesNoGanadoras() {
        int[] posiciones = posicionesSinImagenGanadora();
        String[] nombres = this.miniJuego.nombresDeLaJugadaActual();
        String nombreAReconocer = this.miniJuego.nombreAReconocerDeLaJugadaActual();
        for (int i = 0; i < posiciones.length; i++) {
            if (nombres[i].compareTo(nombreAReconocer)!=0) {
                cargarImagenesNoGanadoraPorPosicion(posiciones[i], nombres[posiciones[i]]);
            }
        }
    }

    /*
       Propósito: Carga la imágen del caballo NO ganadora en la posición correspondiente, pudiendo ser alguna de las posiciones 1,2,3 ó 4.
       Precondición: "posicion" es alguna de las posiciones 1, 2, 3 o 4.
    */
    public void cargarImagenesNoGanadoraPorPosicion(int posicion, String nombreImagen) {
        //se encuentra el imageview
        ImageView imagenNoGanadora = (ImageView) findViewById(idImageViewParaPosicionDeJugada(posicion));
        //se setea el source del imageview
        imagenNoGanadora.setImageResource(ubicacionDeImagenDeCaballoPorNombre(nombreImagen));
        //se define el evento para el imageview
        cargarEventoOnClickParaImagenNoGanadora(imagenNoGanadora);
    }


    /*
        Propósito: Carga el evento OnClick para la imágen ganadora
        * se define "imagen ganadora" como aquella que coincide con el "nombre a reconoce" VER DE BUSCAR UN NOMBRE PARA IDENTIFICAR "NOMBRE A RECONOCER"
     */
    public void cargarEventoOnClickParaImagenGanadora(final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarMensajeDeJugaGanada();
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
                mensajeJugadaNoAcertada();
            }
        });
    }

    /*
        Propósito: Emite el sonido de un caballo relinchando que representa una interacción NO acertada para la jugada actual.
    */
    public void mensajeJugadaNoAcertada() {
        sonidoRelincheCaballo.start();
    }


    /*
        Propósito: Carga el mensaje de la jugada ganada.
     */
    public abstract void cargarMensajeDeJugaGanada();

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
    public abstract void cargarJugadaSiguiente();

    /*
        Propósito: Carga el mensaje cuandoe el jugador no acertó la jugada, dandole las opciones:
                    * Reanudar minijuego
                    * Ir al inicio
    */
    public void cargarMensajejeDeMiniJuegoFinalizado() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("MiniJuego Finalizado");
        //builder.setMessage("This is my message.");
        builder.setPositiveButton("Ir al inicio", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                irAPantallaPrincipal();
            }
        });
        builder.setNeutralButton("Comenzar nuevo juego", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                comenzarAJugar();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /*
        Propósito: Regresa a la pantalla de Principal (MainActivity)
    */
    public void irAPantallaPrincipal() {
        Intent i = new Intent(MiniJuegoActivity.this, MainActivity.class);
        startActivity(i);
    }

    /*
        Propósito: carga el siguiente minijuego (por defecto, el siguiente es "Cruza")
     */
    public void cargarSiguienteMiniJuego() {
        Intent i = new Intent(MiniJuegoActivity.this, CruzaActivity.class);
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
            case "PURASANGRE": return R.drawable.purasangreingles;
            case "SHIRE": return R.drawable.shire;
            case "SORAIA": return R.drawable.soraia;
            default: return R.drawable.defaultfur;
        }
    }

    protected int idImageViewParaPosicionDeJugada(int posicion) {
        switch (posicion) {
            case 0: return R.id.minijuegoImageView0;
            case 1: return R.id.minijuegoImageView1;
            case 2: return R.id.minijuegoImageView2;
            case 3: return R.id.minijuegoImageView3;
            default: return R.id.minijuegoImageView0; //ver que decisión tomo cuando no se encuentra la posicion buscada
        }
    }

    /*
        Propósito: describe la posición del item ganador (texto o imagen) de la jugada actual. Los items son con los que interaccionará el jugador.
     */
    protected int posicionItemGanadorDeJugadaActual() {
        String[] nombres = this.miniJuego.nombresDeLaJugadaActual();
        String nombre    = this.miniJuego.nombreAReconocerDeLaJugadaActual();
        int posicion = -1;
        for (int i=0; i<nombres.length;i++) {
            if (nombres[i].compareTo(nombre)==0) { posicion = i; break; }
        }
        return posicion;
    }

    protected int[] posicionesSinImagenGanadora() {
        String[] nombres = this.miniJuego.nombresDeLaJugadaActual();
        int[] posiciones = new int[nombres.length-1];
        int j=0;
        String nombreAReconocer = this.miniJuego.nombreAReconocerDeLaJugadaActual();
        for (int i=0; i<nombres.length;i++) {
            if (nombres[i].compareTo(nombreAReconocer)!=0) {
                posiciones[j] = i;
                j++;
            }
        }
        return posiciones;
    }

    /*
        Propósito: Evento del boton volver que regresa a la pantalla de Principal (MainActivity)
    */
    public void volverAPantallaPrincipal(View view) {
        Intent i = new Intent(MiniJuegoActivity.this, MainActivity.class);
        startActivity(i);
    }

}
