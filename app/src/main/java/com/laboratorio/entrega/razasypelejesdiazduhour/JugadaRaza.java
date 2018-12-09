package com.laboratorio.entrega.razasypelejesdiazduhour;

import java.util.Random;

public class JugadaRaza extends Jugada {

    private Raza razaAReconocer;
    private Raza[] cuatroRazasDistintas;


    public JugadaRaza(Raza razaAReconocer) {
        this.razaAReconocer = razaAReconocer;
        this.nombreAReconocer = razaAReconocer.toString().toLowerCase();
        this.cuatroRazasDistintas = Raza.cuatroRazasAleatoreasConLaRaza(razaAReconocer);
    }

    /*
        Propósito: describe el tipo de jugada que corresponde a "Raza"
     */
    public String tipoDeJugada(){
        return "Raza";
    }

    /*
        Propósito: Reanuda la jugada de la partida
     */
    public Jugada reanudadJugada(){
        this.cuatroRazasDistintas = Raza.cuatroRazasAleatoreasConLaRaza(this.razaAReconocer);
        return this;
    }

    /*
        Propósito: Retorna los nombres (4) de los Pelajes para la jugada
     */
    @Override
    public String[] nombreDeLasJugadas() {
        String[] nombresDeLaJugada = new String[4];
        for (int i=0; i<4;i++) {
            nombresDeLaJugada[i] = cuatroRazasDistintas[i].toString().toLowerCase();
        }
        return nombresDeLaJugada;    }

    @Override
    public int posicionJugadaGanadora() {
        return 0;
    }


}
