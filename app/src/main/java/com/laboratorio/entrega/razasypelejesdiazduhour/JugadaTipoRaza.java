package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.widget.ImageView;
import android.widget.TextView;

public class JugadaRaza extends Jugada {

    public JugadaRaza(TipoRaza tipoRazaAReconocer, Dificultad dificultad)  {
        this.tipoAReconocer = tipoRazaAReconocer;
        this.tipoGanador = tipoRazaAReconocer;
        this.tiposAInteraccionar = TipoRaza.tiposAleatoreasConElTipo(TipoRaza.todosLosTiposDeRazas(), tipoRazaAReconocer, dificultad.cantidadDeElementos());
    }

    /*
       Propósito: describe "n" tipos aleatoreos de caballos, incluyendo "tipoAReconocer"
     */
    @Override
    public TipoCaballo[] nTiposAleatoreosConElTipo(TipoCaballo tipoAReconocer, int n) {
        return TipoRaza.tiposAleatoreasConElTipo(TipoRaza.todosLosTiposDeRazas(), tipoAReconocer, n);
    }

    /*
        Propósito: describe el tipo de jugada
     */
    @Override
    public String tipoDeJugada() {
        return "Raza";
    }

    /*
        Propósito: carga la palabra a reconocer ubicada en la parte superior.
     */
    public void cargarPalabraAReconocer(MiniJuegoActivity miniJuegoActivity){
        TextView palabraAReconocer = (TextView) miniJuegoActivity.findViewById(R.id.palabraAReconocer);
        palabraAReconocer.setText(sanitizarTexto(this.itemAReconocer()));
    }

    /*
        Propósito: carga la imagen a reconocer ubicada en la parte superior.
     */
    public void cargarImagenAReconocer(MiniJuegoActivity miniJuegoActivity){
        ImageView imagenGanadora = (ImageView) miniJuegoActivity.findViewById(R.id.imagenAReconocer);
        imagenGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballoPorRaza(this.itemAReconocer()));
    }

    /*
        Propósito: carga la palabra ganadora en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarPalabraGanadora(MiniJuegoActivity miniJuegoActivity) {
        TextView palabraAReconocer = (TextView) miniJuegoActivity.findViewById(this.idTextViewSegunPosicion(this.posicionItemGanador()));
        palabraAReconocer.setText(sanitizarTexto(this.itemAReconocer()));
        miniJuegoActivity.cargarEventoOnClickParaPalabraGanadora(palabraAReconocer);
    }

    /*
        Propósito: carga la imagen ganadora en la parte inferior del layout, donde se interaccionará para jugar
     */
    public void cargarImagenGanadora (MiniJuegoActivity miniJuegoActivity) {
        ImageView imagenGanadora = (ImageView) miniJuegoActivity.findViewById(this.idImageViewSegunPosicion(this.posicionItemGanador()));
        imagenGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballoPorRaza(this.itemGanador()));
        miniJuegoActivity.cargarEventoOnClickParaImagenGanadora(imagenGanadora);
    }

    /*
        Propósito: carga las imágenes NO ganadoras en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarImagenesNoGanadoras (MiniJuegoActivity miniJuegoActivity) {
        int cantImagenes = this.cantidadDeItems();
        for (int i=0; i<cantImagenes;i++) {
            ImageView imagenNoGanadora = (ImageView) miniJuegoActivity.findViewById(this.idImageViewSegunPosicion(this.posicionesItemsNoGanadores()[i]));
            imagenNoGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballoPorRaza(this.itemsAInteraccionar()[i]));
            miniJuegoActivity.cargarEventoOnClickParaImagenNoGanadora(imagenNoGanadora);
        }
    }

    /*
        Propósito: carga las palabras NO ganadoras en la parte inferior del layout, donde se interaccionará para jugar
    */
    public void cargarPalabrasNoGanadoras(MiniJuegoActivity miniJuegoActivity) {
        int cantPalabras = this.cantidadDeItems();
        for (int i=0; i<cantPalabras;i++) {
            TextView palabraNoGanadora = (TextView) miniJuegoActivity.findViewById(this.idTextViewSegunPosicion(this.posicionesItemsNoGanadores()[i]));
            palabraNoGanadora.setText(sanitizarTexto(this.itemsNoGanadores()[i]));
            miniJuegoActivity.cargarEventoOnClickParaPalabraNoGanadora(palabraNoGanadora);
        }
    }

    /*
        Propósito: carga la imagen ganadora de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarImagenGanadoraUltimaJugada (MiniJuegoActivity miniJuegoActivity) {
        ImageView imagenGanadora = (ImageView) miniJuegoActivity.findViewById(this.idImageViewSegunPosicion(this.posicionItemGanador()));
        imagenGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballoPorRaza(this.itemGanador()));
        miniJuegoActivity.cargarEventoOnClickParaImagenGanadoraUltimaJugada(imagenGanadora);
    }

    /*
        Propósito: carga las imagenes NO ganadoras de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarImagenesNoGanadorasUltimaJugada (MiniJuegoActivity miniJuegoActivity) {
        int cantImagenes = this.cantidadDeItems();
        for (int i=0; i<cantImagenes;i++) {
            ImageView imagenNoGanadora = (ImageView) miniJuegoActivity.findViewById(this.idImageViewSegunPosicion(this.posicionesItemsNoGanadores()[i]));
            imagenNoGanadora.setImageResource(miniJuegoActivity.ubicacionDeImagenDeCaballoPorRaza(this.itemsNoGanadores()[i]));
            miniJuegoActivity.cargarEventoOnClickParaImagenNoGanadoraUltimaJugada(imagenNoGanadora);
        }
    }

    /*
        Propósito: carga la palabra ganadora de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarPalabraGanadoraUltimaJugada (MiniJuegoActivity miniJuegoActivity){
        TextView palabraAReconocer = (TextView) miniJuegoActivity.findViewById(this.idTextViewSegunPosicion(this.posicionItemGanador()));
        palabraAReconocer.setText(sanitizarTexto(this.itemGanador()));
        miniJuegoActivity.cargarEventoOnClickParaPalabraGanadoraUltimaJugada(palabraAReconocer);
    }

    /*
        Propósito: carga las palabras NO ganadoras de la última jugada
        Precondición: Es la última jugada
    */
    public void cargarPalabrasNoGanadorasUltimaJugada (MiniJuegoActivity miniJuegoActivity) {
        int cantPalabras = this.cantidadDeItems();
        for (int i=0; i<cantPalabras;i++) {
            TextView palabraNoGanadora = (TextView) miniJuegoActivity.findViewById(this.idTextViewSegunPosicion(this.posicionesItemsNoGanadores()[i]));
            palabraNoGanadora.setText(sanitizarTexto(this.itemsNoGanadores()[i]));
            miniJuegoActivity.cargarEventoOnClickParaPalabraNoGanadoraUltimaJugada(palabraNoGanadora);
        }
    }

    protected String sanitizarTexto(String texto) {
        return texto.replace("_", " ").toUpperCase();
    }


}
