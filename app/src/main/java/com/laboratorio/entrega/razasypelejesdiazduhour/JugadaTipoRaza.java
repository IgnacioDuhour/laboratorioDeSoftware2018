package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaTipoRaza extends JugadaTipo {

    public JugadaTipoRaza(TipoCaballo tipoCaballo) {
        super(tipoCaballo);
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

}
