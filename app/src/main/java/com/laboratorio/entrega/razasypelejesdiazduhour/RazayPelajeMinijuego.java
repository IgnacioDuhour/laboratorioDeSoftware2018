package com.laboratorio.entrega.razasypelejesdiazduhour;

public class RazayPelajeMinijuego extends MiniJuego {

    /*
        Cosntructor de clase
     */
    public RazayPelajeMinijuego(Dificultad dificultad) {
        super(dificultad);
    }

    @Override
    public String tipoDeJuego() {
        return "Raza y Pelaje";
    }

    /*
        Propósito: describe las jugadas aleatoreas, definidas por 3 de Razas y 2 de Pelajes ubicadas aleatoreamente
     */
    @Override
    public Jugada[] generarSecuenciaDeJugadasAleatoreas() {
        Jugada [] jugadas = new Jugada[TOTAL_JUGADAS];
        TipoCaballo[] razasAleatoreas = TipoCaballo.nTiposAleatoreos(TipoRaza.todosLosTiposDeRazas(),3);
        TipoCaballo[] pelajesAleatoreos = TipoCaballo.nTiposAleatoreos(TipoPelaje.todosLosTiposDePelajes(),2);
        jugadas[0] = this.dificultad.nuevaJugada(new JugadaTipoRaza((razasAleatoreas[0])));
        jugadas[1] = this.dificultad.nuevaJugada(new JugadaTipoRaza(razasAleatoreas[1]));
        jugadas[2] = this.dificultad.nuevaJugada(new JugadaTipoRaza(razasAleatoreas[2]));
        jugadas[3] = this.dificultad.nuevaJugada(new JugadaTipoPelaje(pelajesAleatoreos[0]));
        jugadas[4] = this.dificultad.nuevaJugada(new JugadaTipoPelaje(pelajesAleatoreos[1]));
        return this.jugadasRandom(jugadas);
    }

}
