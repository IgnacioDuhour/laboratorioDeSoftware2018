package com.laboratorio.entrega.razasypelejesdiazduhour;

public class Facil extends Dificultad {

    @Override
    public int obtenerLayout(Interaccion interaccion) {
        return interaccion.obtenerLayoutFacil();
    }

    public int cantidadElementos() { return 2; }

    public Jugada nuevaJugada(JugadaTipo jugadaTipo) {
        return new JugadaDificultadFacil(jugadaTipo);
    }

    /*
        Propósito: carga la palabra a reconocer ubicada en la parte superior.
     */
    @Override
    public void cargarPalabraAReconocer(MiniJuegoActivity miniJuegoActivity){

    }

    /*
        Propósito: carga la imagen a reconocer ubicada en la parte superior.
     */
    @Override
    public void cargarImagenAReconocer(MiniJuegoActivity miniJuegoActivity){

    }

    @Override
    public void cargarImagenGanadora(MiniJuegoActivity miniJuegoActivity) {

    }

    @Override
    public void cargarPalabraGanadora(MiniJuegoActivity miniJuegoActivity) {

    }

    @Override
    public void cargarImagenesNoGanadoras(MiniJuegoActivity miniJuegoActivity) {

    }

    @Override
    public void cargarPalabrasNoGanadoras(MiniJuegoActivity miniJuegoActivity) {

    }


}
