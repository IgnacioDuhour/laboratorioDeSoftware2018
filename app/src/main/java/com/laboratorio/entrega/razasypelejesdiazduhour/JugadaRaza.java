package com.laboratorio.entrega.razasypelejesdiazduhour;

import java.util.Random;

public class JugadaRaza extends Jugada {

    private Raza razaAReconocer;
    private Raza[] razasAInteraccionar;

    public JugadaRaza(Raza razaAReconocer) {
        this.razaAReconocer = razaAReconocer;
        this.nombreAReconocer = razaAReconocer.toString().toLowerCase();
        this.razasAInteraccionar = Raza.razasAleatoreasConLaRaza(razaAReconocer, 4);
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
        this.razasAInteraccionar = Raza.razasAleatoreasConLaRaza(this.razaAReconocer, 4); //generalizar 4 a nivel_dificultad obtenido de settings
        return this;
    }

    /*
        Propósito: Retorna los nombres (4) de los Pelajes para la jugada
     */
    @Override
    public String[] nombreDeLasJugadas() {
        String[] nombresDeLaJugada = new String[4];
        for (int i=0; i<4;i++) {
            nombresDeLaJugada[i] = razasAInteraccionar[i].toString().toLowerCase();
        }
        return nombresDeLaJugada;    }



}
