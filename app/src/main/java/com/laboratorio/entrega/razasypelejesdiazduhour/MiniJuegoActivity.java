package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class MiniJuegoActivity extends AppCompatActivity {


    protected MiniJuego miniJuego;
    protected MediaPlayer sonidoRelincheCaballo, sonidoResoplidoCaballo;
    protected Dificultad dificultad; //la dificultad puede ser Facil o Dificil. El primero corresponde a la subclase DificultadFacil y el segundo corresponde a la subclase DificultadDificil
    protected Interaccion interaccion; //la interacción puede ser Imagen-Palabra, PalabraImagen o Imagen-Imagen y cada una corresponde con una subclase.

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

    /**
     * Propósito: define la configuración para el tipo de interacción y el tipo de dificultad
     * Precondición: Hay un minijuego inicializado
     */
    public void setearConfiguracion() {
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);

        // obtener dificultad de las preferencias y setear la dificultad para el minijuego
        boolean esDificultadFacil = preferences.getString("dificulad", "Facil") == "Facil";
        this.dificultad = esDificultadFacil ? new Facil() : new Dificil();

        // obtener interaccion
        boolean esImagenPalabra = preferences.getBoolean("imagen-palabra", true);
        boolean esPalabraImagen = preferences.getBoolean("palabra-imagen", false);
        boolean esImagenImagen = preferences.getBoolean("imagen-imagen", false);
        if (esImagenPalabra) {
            this.interaccion = new ImagenPalabra();
        } else if (esPalabraImagen) {
            this.interaccion = new PalabraImagen();
        } else if (esImagenImagen) {
            this.interaccion = new ImagenImagen();
        }
    }

    /*
        Propósito: crea un nuevo miniJuego y lo inicia inicia (por defecto es "Razas y Pelajes")
     */
    public abstract void iniciarMiniJuego();

    /*
     * Propósito: Carga la jugada actual y el sonido del caballo relinchando en la actividad correspondiente (RazayPelaje o Cruza)
     * Observación: "cargar" hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla
     */
    public void cargarElementosEnActividad() {
        cargarNombreDelJuego();
        cargarJugadaActual();
        cargarSonidoCaballoRelinchando();
    }

    /*
     * Propósito: carga el sonido del caballo relinchando que representa el mensaje de una interacción NO acertada
     * Precondición: Existe una judaga cargada
     */
    public void cargarSonidoCaballoRelinchando() {
        sonidoRelincheCaballo = MediaPlayer.create(this, R.raw.relincho);
        sonidoResoplidoCaballo = MediaPlayer.create(this, R.raw.resoplido);
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
        cargarItemPrincipalDeLaJugadaActual();
        cargarImagenesAInteraccionarDeLaJugadaActual();
    }

    /*
     * Propósito: carga el nombre del juego ("Raza y Pelaje" , "Razas y Pelajes juntas", "Cruza)
     * Observación: "cargar" hace referencia a la accion que muestra   el recurso (imagen, texto, sonido) necesario en la pantalla
     */
    public void cargarNombreDelJuego() {
        TextView nombreDelJuego = (TextView) findViewById(R.id.nombreDelJuego);
        nombreDelJuego.setText(this.miniJuego.tipoDeJuego());
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
    public void cargarImagenesAInteraccionarDeLaJugadaActual() {
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
        int[] posiciones = this.miniJuego.posicionesSinImagenGanadoraDeJugadaActual();
        String[] nombres = this.miniJuego.nombresDeTiposNoGanadoresDeJugadaActual();
        for (int i = 0; i < posiciones.length; i++) {
            cargarImagenesNoGanadoraPorPosicion(posiciones[i], nombres[i]);
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
        sonidoResoplidoCaballo.start();
    }


    /*
        Propósito: Carga el mensaje de la jugada ganada.
    */
    public void cargarMensajeDeJugaGanada() {
        sonidoRelincheCaballo.start();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Jugada Ganada").setCancelable(false);
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
        if (!this.miniJuego.esUltimaJugada()) {
            this.miniJuego.jugadaSiguiente(); //ver si puedo eliminar el if, viendo si puedo conocer cual es la ultima jugada
            cargarJugadaActual();
        } else {
            cargarMensajejeDeMiniJuegoFinalizado();
        }
    }

    /*
        Propósito: Carga el mensaje cuandoe el jugador no acertó la jugada, dandole las opciones:
                    * Reanudar minijuego
                    * Ir al inicio
    */
    public void cargarMensajejeDeMiniJuegoFinalizado() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("MiniJuego Finalizado").setCancelable(false);
        builder.setPositiveButton("Ir al inicio", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                irAPantallaPrincipal();
            }
        });
        builder.setNeutralButton("Comenzar nuevo juego", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                reanudarJuego();
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

    /*
        Propósito: Reanuda el Juego, comenzando por defecto por el juego de "Razas y Pelajes"
    */
    public void reanudarJuego() {
        Intent i = new Intent(MiniJuegoActivity.this, RazaYPelajeActivity.class);
        startActivity(i);
    }

    /*
        Propósito: describe la posición del item ganador (texto o imagen) de la jugada actual. Los items son con los que interaccionará el jugador.
    */
    protected int posicionItemGanadorDeJugadaActual() {
        return this.miniJuego.posicionItemGanadorDeJugadaActual();
    }

    /*
     * Propósito: describe el número que representa la ubicación de una imagen a partir del nombre de la imagen
     * Parámetro: "nombre" representa el nombre de una imágen ubicada en "res/drawable"
     */
    protected int ubicacionDeImagenDeCaballoPorNombre(String nombre) {
        switch (nombre.toUpperCase()) {
            case "ALBO":
                return R.drawable.albo;
            case "ATIGRADO":
                return R.drawable.atigrado;
            case "BAYO":
                return R.drawable.bayo;
            case "BRAGADO":
                return R.drawable.bragado;
            case "COLORADO":
                return R.drawable.colorado;
            case "MELADO":
                return R.drawable.melado;
            case "PANGARE":
                return R.drawable.pangare;
            case "ZAINO":
                return R.drawable.zaino;
            case "ANDALUS":
                return R.drawable.andaluz;
            case "APPALOSA":
                return R.drawable.appalosa;
            case "ARABE":
                return R.drawable.arabe;
            case "AZTECA":
                return R.drawable.azteca;
            case "CLYDESDALE":
                return R.drawable.clydesdale;
            case "COMTIOS":
                return R.drawable.comtios;
            case "CRIOLLO":
                return R.drawable.criollo;
            case "CRIOLLOARGENTINO":
                return R.drawable.criolloargentino;
            case "CRIOLLOAMERICANO":
                return R.drawable.criolloamericano;
            case "CUARTODEMILA":
                return R.drawable.cuartodemila;
            case "FALABELLA":
                return R.drawable.falabella;
            case "FRISON":
                return R.drawable.frison;
            case "HAFLINGER":
                return R.drawable.haflinger;
            case "HANNOVERIANO":
                return R.drawable.hannoveriano;
            case "LUSITANO":
                return R.drawable.lusitano;
            case "MUSTANG":
                return R.drawable.mustang;
            case "PALOMINO":
                return R.drawable.palomino;
            case "PASOFINO":
                return R.drawable.pasofino;
            case "PERCHERON":
                return R.drawable.percheron;
            case "PONIFELL":
                return R.drawable.ponifell;
            case "PONIPOLO":
                return R.drawable.ponipolo;
            case "PURASANGREINGLES":
                return R.drawable.purasangreingles;
            case "SHIRE":
                return R.drawable.shire;
            case "SORAIA":
                return R.drawable.soraia;
            default:
                return R.drawable.defaultfur;
        }
    }

    protected int idImageViewParaPosicionDeJugada(int posicion) {
        switch (posicion) {
            case 0:
                return R.id.minijuegoImageView0;
            case 1:
                return R.id.minijuegoImageView1;
            case 2:
                return R.id.minijuegoImageView2;
            case 3:
                return R.id.minijuegoImageView3;
            default:
                throw new IllegalArgumentException("Posicion de jugada inválida");
        }
    }

    /*
        Propósito: Evento del boton volver que regresa a la pantalla de Principal (MainActivity)
    */
    public void volverAPantallaPrincipal(View view) {
        Intent i = new Intent(MiniJuegoActivity.this, MainActivity.class);
        startActivity(i);
    }

}
