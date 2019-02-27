package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaTipoRazayPelaje  extends JugadaTipo {

    public JugadaTipoRazayPelaje(TipoCaballo tipoCaballo) {
        super(tipoCaballo);
    }

    /*
        Propósito: describe "n" tipos aleatoreos de caballos, incluyendo "tipoAReconocer"
    */
    @Override
    public TipoCaballo[] nTiposAleatoreosConElTipo(TipoCaballo tipoAReconocer, int n) {
        return TipoRazayPelaje.tiposAleatoreasConElTipo(TipoRazayPelaje.todosLosTiposDeRazasyPelajes(), tipoAReconocer, n);
    }

    /*
        Propósito: describe el tipo de jugada
     */
    @Override
    public String tipoDeJugada() {
        return "Raza y Pelaje";
    }
}

