package com.laboratorio.entrega.razasypelejesdiazduhour;

public class CruzaMiniJuego extends MiniJuego {

    public CruzaMiniJuego(Dificultad dificultad) {
        super(dificultad);
    }

    @Override
    public String tipoDeJuego() {
        return "Cruza";
    }

    @Override
    public Jugada[] generarSecuenciaDeJugadasAleatoreas() {
        return new Jugada[0];
    }
}
