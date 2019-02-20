package com.laboratorio.entrega.razasypelejesdiazduhour;

public class CruzaMiniJuego extends MiniJuego {
    @Override
    public String tipoDeJuego() {
        return "Cruza";
    }

    @Override
    public Jugada[] generarSecuenciaDeJugadasAleatoreas() {
        return new Jugada[0];
    }
}
