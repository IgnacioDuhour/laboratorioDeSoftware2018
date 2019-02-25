package com.laboratorio.entrega.razasypelejesdiazduhour;

public abstract class Dificultad {

    public abstract int obtenerLayout(Interaccion interaccion);

    public abstract Jugada nuevaJugada(JugadaTipo jugadaTipo);

    /*
        Propósito: carga la palabra a reconocer ubicada en la parte superior.
     */
    public abstract void cargarPalabraAReconocer(MiniJuegoActivity miniJuegoActivity);

    /*
        Propósito: carga la imagen a reconocer ubicada en la parte superior.
     */
    public abstract void cargarImagenAReconocer(MiniJuegoActivity miniJuegoActivity);

    /*
        Propósito: carga la imagen ganadora en la parte inferior del layout, donde se interaccionará para jugar
    */
    public abstract void cargarImagenGanadora(MiniJuegoActivity miniJuegoActivity);

    /*
        Propósito: carga la palabra ganadora en la parte inferior del layout, donde se interaccionará para jugar
    */
    public abstract void cargarPalabraGanadora(MiniJuegoActivity miniJuegoActivity);

    /*
        Propósito: carga las imágenes NO ganadoras en la parte inferior del layout, donde se interaccionará para jugar
    */
    public abstract void cargarImagenesNoGanadoras(MiniJuegoActivity miniJuegoActivity);

    /*
        Propósito: carga las palabras NO ganadoras en la parte inferior del layout, donde se interaccionará para jugar
    */
    public abstract void cargarPalabrasNoGanadoras(MiniJuegoActivity miniJuegoActivity);

}