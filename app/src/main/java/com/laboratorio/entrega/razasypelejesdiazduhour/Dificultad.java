package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class Dificultad extends AppCompatActivity { //o extends de AppCompatActivity, ver!!

    public abstract int obtenerLayout(Interaccion interaccion);

    public abstract Jugada nuevaJugada(JugadaTipo jugadaTipo);

    /*
        Propósito: carga la palabra a reconocer ubicada en la parte superior.
     */
    public void cargarPalabraAReconocer(MiniJuegoActivity miniJuegoActivity, String nombrePalabra){
        TextView palabraAReconocer = (TextView) miniJuegoActivity.findViewById(R.id.palabraAReconocer);
        palabraAReconocer.setText(sanitizarTexto(nombrePalabra, miniJuegoActivity));
        ImageButton button = (ImageButton) miniJuegoActivity.findViewById(R.id.palabraButton1);
        setearOnClick(miniJuegoActivity, button, nombrePalabra);
    }

    /*
        Propósito: carga la imagen a reconocer ubicada en la parte superior.
     */
    public void cargarImagenAReconocer(MiniJuegoActivity miniJuegoActivity, String nombreImagen){
        //se encuentra el imageview
        ImageView imagenGanadora = (ImageView) miniJuegoActivity.findViewById(R.id.imagenAReconocer);
        //se setea el source del imageview
        imagenGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballo(definirNombreParaCruza(nombreImagen, miniJuegoActivity)));
    }

    /*
        Propósito: carga la palabra ganadora en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarPalabraGanadora(MiniJuegoActivity miniJuegoActivity, String nombrePalabraGanadora, int posicionPalabraGanadora) {
        TextView palabraAReconocer = (TextView) miniJuegoActivity.findViewById(this.idTextViewSegunPosicion(posicionPalabraGanadora));
        palabraAReconocer.setText(sanitizarTexto(nombrePalabraGanadora, miniJuegoActivity));
        miniJuegoActivity.cargarEventoOnClickParaPalabraGanadora(palabraAReconocer);
    }

    /*
        Propósito: carga la imagen ganadora en la parte inferior del layout, donde se interaccionará para jugar
     */
    public void cargarImagenGanadora(MiniJuegoActivity miniJuegoActivity, String nombreImagenGanadora, int posicionImagenGanadora) {
        ImageView imagenGanadora = (ImageView) miniJuegoActivity.findViewById(this.idImageViewSegunPosicion(posicionImagenGanadora));
        imagenGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballo(nombreImagenGanadora));
        miniJuegoActivity.cargarEventoOnClickParaImagenGanadora(imagenGanadora);
    }

    /*
        Propósito: carga las imágenes NO ganadoras en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarImagenesNoGanadoras(MiniJuegoActivity miniJuegoActivity, String[] nombresImagenesNoGanadoras, int[] posicionImagenesNoGanadoras) {
        int cantImagenes = nombresImagenesNoGanadoras.length;
        for (int i=0; i<cantImagenes;i++) {
            ImageView imagenNoGanadora = (ImageView) miniJuegoActivity.findViewById(this.idImageViewSegunPosicion(posicionImagenesNoGanadoras[i]));
            imagenNoGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballo(nombresImagenesNoGanadoras[i]));
            miniJuegoActivity.cargarEventoOnClickParaImagenNoGanadora(imagenNoGanadora);
        }
    }

    /*
        Propósito: carga las palabras NO ganadoras en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarPalabrasNoGanadoras(MiniJuegoActivity miniJuegoActivity, String[] nombresPalabrasNoGanadoras, int[] posicionPalabrasNoGanadoras) {
        int cantPalabras = nombresPalabrasNoGanadoras.length;
        for (int i=0; i<cantPalabras;i++) {
            TextView palabraNoGanadora = (TextView) miniJuegoActivity.findViewById(this.idTextViewSegunPosicion(posicionPalabrasNoGanadoras[i]));
            palabraNoGanadora.setText(sanitizarTexto(nombresPalabrasNoGanadoras[i], miniJuegoActivity));
            miniJuegoActivity.cargarEventoOnClickParaPalabraNoGanadora(palabraNoGanadora);
        }
    }

    /*
        Propósito: carga la imagen ganadora de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarImagenGanadoraUltimaJugada(MiniJuegoActivity miniJuegoActivity, String imagenGanadorUltimaJugada, int posicionImagenGanadorDeJugadaActual) {
        ImageView imagenGanadora = (ImageView) miniJuegoActivity.findViewById(this.idImageViewSegunPosicion(posicionImagenGanadorDeJugadaActual));
        imagenGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballo(imagenGanadorUltimaJugada));
        miniJuegoActivity.cargarEventoOnClickParaImagenGanadoraUltimaJugada(imagenGanadora);
    }

    /*
        Propósito: carga las imagenes NO ganadoras de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarImagenesNoGanadoraUltimaJugada(MiniJuegoActivity miniJuegoActivity, String[] imagenesNoGanadoresUltimaJugada, int[] posicionesImagenessNoGanadoresUltimaJugada) {
        int cantImagenes = imagenesNoGanadoresUltimaJugada.length;
        for (int i=0; i<cantImagenes;i++) {
            ImageView imagenNoGanadora = (ImageView) miniJuegoActivity.findViewById(this.idImageViewSegunPosicion(posicionesImagenessNoGanadoresUltimaJugada[i]));
            imagenNoGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballo(imagenesNoGanadoresUltimaJugada[i]));
            miniJuegoActivity.cargarEventoOnClickParaImagenNoGanadoraUltimaJugada(imagenNoGanadora);
        }
    }

    /*
        Propósito: carga la palabra ganadora de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarPalabraGanadoraUltimaJugada(MiniJuegoActivity miniJuegoActivity, String palabraGanadorUltimaJugada, int posicionPalabraGanadorDeJugadaActual) {
        TextView palabraAReconocer = (TextView) miniJuegoActivity.findViewById(this.idTextViewSegunPosicion(posicionPalabraGanadorDeJugadaActual));
        palabraAReconocer.setText(sanitizarTexto(palabraGanadorUltimaJugada, miniJuegoActivity));
        miniJuegoActivity.cargarEventoOnClickParaPalabraGanadoraUltimaJugada(palabraAReconocer);
    }

    /*
        Propósito: carga las palabras NO ganadoras de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarPalabrasNoGanadorasUltimaJugada(MiniJuegoActivity miniJuegoActivity, String[] palabrasNoGanadorasUltimaJugada, int[] posicionPalabrasNoGanadorasUltimaJugada) {
        int cantPalabras = palabrasNoGanadorasUltimaJugada.length;
        for (int i=0; i<cantPalabras;i++) {
            TextView palabraNoGanadora = (TextView) miniJuegoActivity.findViewById(this.idTextViewSegunPosicion(posicionPalabrasNoGanadorasUltimaJugada[i]));
            palabraNoGanadora.setText(sanitizarTexto(palabrasNoGanadorasUltimaJugada[i], miniJuegoActivity));
            miniJuegoActivity.cargarEventoOnClickParaPalabraNoGanadoraUltimaJugada(palabraNoGanadora);
        }
    }

    /*
       Propósito: describe el identificador de una ImageView en el layout según una posicion, que representa la ubicación dentro de los elementos a interaccionar
    */
    protected abstract int idImageViewSegunPosicion(int posicion);

    /*
        Propósito: describe el identificador de una Textview en el layout según una posicion, que representa la ubicación dentro de los elementos a interaccionar
     */
    protected abstract int idTextViewSegunPosicion(int posicion);

    private String sanitizarTexto(String texto, MiniJuegoActivity miniJuegoActivity) {
        /*
        Elimina _ y lo reemplaza por blaco y pone en mayuscula el primer char
        String aux = texto.replace("_", " ");
        String primerCaracter = aux.substring(0,1).toUpperCase();
        return primerCaracter + aux.substring(1);
        */
        String str = texto.replace("_", " ").toUpperCase();
        if (miniJuegoActivity.tipoDeJuego().compareTo("Raza y Pelaje Juntas")==0) {
            String[] aux = str.split("FIN");
            return aux[0]+", "+ aux[1];
        }
        return str;
    }

    /*
    Propósito: describe el tipo a reconocer según el tipo de jugada (RyP, RyPJuntas o Cruza)
    Observación: en el caso de ser Cruza, le concatena el sufijo "_PADRES" al nombre
 */
    private String definirNombreParaCruza(String nombre, MiniJuegoActivity miniJuegoActivity) {
        if (miniJuegoActivity.tipoDeJuego().compareTo("Cruza")==0) {
            return nombre+"_padres";
        }
        else return nombre;
    }
    /**
     * Genera un listener para onClick en el boton de la palabra del minijuego
     * @param button boton al cual se le seteara el listener
     * @param nombrePalabra palabra para buscar el sonido a reproducir
     */
    @NonNull
    public void setearOnClick(MiniJuegoActivity miniJuegoActivity, ImageButton button, String nombrePalabra){
        SharedPreferences preferences = miniJuegoActivity.getSharedPreferences("preferences", MODE_PRIVATE);
        String femenino = preferences.getString("audio", "Femenina");
        button.setOnClickListener((View v) -> {
            int audio;
            if (femenino.equals("Femenina")) {
                audio = ubicacionDeAudioDeCaballoPorNombreFemenino(nombrePalabra);
            } else {
                audio = ubicacionDeAudioDeCaballoPorNombreMasculino(nombrePalabra);
            }
            MediaPlayer mediaPlayer = MediaPlayer.create(miniJuegoActivity, audio);
            mediaPlayer.start();
        });
    }

    @NonNull
    private int ubicacionDeAudioDeCaballoPorNombreFemenino(String nombrePalabra) {
        switch (nombrePalabra.toUpperCase()) {
            //Razas
            case "CUARTO_DE_MILLA":
                return R.raw.cuarto_de_milla;
            case "CRIOLLO":
                return R.raw.criollo;
            case "PETISO_ARGENTINO":
                return R.raw.petiso_argentino;
            case "MESTIZO_CRUZA_ARABE":
                return R.raw.mestizo_cruza_arabe;
            case "MESTIZO":
                return R.raw.mestizo;
            case "SILLA_ARGENTINO":
                return R.raw.silla_argentino;
            case "SANGRE_PURO_CARRERA":
                return R.raw.sangre_pura_de_carrera;
            //Pelajes
            case "ALAZAN":
                return R.raw.alazan;
            case "ALAZAN_PINTADO":
                return R.raw.alazan_pintado;
            case "ALAZAN_RUANO":
                return R.raw.alazan_ruano;
            case "ALAZAN_TOSTADO":
                return R.raw.alazan_tostado;
            case "BAYO":
                return R.raw.bayo;
            case "BAYO_GATEADO":
                return R.raw.bayo_gateado;
            case "BLANCO":
                return R.raw.blanco;
            case "MORO":
                return R.raw.mora;
            case "OVERO_AZULAEJO":
                return R.raw.overo_azulejo;
            case "OVERO_ROSADO":
                return R.raw.overo_rosado;
            case "OVERO_ZAINO":
                return R.raw.overo_zaino;
            case "PICASO":
                return R.raw.picazo;
            case "TOBIANO":
                return R.raw.tobiano;
            case "TORDILLO":
                return R.raw.tordillo;
            case "TORDILLO_CANELA":
                return R.raw.tordillo_canela;
            case "TORDILLO_MORO":
                return R.raw.tordillo;
            case "ZAINO":
                return R.raw.zaino;
            case "ZAINO_COLORADO":
                return R.raw.zaino_colorado;
            case "ZAINO_OSCURO":
                return R.raw.zaino_oscuro;
            //raza y pelaje
            case "PETISO_ARGENTINO_FIN_ROSILLO":
                return R.raw.petiso_argentino_rosillo;
            case "MESTIZO_CRUZA_ARABE_FIN_ALAZAN_TOSTADO":
                return R.raw.mestizo_cruza_arabe_alazan_tostado;
            case "SANGRE_PURA_CARRERA_FIN_ZAINO_COLORADO":
                return R.raw.sangre_pura_de_carrera_zaina_colorada;
            case "MESTIZO_OVERO_FIN_ZAINO":
                return R.raw.mestizo_overo_zaino;
            case "MESTIZO_FIN_ALAZAN_RUANO":
                return R.raw.mestizo_alazan_ruano;
            case "MESTIZO_FIN_BLANCO":
                return R.raw.mestizo_blanco;
            case "MESTIZO_QH_CON_CRIOLLO_FIN_OVERO_AZULEJO":
                return R.raw.mestizo;
            case "MESTIZO_FIN_ALAZAN":
                return R.raw.mestizo_alazan;
            case "MESTIZO_FIN_TOBIANO":
                return R.raw.mestizo_tobiano;
            case "MESTIZO_FIN_TORDILLO_CANELA":
                return R.raw.mestizo_tordillo_canela;
            case "MESTIZO_FIN_ZAINO":
                return R.raw.mestizo_zaino;
            case "CRIOLLO_FIN_PICASO":
                return R.raw.criollo;
            case "CUARTO_DE_MILLA_FIN_BAYO":
                return R.raw.cuarto_de_milla_bayo;
            case "PETISO_ARGENTINO_FIN_TORDILLO_MORO":
                return R.raw.petiso_argentino;
            case "MESTIZO_FIN_OVERO_ROSADO":
                return R.raw.mestizo_overo_rosado;
            case "MESTIZO_FIN_MORO":
                return R.raw.mestizo_mora;
            case "PETISO_ARGENTINO_FIN_ZAINO":
                return R.raw.petiso_argentino_zaino;
            case "MESTIZO_FIN_ALAZAN_PINTADO":
                return R.raw.mestizo_alazan_pintado;
            case "SILLA_ARGENTINO_FIN_ALAZAN":
                return R.raw.silla_argentino_alazan;
            case "CRIOLLO_FIN_BAYO_GATEADO":
                return R.raw.criollo_gateado;
            case "MESTIZO_FIN_ZAINO_OSCURO":
                return R.raw.mestizo_zaino_oscuro;
            case "MESTIZO_FIN_TORDILLO":
                return R.raw.mestizo_tordillo;
            default:
                return R.drawable.defaultfur;
        }
    }

    @NonNull
    private int ubicacionDeAudioDeCaballoPorNombreMasculino(String nombrePalabra) {
        switch (nombrePalabra.toUpperCase()) {
            //Razas
            case "CUARTO_DE_MILLA":
                return R.raw.raza_cuarto_de_milla;
            case "CRIOLLO":
                return R.raw.raza_criollo;
            case "PETISO_ARGENTINO":
                return R.raw.raza_petiso_argentino;
            case "MESTIZO_CRUZA_ARABE":
                return R.raw.raza_mestizo_cruza_arabe;
            case "MESTIZO":
                return R.raw.raza_mestizo;
            case "SILLA_ARGENTINO":
                return R.raw.raza_silla_argentino;
            case "SANGRE_PURO_CARRERA":
                return R.raw.raza_sangre_pura_de_carrera;
            //Pelajes
            case "ALAZAN":
                return R.raw.pelaje_alazan;
            case "ALAZAN_PINTADO":
                return R.raw.pelaje_alazan_pintado;
            case "ALAZAN_RUANO":
                return R.raw.pelaje_alazan_ruano;
            case "ALAZAN_TOSTADO":
                return R.raw.pelaje_alazan_tostado;
            case "BAYO":
                return R.raw.pelaje_bayo;
            case "BAYO_GATEADO":
                return R.raw.pelaje_bayo;
            case "BLANCO":
                return R.raw.pelaje_blanco;
            case "MORO":
                return R.raw.pelaje_moro;
            case "OVERO_AZULEJO":
                return R.raw.pelaje_overo_azulejo;
            case "OVERO_ROSADO":
                return R.raw.pelaje_overo_rosado;
            case "OVERO_ZAINO":
                return R.raw.pelaje_overo_zaino;
            case "PICASO":
                return R.raw.pelaje_picazo;
            case "TOBIANO":
                return R.raw.pelaje_tobiano;
            case "TORDILLO":
                return R.raw.pelaje_tordillo;
            case "TORDILLO_CANELA":
                return R.raw.pelaje_tordillo_canela;
            case "TORDILLO_MORO":
                return R.raw.pelaje_tordillo;
            case "ZAINO":
                return R.raw.pelaje_zaino;
            case "ZAINO_COLORADO":
                return R.raw.pelaje_zaino_colorado;
            case "ZAINO_OSCURO":
                return R.raw.pelaje_zaino_oscuro;
            default:
                return R.raw.relincho;
        }
    }
}