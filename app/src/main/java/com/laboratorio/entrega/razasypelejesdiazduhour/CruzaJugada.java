package com.laboratorio.entrega.razasypelejesdiazduhour;

public class CruzaJugada extends Jugada {
    @Override
    public String tipoDeJugada() {
        return "Cruza";
    }

    @Override
    public Jugada reanudadJugada() {
        return null;
    }

    @Override
    public String[] nombreDeLasJugadas() {
        return new String[0];
    }
}
