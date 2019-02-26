package com.laboratorio.entrega.razasypelejesdiazduhour;

public class RazayPelajeJuntasMiniJuego extends MiniJuego {

    public RazayPelajeJuntasMiniJuego(Dificultad dificultad) {
        super(dificultad);
    }

    @Override
    public String tipoDeJuego() {
        return "Raza y Pelaje Juntas";
    }

    @Override
    public Jugada[] generarSecuenciaDeJugadasAleatoreas() {
        return new Jugada[0];
    }
}
