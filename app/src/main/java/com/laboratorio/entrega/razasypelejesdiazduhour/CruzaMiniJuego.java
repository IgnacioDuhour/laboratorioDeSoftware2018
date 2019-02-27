package com.laboratorio.entrega.razasypelejesdiazduhour;

public class CruzaMiniJuego extends MiniJuego {

    public CruzaMiniJuego(Dificultad dificultad) {
        super(dificultad);
    }

    @Override
    public String tipoDeJuego() {
        return "Cruza";
    }

    /*
        Propósito: describe las jugadas aleatoreas, definidas por 3 de Razas y 2 de Pelajes ubicadas aleatoreamente
     */
    @Override
    public Jugada[] generarSecuenciaDeJugadasAleatoreas() {
        Jugada [] jugadas = new Jugada[TOTAL_JUGADAS];
        TipoCaballo[] cruzasAleatoreas = TipoCruza.nTiposAleatoreos(TipoCruza.todosLosTiposDeCruza(),TOTAL_JUGADAS);
        jugadas[0] = new Jugadaruza(cruzasAleatoreas[0], this.dificultad);
        jugadas[0] = this.dificultad.nuevaJugada(new JugadaCruza(cruzasAleatoreas[0]));
        jugadas[1] = this.dificultad.nuevaJugada(new JugadaCruza(cruzasAleatoreas[1]));
        jugadas[2] = this.dificultad.nuevaJugada(new JugadaCruza(cruzasAleatoreas[2]));
        jugadas[3] = this.dificultad.nuevaJugada(new JugadaCruza(cruzasAleatoreas[3]));
        jugadas[4] = this.dificultad.nuevaJugada(new JugadaCruza(cruzasAleatoreas[4]));
        return this.jugadasRandom(jugadas);
    }
}
