package com.laboratorio.entrega.razasypelejesdiazduhour;

public class PalabraImagen extends Interaccion {
    @Override
    public int obtenerLayoutFacil() {
        return R.layout.palabra_imagen_facil;
    }

    @Override
    public int obtenerLayoutDificil() {
        return R.layout.palabra_imagen_dificil;
    }

    /*
        Propósito: carga la palabra a reconocer según la configuracion definida. El item a reconocer se ubica en la parte superior
    */
    @Override
    public void cargarItemAReconocer(Dificultad dificultad, MiniJuegoActivity miniJuegoActivity) {
        dificultad.cargarPalabraAReconocer(miniJuegoActivity);
    }

    /*
        Propósito: carga la imagen ganadora ubicada en la parte inferior segun la dificultad (facil o dificil) definida
     */
    @Override
    public void cargarItemGanador(Dificultad dificultad, MiniJuegoActivity miniJuegoActivity) {
        dificultad.cargarImagenGanadora(miniJuegoActivity);
    }

    /*
        Propósito: carga las imagenes No ganadoras ubicadas en la parte inferior segun la dificultad (facil o dificil) definida
     */
    @Override
    public void cargarItemsNoGanadores(Dificultad dificultad, MiniJuegoActivity miniJuegoActivity) {
        dificultad.cargarImagenesNoGanadoras(miniJuegoActivity);
    }

}
