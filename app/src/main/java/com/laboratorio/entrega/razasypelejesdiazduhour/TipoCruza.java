package com.laboratorio.entrega.razasypelejesdiazduhour;

public class TipoCruza extends TipoCaballo {

    private Raza razaOriginal;

    /*
        Propósito: Constructor de la clase
    */
    public TipoCruza(Raza razaOriginal) {
        this.razaOriginal = razaOriginal;
        this.nombre = razaOriginal.toString().toLowerCase();
    }

    /*
        Propósito: Describe la cantidad de cruzas existentes
    */
    public static int cantidadDeCruzas() {
        return Raza.values().length;
    }


    public  static TipoCruza cruzaAleatoriaSinLaRaza(Raza raza) {
        TipoCaballo[] tipos = TipoCaballo.tiposAleatoreos(TipoCruza.todosLosTiposDeCruza());
        TipoCaballo[] tiposSinElTipo = TipoCaballo.tiposSinElTipo(tipos, new TipoCruza(raza));
        return (TipoCruza) tiposSinElTipo[0];
    }

    public Raza getRazaOriginal() {
        return this.razaOriginal;
    }


    public static TipoCruza[] todosLosTiposDeCruza() {
        TipoCruza[] todosLosTiposDeCruza = new TipoCruza[TipoCruza.cantidadDeCruzas()];
        int i = 0;
        for (Raza raza : Raza.values()) {
            todosLosTiposDeCruza[i] = new TipoCruza(raza);
            i++;
        }
        return todosLosTiposDeCruza;
    }



}
