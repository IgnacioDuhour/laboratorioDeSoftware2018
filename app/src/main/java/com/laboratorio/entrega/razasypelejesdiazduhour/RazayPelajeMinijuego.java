package com.laboratorio.entrega.razasypelejesdiazduhour;

public class RazayPelajeMinijuego extends MiniJuego {
    @Override
    public String tipoDeJuego() {
        return "Raza y Pelaje";
    }

    public Jugada[] generarSecuenciaDeJugadasAleatoreas() {
        Jugada [] jugadas = new Jugada[TOTAL_JUGADAS];
        TipoCaballo[] razasAleatoreas = TipoCaballo.nTiposAleatoreos(TipoRaza.todosLosTiposDeRazas(),3);
        TipoCaballo[] pelajesAleatoreos = TipoCaballo.nTiposAleatoreos(TipoPelaje.todosLosTiposDePelajes(),2);
        jugadas[0] = this.dificultad.nuevaJugada(razasAleatoreas[0]);
        jugadas[1] = this.dificultad.nuevaJugada(razasAleatoreas[1]);
        jugadas[2] = this.dificultad.nuevaJugada(razasAleatoreas[2]);
        jugadas[3] = this.dificultad.nuevaJugada(pelajesAleatoreos[0]);
        jugadas[4] = this.dificultad.nuevaJugada(pelajesAleatoreos[1]);
        return this.randomDeJugadas(jugadas);
    }

}
