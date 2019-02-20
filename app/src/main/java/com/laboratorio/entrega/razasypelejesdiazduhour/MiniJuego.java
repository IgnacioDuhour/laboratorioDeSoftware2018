package com.laboratorio.entrega.razasypelejesdiazduhour;

public abstract class MiniJuego {

    protected Jugada[] jugadasSecuencia; //describe una secuencia de jugadas aleatoreas definidas al inicio del juego
    protected Jugada jugadaActual; //Describe la jugada actual, sea de "Raza", "Pelaje" o "Cruza"
    protected int indiceJugadaActual; // describe la posición de la jugada actual en "secuenciaDeJugadas"
    protected int cantidadDeJugadasGanadas; //describe la cantidad de jugadas ganadas hasta el momento
    protected int CANT_MIN_JUGADAS_A_GANAR = 3; // Describe la cantidad minima de jugadas necesarias para ganar el minijuego
    protected int TOTAL_JUGADAS = 5; //Describe la cantidad de jugadas totales por minijuego

    public Dificultad dificultad;

    /*
        Constructor de la clase
    */
    public MiniJuego(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    /*
        Propósito: Inicia el minijuego y genera la secuencia aleatórea de jugadas para una partida
     */
    public void iniciar() {
        this.indiceJugadaActual = 0;
        this.cantidadDeJugadasGanadas = 0;
        this.jugadasSecuencia = this.randomDeJugadas();
        this.jugadaActual = this.jugadasSecuencia[indiceJugadaActual];
    }

    /*
        Propósito: Se ubica en la jugada siguiente
        Precondición: Existe una jugada siguiente
     */
    public void irAProximaJugada()  {
        this.indiceJugadaActual++;
        this.cantidadDeJugadasGanadas ++;
        this.jugadaActual = jugadasSecuencia[indiceJugadaActual];
    }

    /*
        Propósito:      Reanuda el minijuego actual
        Precondición:   El minijuego actual no se ha ganado, es decir,
                        la cantidad de jugadas ganadas es menor a la cantidad de jugadas minimas necesarias para ganar
     */
    public void reIniciar() {
        this.iniciar();
    }

    /*
        Propósito: Retorna la jugada actual
     */
    public Jugada jugadaActual() { return jugadaActual; }

    /*
        Propósito: Describe la cantidad de jugadas para una partida
     */
    public int cantidadDeJugadas() { return TOTAL_JUGADAS; }

    /*
        Propósito: Describe el tipo del juego pudiendo ser "Raza y Pelaje", "Raza y Pelaje juntas" o "Cruza"
     */
    public abstract String tipoDeJuego();

    /*
    Propósito: describe verdadero cuando se ganó la jugada
    */
    public boolean esJugadaGanada() {
        return this.cantidadDeJugadasGanadas >= CANT_MIN_JUGADAS_A_GANAR;
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
        Propósito: describe los nombres de los caballos de la jugada actual
        Precondición: Hay una jugada actual asignada
     */
    public Map jugarJugadaActual() {
        return this.jugadaActual.jugar();
    }

    /*
        Propósito: Genera una secuencia aleatórea de jugadas para una partida
    */
    public Jugada[]randomDeJugadas() {
        Jugada[] jugadasAleatoreas = jugadasTotales;
        for (int i=0; i<TOTAL_JUGADAS;i++) {
            this.jugadasSecuencia[i] = jugadasAleatoreas[i];
        }
        for (int i=1; i<TOTAL_JUGADAS;i++) {
            swapJugadas(i, Aleatorio.entreMinyMax(0,i-1));
        }
        return jugadasAleatoreas;
    }


    /*
        Propósito: Intercambia dos jugadas de la secuencia de jugadas
     */
    protected void swapJugadas(int i, int j) {
        Jugada aux;
        aux = this.jugadasSecuencia[i];
        this.jugadasSecuencia[i] = this.jugadasSecuencia[j];
        this.jugadasSecuencia[j] = aux;
    }


}
