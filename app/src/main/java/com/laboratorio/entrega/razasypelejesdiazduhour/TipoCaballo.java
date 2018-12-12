package com.laboratorio.entrega.razasypelejesdiazduhour;

class TipoCaballo {

    protected String nombre;

    protected String getNombre() {
        //debería devolver el nombre del enum en minúscula tal vez haya que hacer: this.nombre.toString.toLowercase;
        return this.nombre;
    }

}
