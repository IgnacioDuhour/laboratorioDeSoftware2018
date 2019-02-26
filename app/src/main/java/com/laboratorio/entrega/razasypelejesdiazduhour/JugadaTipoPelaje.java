package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaTipoPelaje extends  JugadaTipo {


    public JugadaTipoPelaje(TipoCaballo tipoCaballo) {
        super(tipoCaballo);
    }

    @Override
    public TipoCaballo[] nTiposAleatoreosConElTipo(TipoCaballo tipoAReconocer, int n) {
        return TipoPelaje.tiposAleatoreasConElTipo(TipoPelaje.todosLosTiposDePelajes(), tipoAReconocer, n);
    }

    /*
        Propósito: describe el tipo de jugada
     */
    @Override
    public String tipoDeJugada() {
        return "Pelaje";
    }
}