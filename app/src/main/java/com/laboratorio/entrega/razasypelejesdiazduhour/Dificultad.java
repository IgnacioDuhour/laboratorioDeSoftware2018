package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class Dificultad {

    public abstract int obtenerLayout(Interaccion interaccion);

    public abstract Jugada nuevaJugada(JugadaTipo jugadaTipo);

    /*
        Propósito: carga la palabra a reconocer ubicada en la parte superior.
     */
    public void cargarPalabraAReconocer(MiniJuegoActivity miniJuegoActivity, String nombrePalabra){
        TextView palabraAReconocerFacil = (TextView) miniJuegoActivity.findViewById(R.id.palabraAReconocerFacil);
        palabraAReconocerFacil.setText(nombrePalabra);
    }

    /*
        Propósito: carga la imagen a reconocer ubicada en la parte superior.
     */
    public void cargarImagenAReconocer(MiniJuegoActivity miniJuegoActivity, String nombreImagen){
        //se encuentra el imageview
        ImageView imagenGanadora = (ImageView) miniJuegoActivity.findViewById(R.id.imagenAReconocerFacil);
        //se setea el source del imageview
        imagenGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballoPorNombre(nombreImagen));
    }
    /*
        Propósito: carga la palabra ganadora en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarPalabraGanadora(MiniJuegoActivity miniJuegoActivity, String nombrePalabraGanadora, int posicionPalabraGanadora) {
        TextView palabraAReconocer = (TextView) miniJuegoActivity.findViewById(this.idTextViewSegunPosicion(posicionPalabraGanadora));
        palabraAReconocer.setText(nombrePalabraGanadora);
        this.cargarEventoOnClickParaPalabraGanadora(miniJuegoActivity, palabraAReconocer);
    }

    /*
        Propósito: carga la imagen ganadora en la parte inferior del layout, donde se interaccionará para jugar
     */
    public void cargarImagenGanadora(MiniJuegoActivity miniJuegoActivity, String nombreImagenGanadora, int posicionImagenGanadora) {
        ImageView imagenGanadora = (ImageView) miniJuegoActivity.findViewById(this.idImageViewSegunPosicion(posicionImagenGanadora));
        imagenGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballoPorNombre(nombreImagenGanadora));
        this.cargarEventoOnClickParaImagenGanadora(miniJuegoActivity, imagenGanadora);
    }
    /*
        Propósito: carga las imágenes NO ganadoras en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarImagenesNoGanadoras(MiniJuegoActivity miniJuegoActivity, String[] nombresImagenesNoGanadoras, int[] posicionImagenesNoGanadoras) {
        int cantImagenes = nombresImagenesNoGanadoras.length;
        for (int i=0; i<cantImagenes;i++) {
            ImageView imagenNoGanadora = (ImageView) miniJuegoActivity.findViewById(this.idImageViewSegunPosicion(posicionImagenesNoGanadoras[i]));
            imagenNoGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballoPorNombre(nombresImagenesNoGanadoras[i]));
            this.cargarEventoOnClickParaImagenNoGanadora(miniJuegoActivity, imagenNoGanadora);
        }
    }

    /*
        Propósito: carga las palabras NO ganadoras en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarPalabrasNoGanadoras(MiniJuegoActivity miniJuegoActivity, String[] nombresPalabrasNoGanadoras, int[] posicionPalabrasNoGanadoras) {
        int cantPalabras = nombresPalabrasNoGanadoras.length;
        for (int i=0; i<cantPalabras;i++) {
            TextView palabraNoGanadora = (TextView) miniJuegoActivity.findViewById(this.idTextViewSegunPosicion(posicionPalabrasNoGanadoras[i]));
            palabraNoGanadora.setText(nombresPalabrasNoGanadoras[i]);
            this.cargarEventoOnClickParaPalabraNoGanadora(miniJuegoActivity, palabraNoGanadora);
        }
    }

    /*
        Propósito: Carga el evento OnClick para la imagen ganadora
        Precondición: Hay una imagen ganadora cargada en el layout correspondiente
    */
    public void cargarEventoOnClickParaImagenGanadora (MiniJuegoActivity miniJuegoActivity, final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miniJuegoActivity.feedbackDeJugadaGanada();
            }
        });
    }

    /*
        Propósito: Carga el evento OnClick para la palabra ganadora
        Precondición: Hay una palabra ganadora cargada en el layout correspondiente
    */
    public void cargarEventoOnClickParaPalabraGanadora (MiniJuegoActivity miniJuegoActivity, final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miniJuegoActivity.feedbackDeJugadaGanada();
            }
        });
    }

    /*
        Propósito: Carga el evento OnClick para la imagen no ganadora
        Precondición: Hay una imagen No ganadora cargada en el layout correspondiente
    */
    public void cargarEventoOnClickParaImagenNoGanadora (MiniJuegoActivity miniJuegoActivity, final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miniJuegoActivity.feedbackJugadaNoGanada();
            }
        });
    }

    /*
        Propósito: Carga el evento OnClick para la palabra No ganadora
        Precondición: Hay una palabra No ganadora cargada en el layout correspondiente
    */
    public void cargarEventoOnClickParaPalabraNoGanadora (MiniJuegoActivity miniJuegoActivity, final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miniJuegoActivity.feedbackJugadaNoGanada();
            }
        });
    }


    /*
        Propósito: describe el identificador de una ImageView en el layout según una posicion, que representa la ubicación dentro de los elementos a interaccionar
     */
    protected abstract int idImageViewSegunPosicion(int posicion);

    /*
        Propósito: describe el identificador de una Textview en el layout según una posicion, que representa la ubicación dentro de los elementos a interaccionar
     */
    protected abstract int idTextViewSegunPosicion(int posicion);

}