package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaPelaje extends Jugada {

    private Pelaje pelajeAReconocer;
    private Pelaje[] cuatroPelajesDistintos;

    public JugadaPelaje(Pelaje pelajeAReconocer) {
        this.pelajeAReconocer = pelajeAReconocer;
        this.nombreAReconocer = pelajeAReconocer.toString().toLowerCase();
        this.cuatroPelajesDistintos = Pelaje.cuatroPelajesAleatoreosConElPelaje(pelajeAReconocer);
    }

    /*
        Propósito: describe el tipo de jugada que corresponde a "Pelaje"
     */
    public String tipoDeJugada(){
        return "Pelaje";
    }

    /*
        Propósito: Reanuda la jugada de la partida
     */
    public Jugada reanudadJugada() {
        this.cuatroPelajesDistintos = Pelaje.cuatroPelajesAleatoreosConElPelaje(this.pelajeAReconocer);
        return this;
    }

    /*
        Propósito: Retorna los cuatro (4) nombres aleatoreos de las Razas para la jugada
     */
    @Override
    public String[] nombreDeLasJugadas() {
        String[] nombresDeLaJugada = new String[4];
        for (int i=0; i<4;i++) {
            nombresDeLaJugada[i] = cuatroPelajesDistintos[i].toString().toLowerCase();
        }
        return nombresDeLaJugada;
    }

    @Override
    public int posicionDeLaJugadaGanadora() {
        return 0;
    }

}
