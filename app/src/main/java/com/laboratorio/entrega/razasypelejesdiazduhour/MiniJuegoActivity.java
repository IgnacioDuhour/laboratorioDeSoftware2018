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
        setearConfiguracion();
        definirLayoutSegunConfiguracion();
        iniciarMiniJuego();
        cargarElementosEnLayout();
    }

    /**
     * Propósito: define la configuración para el tipo de interacción y el tipo de dificultad
     * Precondición: Ninguna
     */
    public void setearConfiguracion() {
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        //    definirDificultadSegunConfiguracion();
        boolean esDificultadFacil = preferences.getString("dificultad", "Facil").compareTo("Facil") == 0;
        this.dificultad = esDificultadFacil ? new Facil() : new Dificil();

        //    definirInteraccionSegunConfiguracion();
        boolean esImagenPalabra = preferences.getBoolean("imagen-palabra", true);
        boolean esPalabraImagen = preferences.getBoolean("palabra-imagen", false);
        boolean esImagenImagen = preferences.getBoolean("imagen-imagen", false);
        if (esImagenPalabra) {
            this.interaccion = new ImagenPalabra();
        } else if (esPalabraImagen) {
            this.interaccion = new PalabraImagen();
        } else {
            this.interaccion = new ImagenImagen();
        }
    }

    /*
        Propósito: crea  e iniciar un miniJuego
        Precondicion: Hay una interaccion y dificultad definidas
     */
    public abstract void iniciarMiniJuego();

    /*
        Propósito: Selecciona el layout segun configuración
        Precondición: Hay una dificultad e interacción definida
        Observación: Existen 4 (cuatro) tipos de layouts:
                        1. layout imagen_palabra_facil
                        2. layout imagen_palabra_dificil
                        3. layout palabra_imagen_facil
                        4. layout palabra_imagen_dificil
     */
    public void definirLayoutSegunConfiguracion() {
        setContentView(this.dificultad.obtenerLayout(this.interaccion));
    }


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
        cargarItemAReconocerDeLaJugadaActual();
        cargarItemsAInteraccionarDeLaJugadaActual();
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
        Propósito: Carga la próxima jugada para la jugada actual
        Precondición: Existe una próxima jugada en el minijuego
     */
    public void cargarJugadaSiguiente() {
        this.miniJuego.irAProximaJugada();
        this.cargarJugadaActual();
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
     * Propósito: describe el número que representa la ubicación de una imagen a partir del nombre de la imagen
     * Parámetro: "nombre" representa el nombre de una imágen ubicada en "res/drawable"
     */
    public abstract int ubicacionDeImagenDeCaballo(String nombre);


    /*
        Propósito: Evento del boton volver que regresa a la pantalla de Principal (MainActivity)
    */
    public void volverAPantallaPrincipal(View view) {
        Intent i = new Intent(MiniJuegoActivity.this, MainActivity.class);
        startActivity(i);
    }

    /*
        Propósito: Reinicia el MiniJuego
        Precondición: Ninguna
    */
    public abstract void reIniciarMiniJuego();


    /*
        Propósito: Emite el sonido de resoplo de un caballo  que representa una interacción NO acertada para la jugada actual.
        Precondición: hay una jugada cargada
    */
    public void feedbackSonoroJugadaNoGanada() { sonidoResoplidoCaballo.start(); }

    /*
        Propósito: Emite el sonido de un caballo relinchando, que representa una interacción Acertada para la jugada actual.
        Precondición: hay una jugada cargada
    */
    public void feedbackSonoroJugadaGanada() {
        sonidoRelincheCaballo.start();
    }

    /*
        Propósito: genera un feedback visual para el minijuego ganado (papel picado o copa)
        Precondición: hay un minijuego ganado
     */
    public abstract void feedbackVisualMiniJuegoGanado();

    /*
       Propósito: genera un feedback cuando se finalizó el minijuego y no se ha ganado, dandole las opciones de
                   * Ir a Inicio
                   * Reanudar minijuego
       Precondición: Hay un minijuego no ganado
    */
    public void feedbackVisualMiniJuegoNoGanado() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("MiniJuego no ganado").setCancelable(false);
        builder.setPositiveButton("Ir al inicio", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                irAPantallaPrincipal();
            }
        });
        builder.setNeutralButton("Reanudar juego", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                reIniciarMiniJuego();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /*
        Propósito: genera un feedback para la última jugada ganada
        Precondición: Es la última jugada
     */
    public void feedbackVisualkUltimaJugada(){
        if (esMiniJuegoGanado()) {
            feedbackVisualMiniJuegoGanado();
        } else {
            feedbackVisualMiniJuegoNoGanado();
        }
    }


    /*
    Propósito: Carga el evento OnClick para la imagen ganadora
    Precondición: Hay una imagen ganadora cargada en el layout correspondiente y no es la última jugada
*/
    public void cargarEventoOnClickParaImagenGanadora (final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackSonoroJugadaGanada();
                cargarJugadaSiguiente();
            }
        });
    }

    /*
        Propósito: Carga el evento OnClick para la palabra ganadora
        Precondición: Hay una palabra ganadora cargada en el layout correspondiente y no es la última jugada
    */
    public void cargarEventoOnClickParaPalabraGanadora (final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackSonoroJugadaGanada();
                cargarJugadaSiguiente();
            }
        });
    }

    /*
       Propósito: Carga el evento OnClick para la imagen no ganadora
       Precondición: Hay una imagen No ganadora cargada en el layout correspondiente y no es la última jugada
   */
    public void cargarEventoOnClickParaImagenNoGanadora (final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackSonoroJugadaNoGanada();
                cargarJugadaSiguiente();
            }
        });
    }

    /*
        Propósito: Carga el evento OnClick para la palabra No ganadora
        Precondición: Hay una palabra No ganadora cargada en el layout correspondiente y no es la última jugada
    */
    public void cargarEventoOnClickParaPalabraNoGanadora (final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackSonoroJugadaNoGanada();
                cargarJugadaSiguiente();
            }
        });
    }

    /*
       Propósito: Carga el evento OnClick para la imagen no ganadora
       Precondición: Hay una imagen No ganadora cargada en el layout correspondiente
   */
    public void cargarEventoOnClickParaImagenGanadoraUltimaJugada (final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackSonoroJugadaGanada();
                feedbackVisualkUltimaJugada();
            }
        });
    }

    /*
        Propósito: Carga el evento OnClick para la palabra No ganadora
        Precondición: Hay una palabra No ganadora cargada en el layout correspondiente
    */
    public void cargarEventoOnClickParaPalabraGanadoraUltimaJugada (final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackSonoroJugadaGanada();
                feedbackVisualkUltimaJugada();
            }
        });
    }

    /*
       Propósito: Carga el evento OnClick para la imagen no ganadora
       Precondición: Hay una imagen No ganadora cargada en el layout correspondiente
    */
    public void cargarEventoOnClickParaImagenNoGanadoraUltimaJugada (final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackSonoroJugadaNoGanada();
                feedbackVisualkUltimaJugada();
            }
        });
    }

    /*
        Propósito: Carga el evento OnClick para la palabra No ganadora
        Precondición: Hay una palabra No ganadora cargada en el layout correspondiente
    */
    public void cargarEventoOnClickParaPalabraNoGanadoraUltimaJugada (final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackSonoroJugadaNoGanada();
                feedbackVisualkUltimaJugada();
            }
        });
    }


    /*
        Propósito: describe verdadero cuando se ha ganado al menos 3 jugadas o desafíos
        Precondición: Todas las jugadas fueron jugadas
     */
    public boolean esMiniJuegoGanado() {
        return this.miniJuego.esMiniJuegoGanado();
    }
}
