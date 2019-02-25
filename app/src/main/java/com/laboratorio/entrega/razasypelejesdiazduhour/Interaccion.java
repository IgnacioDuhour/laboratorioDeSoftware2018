package com.laboratorio.entrega.razasypelejesdiazduhour;

public abstract class Interaccion {

    public abstract int obtenerLayoutFacil();

    public abstract int obtenerLayoutDificil();

    /*
        Propósito: carga el item a reconocer según la configuracion definida. El item a reconocer se ubica en la parte superior
     */
    public abstract void cargarItemAReconocer(Dificultad dificultad, String nombreItem, MiniJuegoActivity miniJuegoActivity);

    /*
        Propósito: carga el item (palabra o imagen) ganador ubicado en la parte inferior segun la dificultad definida
     */
    public abstract void cargarItemGanador(Dificultad dificultad, String nombreItem, MiniJuegoActivity miniJuegoActivity);

    /*
        Propósito: carga los items (palabra o imagen) ganadores ubicados en la parte inferior según la dificultad definida
     */
    public abstract void cargarItemsNoGanadores(Dificultad dificultad, MiniJuegoActivity miniJuegoActivity);


}