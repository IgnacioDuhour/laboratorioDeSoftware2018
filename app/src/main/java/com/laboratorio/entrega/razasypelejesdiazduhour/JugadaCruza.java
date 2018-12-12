package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaCruza extends Jugada {

    private Raza cruza;

    /*
        Constructor de la clase
    */
    public JugadaCruza(TipoCruza tipoDeCruzaAReconecor) {
        //this.tipoAReconocer = tipoDeCruzaAReconecor;
        //this.tipoGanador = new TipoCruza(tipoDeCruzaAReconecor.getCruza());
        //this.tiposAInteraccionar = TipoRaza.tiposDeRazasAleatoreasConLaRaza((TipoRaza)tipoAReconocer, 4);
    }

    @Override
    public String tipoDeJugada() {
        return "Cruza";
    }

    @Override
    public Jugada reanudadJugada() {
        return null;
    }

    public Raza getCruza() {
        return this.cruza;
    }

}

