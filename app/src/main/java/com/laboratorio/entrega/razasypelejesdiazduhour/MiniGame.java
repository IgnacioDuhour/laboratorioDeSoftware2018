package com.laboratorio.entrega.razasypelejesdiazduhour;

public class MiniGame {

    private Jugada[] secuenciaDeJugadas;
    private int ultimaJugadaGanada;
    private int CANTIDAD_JUGADAS=10; //este número depende de la cantidad de razas y pelejaes que haya

    public MiniGame(){
        this.secuenciaDeJugadas = new Jugada[CANTIDAD_JUGADAS];
        ultimaJugadaGanada = 0;
    }

    /*
        Propósito: Genera una secuencia aleatórea de jugadas para una partida
     */
    private void generarSecuenciaJugadasAleatoreas(){

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
        generarSecuenciaJugadasAleatoreas();
    }


    /*
        Propósito: Retorna la próxima jugada
     */
    public Jugada jugadaProxima()  {
        siguienteJugada();
        return nuevaJugada();
    }

    /*
        Propósito: Describe verdadero cuando es la última jugada del minijuego Razas y Pelajes
     */
    public boolean esUltimaJugada() {

    }


    /*
        Propósito: Reanuda la jugada actual
     */
    public void reanudarJugada() {

    }


    /*
        Propósito: suspende la jugada y la guarda para interactuar con otras partes del juego
        Observación: próxima entrega
     */
    public void suspenderJugada(){};
}
