package com.laboratorio.entrega.razasypelejesdiazduhour;

public class ImagenImagen extends Interaccion {
    @Override
    public int obtenerLayoutFacil() {
        return R.layout.imagen_imagen_facil;
    }

    @Override
    public int obtenerLayoutDificil() {
        return R.layout.imagen_imagen_dificil;
    }

    /*
        Propósito: carga la imagen a reconocer según la configuracion definida. El item a reconocer se ubica en la parte superior
    */
    @Override
    public void cargarItemAReconocer(Dificultad dificultad, MiniJuegoActivity miniJuegoActivity, String nombreItemAReconocer) {
        dificultad.cargarImagenAReconocer(miniJuegoActivity, nombreItemAReconocer);
    }

    /*
        Propósito: carga la imagen ganadora ubicada en la parte inferior segun la dificultad (facil o dificil) definida
    */
    @Override
    public void cargarItemGanador(Dificultad dificultad, MiniJuegoActivity miniJuegoActivity, String nombreItemGanador, int posicionItemGanador) {
        dificultad.cargarImagenGanadora(miniJuegoActivity, nombreItemGanador, posicionItemGanador);
    }

    /*
        Propósito: carga las imagenes No ganadoras ubicadas en la parte inferior segun la dificultad (facil o dificil) definida
     */
    @Override
    public void cargarItemsNoGanadores(Dificultad dificultad, MiniJuegoActivity miniJuegoActivity, String[] itemsNoGanadores, int[] posicionItemsNoGanadores) {
        dificultad.cargarImagenesNoGanadoras(miniJuegoActivity, itemsNoGanadores, posicionItemsNoGanadores);
    }

    /*
        Propósito: carga el item Ganador de la última jugada
        Precondición: Es la última jugada
     */
    @Override
    public void cargarItemGanadorUltimaJugada(Dificultad dificultad, MiniJuegoActivity miniJuegoActivity, String itemGanadorUltimaJugada, int posicionItemGanadorDeJugadaActual) {
        dificultad.cargarImagenGanadoraUltimaJugada(miniJuegoActivity, itemGanadorUltimaJugada, posicionItemGanadorDeJugadaActual);
    }

    /*
        Propósito: carga los itemns no ganadores de la última jugada
        Precondición: Es la última jugada
    */
    @Override
    public void cargarItemsNoGanadoresUltimaJugada(Dificultad dificultad, MiniJuegoActivity miniJuegoActivity, String[] itemsNoGanadoresUltimaJugada, int[] posicionItemsNoGanadoresUltimaJugada) {
        dificultad.cargarImagenesNoGanadoraUltimaJugada(miniJuegoActivity, itemsNoGanadoresUltimaJugada, posicionItemsNoGanadoresUltimaJugada);
    }
}
