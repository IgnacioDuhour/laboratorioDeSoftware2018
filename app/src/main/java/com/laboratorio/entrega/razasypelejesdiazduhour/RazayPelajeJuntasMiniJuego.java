package com.laboratorio.entrega.razasypelejesdiazduhour;

public class RazayPelajeJuntasMiniJuego extends MiniJuego {

    public RazayPelajeJuntasMiniJuego(Dificultad dificultad) {
        super(dificultad);
    }

    @Override
    public String tipoDeJuego() {
        return "Raza y Pelaje Juntas";
    }

    /*
        Propósito: describe las jugadas aleatoreas, definidas por 3 de Razas y 2 de Pelajes ubicadas aleatoreamente
    */
    @Override
    public Jugada[] generarSecuenciaDeJugadasAleatoreas() {
        Jugada [] jugadas = new Jugada[TOTAL_JUGADAS];
        TipoCaballo[] razasyPelajesAleatoreos = TipoRazayPelaje.nTiposAleatoreos(TipoRazayPelaje.todosLosTiposDeRazasyPelajes(),5);
        jugadas[0] = this.dificultad.nuevaJugada(new JugadaTipoRazayPelaje((razasyPelajesAleatoreos[0])));
        jugadas[1] = this.dificultad.nuevaJugada(new JugadaTipoRazayPelaje(razasyPelajesAleatoreos[1]));
        jugadas[2] = this.dificultad.nuevaJugada(new JugadaTipoRazayPelaje(razasyPelajesAleatoreos[2]));
        jugadas[3] = this.dificultad.nuevaJugada(new JugadaTipoRazayPelaje(razasyPelajesAleatoreos[3]));
        jugadas[4] = this.dificultad.nuevaJugada(new JugadaTipoRazayPelaje(razasyPelajesAleatoreos[4]));
        return this.jugadasRandom(jugadas);
    }
}
