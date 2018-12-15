package com.laboratorio.entrega.razasypelejesdiazduhour;

public class MiniJuegoCruza extends MiniJuego {

    /*
        Constructor de la clase
     */
    public MiniJuegoCruza(){

        super();
        this.CANTIDAD_JUGADAS = TipoCruza.cantidadDeCruzas();
        this.secuenciaDeJugadas = new Jugada[CANTIDAD_JUGADAS];
    }

    /*
        Propósito: Describe el tipo del juego. En este caso describe "Juego de Cruzas de caballos"
    */
    public String tipoDeJuego(){
        return "Juego de Cruzas de caballos";
    }

    /*
        Propósito: Retorna todas las jugadas (no aleatoreas) para el tipo de juego 
     */
    @Override
    protected Jugada[] jugadasTotales() {
        Jugada[] jugadasTotales = new Jugada[CANTIDAD_JUGADAS];
        TipoCruza[] tipos = TipoCruza.todosLosTiposDeCruza();
        Raza[] cruzas = Raza.values();
        for (int i = 0; i<CANTIDAD_JUGADAS;i++) {
            jugadasTotales[i] = new JugadaCruza(tipos[i]);
        }
        return jugadasTotales;
    }

}
