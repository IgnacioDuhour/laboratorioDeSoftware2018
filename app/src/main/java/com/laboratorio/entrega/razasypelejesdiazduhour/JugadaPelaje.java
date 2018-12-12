package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaPelaje extends Jugada {

    /*
        Constructor de la clase
     */
    public JugadaPelaje(TipoPelaje tipoDePelajeAReconecor) {
        this.tipoAReconocer = tipoDePelajeAReconecor;
        this.tipoGanador = new TipoPelaje(tipoDePelajeAReconecor.getPelaje());
        this.tiposAInteraccionar = TipoPelaje.tiposDePelajesAleatoreasConElPelaje((TipoPelaje) tipoAReconocer, 4);
    }

    /*
        Propósito: describe el tipo de jugada que corresponde a "Pelaje"
     */
    public String tipoDeJugada(){
        return "Pelaje";
    }

    /*
        Propósito: Reanuda la jugada de la partida
     */
    public Jugada reanudadJugada() {
        this.tiposAInteraccionar = TipoPelaje.tiposDePelajesAleatoreasConElPelaje((TipoPelaje) this.getTipoAReconocer(),4);
        return this;
    }

}
