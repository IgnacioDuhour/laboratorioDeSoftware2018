package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.os.Build;
import android.support.annotation.RequiresApi;

abstract class Jugada {

    protected TipoCaballo tipoAReconocer; //describe el tipo a reconocer ("Raza", "Pelaje" o "Cruza"), que se ubica en la parte superior del juego
    protected TipoCaballo tipoGanador; //describe el tipo ganador, que se ubica en la parte inferior del juego, con la que interaccionará el jugador
    protected TipoCaballo[] tiposAInteraccionar; // describe los tipos con los que interaccionará el jugador. Uno de los tipos es la jugada ganadora


    /*
        Propósito: Describe verdadero cuando es una jugada ganadora, es decir, el nombre tipo a reconocer coincide con el nombre del tipo ganador
     */
    public boolean esJugadaGanada(String nombreJugadaActual){
        return this.nombreDelTipoAReconocer().compareTo(this.nombreDelTipoGanador())==0;
    }

    /*
        Propósito: describe el tipo de jugada que corresponde a la subclase
     */
    public abstract String tipoDeJugada();


    /*
        Propósito: Reanuda la jugada de la partida
     */
    public abstract Jugada reanudadJugada();


    /*
        Propósito: Retorna los nombres de los tipos de la Jugada (por defecto, 4 nombres)
    */

    public String[] nombresDeLosTipos() {
        String[] nombresDeLaJugada = new String[this.cantidadTipos()];
        for (int i=0; i<this.cantidadTipos();i++) {
            nombresDeLaJugada[i] = this.tiposAInteraccionar[i].getNombre();
        }
        return nombresDeLaJugada;
    }

    /*
        Propósito: describe el tipo ganador, pudiendo ser de tipo "Raza", "Cruza" o "Pelaje"
     */
    public TipoCaballo getTipoGanador() {
        return this.tipoGanador;
    }

    /*
        Propósito: describe el tipo a reconocer, pudiendo ser de tipo "Raza", "Cruza" o "Pelaje"
    */
    public TipoCaballo getTipoAReconocer() {
        return this.tipoAReconocer;
    }

    /*
        Propósito: describe el nombre del item ganador
     */
    public String nombreDelTipoGanador() {
        return this.tipoGanador.getNombre();
    }
    /*
        Propósito: describe el nombre del item a reconocer
     */
    public String nombreDelTipoAReconocer() {
        return this.tipoAReconocer.getNombre();
    }

    /*
        Propósito: Describe los nombres de los tipos NO ganadores
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String[] nombresDeLosTiposNoGanadores() {
        //TODO: es un filter por nombre de jugada ganadora. Si cambio a List, usar algo de tipo filter!
        //String[] tipos = Arrays.stream(this.tiposAInteraccionar).filter(t -> this.esTipoGanador(t.getNombre())).toArray(String[]::new));
         String[] nombresDeLosTiposNoGanadores = new String[this.cantidadTipos()-1];
        int j = 0;
        for (int i=0; i<this.cantidadTipos();i++) {
            if (this.tiposAInteraccionar[i].getNombre().compareTo(this.nombreDelTipoGanador())!=0) {
                nombresDeLosTiposNoGanadores[j] = this.tiposAInteraccionar[i].getNombre();
                j++;
            }
        }
        return nombresDeLosTiposNoGanadores;
    }

    public boolean esTipoGanador(String nombreTipo) {
        return (this.nombreDelTipoGanador().compareTo(nombreTipo)==0);
    }


    /*
        Propósito: describe la posición del tipo ganador. La posición se obtiene de tiposAInteraccionar, que están ubicados aleatoreamente.
     */
    public int posicionTipoGanador() {

        // this.tiposAInteraccionar.indexOf(this.getTipoGanador()); si lo hacía con arraylist :(
        int posicion = -1;
        String nombreGanador = this.nombreDelTipoGanador();
        for (int i=0; i<this.cantidadTipos();i++) {
            String nombreActual = this.tiposAInteraccionar[i].getNombre();
            if (this.nombreDelTipoGanador().compareTo(nombreActual)==0) {
                posicion = i; break;
            }
        }
        return posicion;
    }

    /*
        Propósito: describe la cantidad de tipos a interaccionar de la jugada
     */
    private int cantidadTipos() {
        return this.tiposAInteraccionar.length;
    }

    /*
        Propósito: Describe las posiciones de la jugada sin la posición de la jugada ganadora
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] posicionesSinTipoGanador() {
        //TODO: es un filter por la posicion ganadora. Si cambio a List, usar algo de tipo filter!
        int[] posicionesSinTipoGanador  = new int[this.cantidadTipos()-1];
        int posicionTipoGanador         = this.posicionTipoGanador();
        int j = 0;
        for (int i=0; i<this.tiposAInteraccionar.length ;i++) {
            if (posicionTipoGanador != i) {
                posicionesSinTipoGanador[j] = i;
                j++;
            }
        }
        return posicionesSinTipoGanador;
    }

}
