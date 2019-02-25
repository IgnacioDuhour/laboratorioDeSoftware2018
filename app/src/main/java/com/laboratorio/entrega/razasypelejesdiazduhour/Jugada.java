package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

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
        return this.tiposAInteraccionar.indexOf(this.itemGanador());
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
    public List<String> itemsAInteraccionar() {
        //return this.tiposAInteraccionar.map(item -> item.getNombre());
        List<String> itemsAInteraccionar = new ArrayList<String>();
        for (TipoCaballo tipo: this.tiposAInteraccionar) {
            itemsAInteraccionar.add(tipo.getNombre());
        }
        return itemsAInteraccionar;
    }
    /*
        Propósito: describe la cantidad de items con los que se interaccionará segun la configuración
     */
    public int cantidadDeItems() {
        return this.tiposAInteraccionar.size();
    }

    /*
        Propósito: Describe los items NO ganadores
        Resultado: una lista de Strings
     */
    public List<String> itemsNoGanadores() {
        //Removes the value from the optional value if it does not match a given predicate.
       //return this.itemsAInteraccionar().filter(item -> ((String)item).compareTo(this.itemGanador())!=0 );
        List<String> itemsNoGanadores = new ArrayList<String>();
        for (TipoCaballo tipo: this.tiposAInteraccionar) {
            if (tipo.getNombre().compareTo(this.itemGanador())!=0) {
                itemsNoGanadores.add(tipo.getNombre());
            }
        }
        return itemsNoGanadores;
    }

    /*
        Propósito: Describe las posiciones de los items a interaccionar sin la posición del item ganador
     */
    public int[] posicionesSinItemGanador() {
        int j = 0;
        int[] posicionesSinItemGanador  = new int[this.cantidadDeItems()];
        for (int i=0; i<this.tiposAInteraccionar.size() ;i++) {
            if (this.posicionItemGanador() != i) {
                posicionesSinItemGanador[j] = i;
                j++;
            }
        }
        return posicionesSinItemGanador;
    }

    public abstract String tipoDeJugada();
}
