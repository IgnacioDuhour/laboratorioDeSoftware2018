package com.laboratorio.entrega.razasypelejesdiazduhour;

public class MiniJuegoCruza extends MiniJuego {

    /*
        Constructor de la clase
     */
    public MiniJuegoCruza(){
        this.indiceJugadaActual = 0;
        //this.CANTIDAD_JUGADAS = Cruza.cantidadDeCruzas();
        this.CANTIDAD_JUGADAS = Raza.cantidadDeRazas();
        this.secuenciaDeJugadas = new Jugada[CANTIDAD_JUGADAS];
    }

    /*
        Propósito: Describe "Cruza", el tipo del juego
    */
    public String tipoDeJuego(){
        return "Juego de Cruzas de caballos";
    }

    /*
        Propósito: Retorna todas las jugadas (no aleatoreas) para el tipo de juego deifnido ("Cruza" o "Raza y Pelaje")
     */
    @Override
    protected Jugada[] jugadasTotales() {
        Jugada[] jugadasTotales = new Jugada[CANTIDAD_JUGADAS];
        Raza[] cruzas = Raza.values();
        for (int i = 0; i<CANTIDAD_JUGADAS;i++) {
            //jugadasTotales[i] = new JugadaCruza(cruzas[i]);
        }
        return jugadasTotales;
    }

}
