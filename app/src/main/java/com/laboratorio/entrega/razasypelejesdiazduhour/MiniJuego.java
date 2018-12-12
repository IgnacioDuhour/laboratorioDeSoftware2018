package com.laboratorio.entrega.razasypelejesdiazduhour;

import java.util.Random;

public abstract class MiniJuego {

    protected Jugada[] secuenciaDeJugadas; //describe una secuencia de jugadas aleatoreas definidas al inicio del juego
    protected Jugada jugadaActual; //Describe la jugada actual, sea de "Raza", "Pelaje" o "Cruza"
    protected int indiceJugadaActual; // describe la posición de la jugada actual en "secuenciaDeJugadas"
    protected int CANTIDAD_JUGADAS; //describe un número según de la cantidad de jugadas que haya


    /*
        Constructor de la clase
    */
    public MiniJuego() {
        this.indiceJugadaActual = 0;
    }

    /*
        Propósito: Inicia el minijuego y genera la secuencia aleatórea de jugadas para una partida
     */
    public void iniciarJuego() {
        this.indiceJugadaActual = 0;
        generarSecuenciaDeJugadasAleatoreas();
        this.jugadaActual = this.secuenciaDeJugadas[indiceJugadaActual];
    }

    /*
        Propósito: Retorna la jugada siguiente según la última jugada ganada
        Precondición: Existe una jugada siguiente, es decir, esUltimaJugada es falso
     */
    public Jugada jugadaSiguiente()  {
        this.indiceJugadaActual++;
        this.jugadaActual = secuenciaDeJugadas[indiceJugadaActual];
        return this.jugadaActual;
    }

    /*
        Propósito: Reanuda la jugada actual
     */
    public Jugada reanudarJugada() {
        return this.jugadaActual.reanudadJugada();
    }

    /*
        Propósito: Retorna la jugada actual
     */
    public Jugada jugadaActual() { return jugadaActual; }

    /*
        Propósito: Describe la cantidad de jugadas para una partida
     */
    public int cantidadDeJugadas() { return CANTIDAD_JUGADAS; }

    /*
        Propósito: Describe el tipo del juego pudiendo ser "Raza y Pelaje", "Raza y Pelaje juntas" o "Cruza"
     */
    public abstract String tipoDeJuego();

    /*
        Propósito: Describe verdadero cuando es la última jugada del minijuego
     */
    public boolean esUltimaJugada() {
        return this.indiceJugadaActual == CANTIDAD_JUGADAS-1;
    }

    /*
        Propósito: Retorna los nombre de la jugada actual
     */
    public String[] nombresDeLaJugadaActual() { return this.jugadaActual.nombresDeLosTipos(); }


    /*
        Propósito: Retorna el nombre a reconocer de la jugada actual
    */
    public String nombreAReconocerDeLaJugadaActual() { return this.jugadaActual.nombreDelTipoAReconocer(); }

    /*
        Propósito: Describe el tipo de jugada de la jugada actual, pudiendo ser Raza o Pelaje
     */
    public String tipoDeLaJugadaActual() {
        return this.jugadaActual.tipoDeJugada();
    }

    /*
        Propósito: suspende la jugada y la guarda para interactuar con otras partes del juego
        Observación: próxima entrega
     */
    public void suspenderJugada(){};


    /*
        Propósito: describe la posición del item ganador (texto o imagen) de la jugada actual.
     */
    public int posicionItemGanadorDeJugadaActual() {
        return this.jugadaActual.posicionTipoGanador();
    }


    /*
        Propósito: describe las posiciones de las imágenes no ganadoras de la jugada actual
        Observación: "posición" es un valor entre 1,2,3 o 4 que corresponder a un imageView específico
     */
    public int[] posicionesSinImagenGanadoraDeJugadaActual() {
        return this.jugadaActual.posicionesSinTipoGanador();
    }

    /*
        Propósito: Describe los nombres de los tipos NO ganadores de la jugada actual
     */
    public String[] nombresDeTiposNoGanadoresDeJugadaActual() {
        return this.jugadaActual.nombresDeLosTiposNoGanadores();
    }


    /*
        Propósito: Genera una secuencia aleatórea de jugadas para una partida
    */
    public void generarSecuenciaDeJugadasAleatoreas(){
        Jugada[] jugadas = jugadasTotales();
        this.secuenciaDeJugadas = new Jugada[CANTIDAD_JUGADAS];
        for (int i=0; i<CANTIDAD_JUGADAS;i++) {
            this.secuenciaDeJugadas[i] = jugadas[i];
        }
        for (int i=1; i<CANTIDAD_JUGADAS;i++) {
            swapJugadas(i, Aleatorio.entreMinyMax(0,i-1));
        }
    }

    /*
        Propósito: Retorna todas las jugadas (no aleatoreas) para el tipo de juego deifnido ("Cruza" o "Raza y Pelaje")
     */
    protected abstract Jugada[] jugadasTotales();

    /*
        Propósito: Intercambia dos jugadas de la secuencia de jugadas
     */
    protected void swapJugadas(int i, int j) {
        Jugada aux;
        aux = this.secuenciaDeJugadas[i];
        this.secuenciaDeJugadas[i] = this.secuenciaDeJugadas[j];
        this.secuenciaDeJugadas[j] = aux;
    }


}
