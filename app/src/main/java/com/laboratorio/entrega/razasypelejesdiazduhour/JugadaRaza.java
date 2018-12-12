package com.laboratorio.entrega.razasypelejesdiazduhour;

import java.util.Random;

public class JugadaRaza extends Jugada {


    /*
        Constructor de la clase
     */
    public JugadaRaza(TipoRaza tipoDeRazaAReconecor) {
        this.tipoAReconocer = tipoDeRazaAReconecor;
        this.tipoGanador = new TipoRaza(tipoDeRazaAReconecor.getRaza());
        this.tiposAInteraccionar = TipoCaballo.tiposAleatoreasConElTipo(TipoRaza.todosLosTiposDeRazas(),tipoDeRazaAReconecor,4);
    }

    /*
        Propósito: describe el tipo de jugada que corresponde a "Raza"
    */
    public String tipoDeJugada(){
        return "Raza";
    }

    /*
        Propósito: Reanuda la jugada de la partida
     */
    public Jugada reanudadJugada(){
        this.tiposAInteraccionar = TipoCaballo.tiposAleatoreasConElTipo(TipoRaza.todosLosTiposDeRazas(),this.tipoAReconocer,4);//generalizar 4 a nivel_dificultad obtenido de settings
        return this;
    }

}
