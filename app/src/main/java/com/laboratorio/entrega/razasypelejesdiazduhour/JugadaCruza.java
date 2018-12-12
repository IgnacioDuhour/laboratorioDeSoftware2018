package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaCruza extends Jugada {

    /*
        Constructor de la clase
    */
    public JugadaCruza(TipoCruza tipoDeCruzaAReconocer) {
        this.tipoAReconocer = tipoDeCruzaAReconocer;
        this.tipoGanador = TipoCruza.cruzaAleatoriaSinLaRaza(tipoDeCruzaAReconocer.getRazaOriginal()); //aca debería setearlo con la raza correspondiente de la cruza
        this.tiposAInteraccionar = TipoCaballo.tiposAleatoreasConElTipo(TipoCruza.todosLosTiposDeCruza(),tipoDeCruzaAReconocer,4);
    }

    @Override
    public String tipoDeJugada() {
        return "Cruza";
    }

    /*
       Propósito: Reanuda la jugada de la partida
     */
    @Override
    public Jugada reanudadJugada() {
        this.tiposAInteraccionar = TipoCaballo.tiposAleatoreasConElTipo(TipoCruza.todosLosTiposDeCruza(),this.tipoAReconocer,4);
        return this;
    }

}

