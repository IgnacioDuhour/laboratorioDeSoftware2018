package com.laboratorio.entrega.razasypelejesdiazduhour;

import java.util.Random;

public class MiniJuego {

    private Jugada[] secuenciaDeJugadas;
    private Jugada jugadaActual;
    private int indiceJugadaActual;
    private int CANTIDAD_JUGADAS; //describe un número según de la cantidad de razas y pelejaes que haya

    public MiniJuego(){
        this.secuenciaDeJugadas = new Jugada[CANTIDAD_JUGADAS];
        indiceJugadaActual = 0;
        this.CANTIDAD_JUGADAS = Raza.cantidadDeRazas()+Pelaje.cantidadDePelajes();
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
        Propósito: Retorna la próxima jugada según la última jugada ganada
        Precondición: Existe una próxima jugada, es decir, esUltimaJugada es falso
     */
    public Jugada jugadaSiguiente()  {
        this.indiceJugadaActual++;
        this.jugadaActual = secuenciaDeJugadas[indiceJugadaActual];
        return this.jugadaActual;
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
        Propósito: Describe verdadero cuando es la última jugada del minijuego Razas y Pelajes
     */
    public boolean esUltimaJugada() {
        return this.indiceJugadaActual == CANTIDAD_JUGADAS;
    }

    /*
        Propósito: Reanuda la jugada actual
     */
    public Jugada reanudarJugada() {
        return this.jugadaActual.reanudadJugada();//this.secuenciaDeJugadas[indiceJugadaActual]; // NO ME GUSTA COMO ESTÁ QUEDANDO ESTA PARTE
    }

    /*
        Propósito: Retorna los nombre de la jugada actual
     */
    public String[] nombresDeLaJugadaActual() {
        return this.jugadaActual.nombreDeLasJugadas();
    }

    /*
        Propósito: Retorna el nombre a reconocer de la jugada actual
    */
    public String nombreAReconocerDeLaJugadaActual() {
        return this.jugadaActual.nombreAReconocer;
    }

    public String tipoDeLaJugadaActual() {
        return this.jugadaActual.tipoDeJugada();
    }

    /*
        Propósito: suspende la jugada y la guarda para interactuar con otras partes del juego
        Observación: próxima entrega
     */
    public void suspenderJugada(){};



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

    //Propósito: Retorna todas las jugadas que existan para las razas y pelajes existentes en el mini juego
    private Jugada[] jugadasTotales() {
        Jugada[] jugadasTotales = new Jugada[CANTIDAD_JUGADAS];
        Raza[] razas = Raza.values();
        Pelaje[] pelajes = Pelaje.values();
        for (int i=0; i<Raza.cantidadDeRazas();i++) { jugadasTotales[i] = new JugadaRaza(razas[i]); }
        int j=0;
        for (int i = Raza.cantidadDeRazas(); i<CANTIDAD_JUGADAS;i++) {
            jugadasTotales[i] = new JugadaPelaje(pelajes[j]);
            j++;
        }
        return jugadasTotales;
    }

    //Propósito: Intercambia dos jugadas de la secuencia de jugadas
    private void swapJugadas(int i, int j) {
        Jugada aux;
        aux = this.secuenciaDeJugadas[i];
        this.secuenciaDeJugadas[i] = this.secuenciaDeJugadas[j];
        this.secuenciaDeJugadas[j] = aux;
    }

    public static void main(String[] args) {
        /*MiniJuego m = new MiniJuego();
        m.iniciarJuego();
        imprimirValores(m.secuenciaDeJugadas);
        System.out.println("------------------------------------------");
        System.out.println(m.jugadaActual.nombreAReconocer);
        System.out.println(m.jugadaSiguiente().nombreAReconocer);
        System.out.println(m.jugadaSiguiente().nombreAReconocer);
        System.out.println(m.jugadaSiguiente().nombreAReconocer);*/
    }

    private static void imprimirValores(Jugada[] r) {
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i].nombreAReconocer);
        }
    }


}
