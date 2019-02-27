package com.laboratorio.entrega.razasypelejesdiazduhour;

public abstract class JugadaTipo extends Jugada {


    /*
        Constructor de clase que recibe el tipo a reconocer
     */
    public JugadaTipo(TipoCaballo tipoCaballo) {
        this.tipoAReconocer = tipoCaballo;
    }

    /*
        Propósito: describe "n" tipos aleatoreos de caballos, incluyendo "tipoAReconocer"
     */
    public abstract TipoCaballo[] nTiposAleatoreosConElTipo(TipoCaballo tipoAReconocer, int n);

    /*
        Propósito: describe el tipo de jugada, pudiendo ser Raza o Pelaje o Cruza
     */
    public abstract String tipoDeJugada();

    public void setTipoAReconocer(String itemAReconocer) {
        this.tipoAReconocer.setNombre(itemAReconocer);
    }
}
