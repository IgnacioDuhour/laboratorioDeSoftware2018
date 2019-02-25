package com.laboratorio.entrega.razasypelejesdiazduhour;

public class Dificil extends Dificultad {
    @Override
    public int obtenerLayout(Interaccion interaccion) {
        return interaccion.obtenerLayoutDificil();
    }

    public int cantidadElementos() { return 4; }

    public Jugada nuevaJugada(JugadaTipo jugadaTipo) {
        return new JugadaDificultadDificil(jugadaTipo);
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
    public void cargarImagenAReconocer(MiniJuegoActivity miniJuegoActivity) {

    }

    /*
        Propósito: carga la imagen ganadora en la parte inferior del layout, donde se interaccionará para jugar
    */
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
