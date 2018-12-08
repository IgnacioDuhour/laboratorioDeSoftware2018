package com.laboratorio.entrega.razasypelejesdiazduhour;

import java.util.Random;

public class MiniJuego {

    private Jugada[] secuenciaDeJugadas;
    private int ultimaJugadaGanada;
    private int CANTIDAD_JUGADAS=10; //este número depende de la cantidad de razas y pelejaes que haya

    public MiniJuego(){
        this.secuenciaDeJugadas = new Jugada[CANTIDAD_JUGADAS];
        ultimaJugadaGanada = 0;
    }

    /*
        Propósito: Genera una secuencia aleatórea de jugadas para una partida
     */
    private void generarSecuenciaDeJugadasAleatoreas(){

    }


    /*
        Propósito: Retorna una nueva jugada según la última jugada ganada
     */
    private Jugada  nuevaJugada() {
        return new Jugada(secuenciaDeJugadas,ultimaJugadaGanada);
    }

    /*
        Propósito: Avanza a la siguiente jugada
     */
    private void siguienteJugada(){
        this.ultimaJugadaGanada++;
    }


    /*
        Propósito: Inicia el minijuego y genera la secuencia aleatórea de jugadas para una partida
     */
    public void iniciarJuego() {
        generarSecuenciaDeJugadasAleatoreas();
    }


    /*
        Propósito: Retorna la próxima jugada
     */
    public Jugada jugadaProxima()  {
        siguienteJugada();
        return nuevaJugada();
    }

    public Jugada jugadaActual() {
        return this.secuenciaDeJugadas[ultimaJugadaGanada];
    }

    /*
        Propósito: Describe verdadero cuando es la última jugada del minijuego Razas y Pelajes
     */
    public boolean esUltimaJugada() {
        return this.ultimaJugadaGanada == CANTIDAD_JUGADAS;
    }


    /*
        Propósito: Reanuda la jugada actual
     */
    public Jugada reanudarJugada() {
        return this.secuenciaDeJugadas[ultimaJugadaGanada]; // NO ME GUSTA COMO ESTÁ QUEDANDO ESTA PARTE
    }


    /*
        Propósito: suspende la jugada y la guarda para interactuar con otras partes del juego
        Observación: próxima entrega
     */
    public void suspenderJugada(){};


    public int nroAleatorioEntreMinyMax(int min, int max) {
        Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
    }


    


}
