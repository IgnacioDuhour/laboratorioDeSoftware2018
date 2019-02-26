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
        iniciarMiniJuego();
        definirLayoutSegunConfiguracion();
        cargarElementosEnLayout();
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
        Propósito: crea  e iniciar un miniJuego
     */
    public abstract void iniciarMiniJuego();

    /*
        Propósito: Selecciona el layout segun configuración
        Precondición: Hay un minijuego de "Raza y Pelaje" incializado
        Observación: Existen 4 (cuatro) tipos de layouts:
                        1. layout imagen_palabra_facil
                        2. layout imagen_palabra_dificil
                        3. layout palabra_imagen_facil
                        4. layout palabra_imagen_dificil
     */
    public abstract void definirLayoutSegunConfiguracion();


    /*
     * Propósito: Carga el nombre del minijuego, la jugada actual y el feedback sonoro
     * Observación: "cargar" hace referencia a la accion que muestra un recurso (imagen, texto, sonido) necesario en la pantalla
     */
    public void cargarElementosEnLayout() {
        cargarNombreDelMiniJuego();
        cargarJugadaActual();
        cargarFeedbackSonoroCaballo();
    }

    /*
     * Propósito: carga el nombre del juego ("Raza y Pelaje" , "Razas y Pelajes juntas", "Cruza)
     * * Precondición: Hay un minijuego inicializado y un layout definido
     */
    public void cargarNombreDelMiniJuego() {
        TextView nombreDelMiniJuego = (TextView) findViewById(R.id.nombreDelMiniJuego);
        nombreDelMiniJuego.setText(this.miniJuego.tipoDeJuego());
    }

    /*
     * Propósito: carga el sonido del caballo que representa el mensaje de una interacción con el minijuego
     * Precondición: Existe una judaga cargada
     */
    public void cargarFeedbackSonoroCaballo() {
        sonidoRelincheCaballo = MediaPlayer.create(this, R.raw.relincho);
        sonidoResoplidoCaballo = MediaPlayer.create(this, R.raw.resoplido);
    }

    /*
     * Propósito: Carga la jugada actual compuesta por el Item principal (ubicado en la parte superior) y los items con los que se interaccionará (ubicados en la parte inferior)
     * Precondición: Hay un minijuego inicializado y un layout definido
     */
    public void cargarJugadaActual() {
        definirJugadaActual();
        cargarItemAReconocerDeLaJugadaActual();
        cargarItemsAInteraccionarDeLaJugadaActual();
    }

    /*
        Propósito: define los elementos que corresponden con la jugada actual
     */
    public void definirJugadaActual() {
        this.miniJuego.jugarJugadaActual();
    }


    /*
        Propósito: Carga el item a reconoer de la jugada actual, ubicado en la parte superior
        Obsevación: el item a reconocer se encuentra en la parte superior del minijuego
     */
    public void cargarItemAReconocerDeLaJugadaActual() {
        this.interaccion.cargarItemAReconocer(this.dificultad, this, this.miniJuego.itemGanadorDeLaJugadaActual());
    }

    /*
        Propósito: Carga los items los que se interaccionará según la configuración
        Precondición: Hay una jugada actual definida
        Observación: "items a interaccionar": texto o imagen que se encuentra en la parte inferior del minijuego
     */
    public void cargarItemsAInteraccionarDeLaJugadaActual() {
        if (this.esUltimaJugada()) {
            cargarItemGanadorUltimaJugada();
            cargarItemsNoGanadoresUltimaJugada();
        } else {
            cargarItemGanador();
            cargarItemsNoGanadores();
        }
    }

    /*
        Propósito: describe verdadero si es la ultima jugada del minijuego, es decir es el desafío #5
        Precondición: hay una jugada actual definida
     */
    protected boolean esUltimaJugada() {
        return this.miniJuego.esUltimaJugada();
    }

    /*
      Propósito: Carga el item  ganador en la posición correspondiente.
      Precondición: Hay una jugada actual definida
     */
    public void cargarItemGanador() {
        this.interaccion.cargarItemGanador(this.dificultad, this, this.miniJuego.itemGanadorDeLaJugadaActual(), this.miniJuego.posicionItemGanadorDeJugadaActual());
    }

    /*
        Propósito: Carga los items  NO ganadores en sus posición correspondientes.
        Precondición: hay una jugada actual definida.
     */
    public void cargarItemsNoGanadores() {
        this.interaccion.cargarItemsNoGanadores(this.dificultad, this, this.miniJuego.itemsNoGanadoresDeLaJugadaActual(), this.miniJuego.posicionesItemsNoGanadoresDeLaJugadaActual());
    }

    /*
        Propósito: Carga el item  ganador en la posición correspondiente que corresponde con el último desafío.
        Precondición: Hay una jugada actual definida
    */
    public void cargarItemGanadorUltimaJugada() {
        this.interaccion.cargarItemGanadorUltimaJugada(this.dificultad, this, this.miniJuego.itemGanadorDeLaJugadaActual(), this.miniJuego.posicionItemGanadorDeJugadaActual());
    }

    /*
        Propósito: Carga los items NO ganadores que corresponde con el último desafío.
        Precondición: Hay una jugada actual definida
    */
    public void cargarItemsNoGanadoresUltimaJugada() {
        this.interaccion.cargarItemsNoGanadoresUltimaJugada(this.dificultad, this, this.miniJuego.itemsNoGanadoresDeLaJugadaActual(), this.miniJuego.posicionesItemsNoGanadoresDeLaJugadaActual());
    }

    /*
        Propósito: Emite el sonido de resoplo de un caballo  que representa una interacción NO acertada para la jugada actual.
        Precondición: hay una jugada cargada
    */
    public void feedbackJugadaNoGanada() {
        sonidoResoplidoCaballo.start();
    }

    /*
        Propósito: Emite el sonido de un caballo relinchando, que representa una interacción Acertada para la jugada actual.
        Precondición: hay una jugada cargada
    */
    public void feedbackDeJugadaGanada() {
        sonidoRelincheCaballo.start();
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
                return R.drawable.defaultfur;
            case "ATIGRADO":
                return R.drawable.defaultfur;
            case "BAYO":
                return R.drawable.defaultfur;
            case "BRAGADO":
                return R.drawable.defaultfur;
            case "COLORADO":
                return R.drawable.defaultfur;
            case "MELADO":
                return R.drawable.defaultfur;
            case "PANGARE":
                return R.drawable.defaultfur;
            case "ZAINO":
                return R.drawable.defaultfur;
            case "ANDALUS":
                return R.drawable.defaultfur;
            case "APPALOSA":
                return R.drawable.defaultfur;
            case "ARABE":
                return R.drawable.defaultfur;
            case "AZTECA":
                return R.drawable.defaultfur;
            case "CLYDESDALE":
                return R.drawable.defaultfur;
            case "COMTIOS":
                return R.drawable.defaultfur;
            case "CRIOLLO":
                return R.drawable.defaultfur;
            case "CRIOLLOARGENTINO":
                return R.drawable.defaultfur;
            case "CRIOLLOAMERICANO":
                return R.drawable.defaultfur;
            case "CUARTODEMILA":
                return R.drawable.defaultfur;
            case "FALABELLA":
                return R.drawable.defaultfur;
            case "FRISON":
                return R.drawable.defaultfur;
            case "HAFLINGER":
                return R.drawable.defaultfur;
            case "HANNOVERIANO":
                return R.drawable.defaultfur;
            case "LUSITANO":
                return R.drawable.defaultfur;
            case "MUSTANG":
                return R.drawable.defaultfur;
            case "PALOMINO":
                return R.drawable.defaultfur;
            case "PASOFINO":
                return R.drawable.defaultfur;
            case "PERCHERON":
                return R.drawable.defaultfur;
            case "PONIFELL":
                return R.drawable.defaultfur;
            case "PONIPOLO":
                return R.drawable.defaultfur;
            case "PURASANGREINGLES":
                return R.drawable.defaultfur;
            case "SHIRE":
                return R.drawable.defaultfur;
            case "SORAIA":
                return R.drawable.defaultfur;
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
