package com.laboratorio.entrega.razasypelejesdiazduhour;

public class MiniJuegoRazayPelaje extends MiniJuego {

    /*
        Constructor de la clase
     */
    public MiniJuegoRazayPelaje(){
        this.indiceJugadaActual = 0;
        this.CANTIDAD_JUGADAS = Raza.cantidadDeRazas()+Pelaje.cantidadDePelajes();
        this.secuenciaDeJugadas = new Jugada[CANTIDAD_JUGADAS];
    }

    /*
        Propósito: Describe el tipo del juego.
    */
    public String tipoDeJuego(){
        return "Juego de Razas y Pelajes de caballos";
    }

    /*
        Propósito: Retorna todas las jugadas (no aleatoreas) para el tipo de juego deifnido ("Cruza" o "Raza y Pelaje")
     */
    @Override
    protected Jugada[] jugadasTotales() {
        Jugada[] jugadasTotales = new Jugada[CANTIDAD_JUGADAS];
        TipoRaza[] tiposRazas = TipoRaza.todosLosTiposDeRazas();
        TipoPelaje[] tiposPelajes = TipoPelaje.todosLosTiposDePelajes();
        for (int i=0; i<Raza.cantidadDeRazas();i++) { jugadasTotales[i] = new JugadaRaza(tiposRazas[i]); }
        int j=0;
        for (int i = Raza.cantidadDeRazas(); i<CANTIDAD_JUGADAS;i++) {
            jugadasTotales[i] = new JugadaPelaje(tiposPelajes[j]);
            j++;
        }
        return jugadasTotales;
    }
}
