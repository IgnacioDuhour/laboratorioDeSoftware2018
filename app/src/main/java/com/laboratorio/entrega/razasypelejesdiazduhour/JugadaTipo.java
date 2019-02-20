package com.laboratorio.entrega.razasypelejesdiazduhour;

public abstract class JugadaTipo extends Jugada {


    /*
        Propósito: describe "n" tipos aleatoreos de caballos, incluyendo "tipoAReconocer"
     */
    public abstract TipoCaballo[] nTiposAleatoreosConElTipo(TipoCaballo tipoAReconocer, int n);

    /*
        Propósito: describe el tipo de jugada, pudiendo ser Raza o Pelaje o Cruza
     */
    public abstract String tipoDeJugada();
}
