package com.laboratorio.entrega.razasypelejesdiazduhour;

class TipoCaballo {

    protected String nombre;

    protected String getNombre() {
        //debería devolver el nombre del enum en minúscula tal vez haya que hacer: this.nombre.toString.toLowercase;
        return this.nombre;
    }

    /*
        Propósito: Genera una secuencia aleatórea de TiposCaballo a partir del parámetro "tipos"
    */
    public static TipoCaballo[] tiposAleatoreos(TipoCaballo[] tipos) {
        TipoCaballo[] tiposAleatoreos = tipos;
        for (int i = 0; i < tipos.length; i++) {
            tiposAleatoreos[i] = tipos[i];
        }
        int j;
        TipoCaballo aux;
        for (int i = 1; i < tiposAleatoreos.length; i++) {
            j = Aleatorio.entreMinyMax(0, i - 1);
            aux = tiposAleatoreos[i];
            tiposAleatoreos[i] = tiposAleatoreos[j];
            tiposAleatoreos[j] = aux;
        }
        return tiposAleatoreos;
    }

    /*
        Propósito: Retorna los tipos pasado por parámetro, pero sin el tipo "tipoAEliminar"
    */
    public static TipoCaballo[] tiposSinElTipo(TipoCaballo[] tipos, TipoCaballo tipoAEliminar) {
        //TODO: es un filter por el tipo de nombre .
        TipoCaballo[] tiposSinElTipo = new TipoCaballo[tipos.length];
        int i = 0;
        for (TipoCaballo tipo : tipos) {
            if (tipo.getNombre() != tipoAEliminar.getNombre()) {
                tiposSinElTipo[i] = tipo;
                i++;
            }
        }
        return tiposSinElTipo;
    }

    /*
        Propósito: describe los tipos elegidos de forma aleatoreas, incluyendo el tipo por parámetro "tipo"
        Precondición: Hay al menos "cantidadDeTipos" definidas en TipoCaballo
    */
    public static TipoCaballo[] tiposAleatoreasConElTipo(TipoCaballo[] tipos, TipoCaballo tipo, int cantidadDeTipos) {
        TipoCaballo[] cuatroTiposAleatoreos = new TipoCaballo[cantidadDeTipos];
        TipoCaballo[] tresTiposAleatoreos = TipoCaballo.tresTiposAleatoreasSinElTipo(tipos, tipo);//generalizar a cantidadDeRazas-1, no a tres (3)
        cuatroTiposAleatoreos[0] = tresTiposAleatoreos[0];
        cuatroTiposAleatoreos[1] = tresTiposAleatoreos[1];
        cuatroTiposAleatoreos[2] = tresTiposAleatoreos[2];
        cuatroTiposAleatoreos[3] = tipo;
        return TipoCaballo.tiposAleatoreos(cuatroTiposAleatoreos);
    }


    /*
        Propósito: describe 3 Tipos elegidos de forma aleatoreas, pero sin el  "tipo"
        Precondición: Hay al menos 3 Tipos
    */
    public static TipoCaballo[] tresTiposAleatoreasSinElTipo(TipoCaballo[] tipos,TipoCaballo sinElTipo) {
        //obtengo todos los tipos sin el tipo "sinElTipo"
        TipoCaballo[] tipoSinElTipo = TipoCaballo.tiposSinElTipo(tipos, sinElTipo);
        //generar los tipos aleatoreos
        TipoCaballo[] tiposAleatoreosSinElTipo = TipoCaballo.tiposAleatoreos(tipoSinElTipo);
        TipoCaballo[] tresTiposAleatoreasSinElTipo = new TipoCaballo[3];
        //obtengo los 3 tipos
        tresTiposAleatoreasSinElTipo[0] = tiposAleatoreosSinElTipo[0];
        tresTiposAleatoreasSinElTipo[1] = tiposAleatoreosSinElTipo[1];
        tresTiposAleatoreasSinElTipo[2] = tiposAleatoreosSinElTipo[2];
        return tresTiposAleatoreasSinElTipo;
    }

}
