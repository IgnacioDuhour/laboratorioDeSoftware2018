package com.laboratorio.entrega.razasypelejesdiazduhour;

class JugadaTipoCruza extends JugadaTipo {

    public JugadaTipoCruza(TipoCaballo tipoCruza) {
        super(tipoCruza);
    }

    /*
       Propósito: describe "n" cruzas aleatoreos de caballos, incluyendo "tipoAReconocer"
     */
    @Override
    public TipoCaballo[] nTiposAleatoreosConElTipo(TipoCaballo tipoAReconocer, int n) {
        return TipoCruza.tiposAleatoreasConElTipo(TipoCruza.todosLosTiposDeCruza(), tipoAReconocer, n);
    }

    /*
        Propósito: describe el tipo de jugada
     */
    @Override
    public String tipoDeJugada() {
        return "Cruza";
    }
}
