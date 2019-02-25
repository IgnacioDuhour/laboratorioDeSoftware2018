package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.os.Build;
import android.support.annotation.RequiresApi;
import fj.data.List;
import static fj.data.List.list;

abstract class Jugada {

    protected TipoCaballo tipoAReconocer; //describe el tipo a reconocer ("Raza", "Pelaje" o "Cruza"), que se ubica en la parte superior del juego
    protected TipoCaballo tipoGanador; //describe el tipo ganador, que se ubica en la parte inferior del juego, con la que interaccionará el jugador
    protected TipoCaballo tipoSeleccionado; //describe el tipo seleccionado de los a interaccionar
    protected List<TipoCaballo> tiposAInteraccionar; // describe los tipos con los que interaccionará el jugador. Uno de los tipos es la jugada ganadora

    //protected int posicionItemGanador; //describe la posicion del item ganador

    /*
        Propósito: Describe verdadero cuando es una jugada ganadora, es decir, el item a reconocer coincide con el item seleccionador
     */
    public boolean esJugadaGanada(){
        return this.itemAReconocer().compareTo(this.itemSeleccionado())==0;
    }

    /*
        Propósito: describe el item seleccionado luego de jugar
     */
    public String itemSeleccionado() {
        return this.tipoSeleccionado.getNombre();
    }

    /*
        Propósito: describe el item a reconocer
     */
    public String itemAReconocer() {
        return this.tipoAReconocer.getNombre();
    }

    /*
        Propósito: describe la posición del item a ganador, el cual se encuentra en los tipos a interaccionar
        Resultado: número entero entre 0 y la cantidad de items a interaccionar
    */
    public int posicionItemGanador() {
        //this.itemsAInteraccionar().foldRight((i->  ),-1);
        return 0;
    }

    /*
        Propósito: describe el item ganador
     */
    public String itemGanador() {
        return this.tipoGanador.getNombre();
    }

    /*
        Propósito: describe los items a interaccionar
     */
    public List itemsAInteraccionar() {
        //return this.tiposAInteraccionar.map(item -> item.getNombre());
        return null; //esto debe retornar una lista de strings, no lista de TipoCaballo.
    }
//https://www.functionaljava.org/examples-java8.html

    /*
        Propósito: describe la cantidad de items con los que se interaccionará segun la configuración
     */
    public int cantidadDeItems() {
        return this.tiposAInteraccionar.length();
    }

    /*
        Propósito: Describe los items NO ganadores
        Resultado: una lista de Strings
     */
    public List itemsNoGanadores() {
        //Removes the value from the optional value if it does not match a given predicate.
       return this.itemsAInteraccionar().filter(item -> ((String)item).compareTo(this.itemGanador())!=0 );
    }

    /*
        Propósito: Describe las posiciones de la jugada sin la posición de la jugada ganadora
     */
    public int[] posicionesSinTipoGanador() {

        //TODO: es un filter por la posicion ganadora. Si cambio a List, usar algo de tipo filter!
   /*     int[] posicionesSinTipoGanador  = new int[this.cantidadTipos()-1];
        int posicionTipoGanador         = this.posicionTipoGanador();
        int j = 0;
        for (int i=0; i<this.tiposAInteraccionar.length ;i++) {
            if (posicionTipoGanador != i) {
                posicionesSinTipoGanador[j] = i;
                j++;
            }
        }
        return posicionesSinTipoGanador;
        */
        return null;
    }

    public abstract String tipoDeJugada();
}
