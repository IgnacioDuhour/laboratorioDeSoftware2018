package com.laboratorio.entrega.razasypelejesdiazduhour;

public class TipoRaza extends TipoCaballo {

    private Raza raza;

    /*
        Propósito: Constructor de la clase
     */
    public TipoRaza(Raza raza) {
        this.raza = raza;
        this.nombre = raza.toString().toLowerCase();
    }

    /*
        Propósito: describe todos nombres de los razas (en minúscula)
    */
    public static String[] nombresDeLasRazas() {
        String[] todasLasRazas = new String[Raza.values().length];
        Raza[] razas = Raza.values();
        for (int i = 0; i < Raza.values().length; i++) {
            todasLasRazas[i] = razas[i].toString().toLowerCase();
        }
        return todasLasRazas;
    }

    /*
        Propósito: Describe la cantidad de razas existentes
     */
    public static int cantidadDeRazas() {
        return Raza.values().length;
    }

    /*
        Propósito: describe los tipos de razas elegidas de forma aleatoreas, incluyendo el tipo de raza "tipoRaza"
        Precondición: Hay al menos "cantidadDeRazas" definidas en TipoRaza
    */
    public static TipoRaza[] tiposDeRazasAleatoreasConLaRaza(TipoRaza tipoRaza, int cantidadDeRazas) {
        TipoRaza[] cuatroTiposDeRazasAleatoreas = new TipoRaza[cantidadDeRazas];
        TipoRaza[] tresTiposDeRazasAleatoreas = TipoRaza.tresTiposDeRazasAleatoreasSinLaRaza(tipoRaza); //generalizar a cantidadDeRazas-1, no a tres (3)
        cuatroTiposDeRazasAleatoreas[0] = tresTiposDeRazasAleatoreas[0];
        cuatroTiposDeRazasAleatoreas[1] = tresTiposDeRazasAleatoreas[1];
        cuatroTiposDeRazasAleatoreas[2] = tresTiposDeRazasAleatoreas[2];
        cuatroTiposDeRazasAleatoreas[3] = tipoRaza;
        return TipoRaza.tiposDeRazasAleatoreas(cuatroTiposDeRazasAleatoreas);
    }

    /*
        Propósito: describe todos los tipos de razas en función de la cantidad de razas existentes
     */
    public static TipoRaza[] todosLosTiposDeRazas() {
        TipoRaza[] todosLosTiposDeRazas = new TipoRaza[Raza.cantidadDeRazas()];
        int i = 0;
        for (Raza raza : Raza.values()) {
            todosLosTiposDeRazas[i] = new TipoRaza(raza);
            i++;
        }
        return todosLosTiposDeRazas;
    }

    /*
        Propósito: describe la raza
     */
    public Raza getRaza() {
        return this.raza;
    }
    /*
        Propósito: Retorna las razas, pero sin la raza "razaAEliminar"
    */
    private static TipoRaza[] tipoDeRazasSinTipoDeRaza(TipoRaza[] tiposDeRazas, TipoRaza tipoRazaAEliminar) {
        TipoRaza[] tiposDeRazasSinElTipoRaza = new TipoRaza[Raza.cantidadDeRazas() - 1];
        int i = 0;
        for (TipoRaza tipoDeRaza : tiposDeRazas) {
            if (tipoDeRaza.raza != tipoRazaAEliminar.raza) {
                tiposDeRazasSinElTipoRaza[i] = tipoDeRaza;
                i++;
            }
        }
        return tiposDeRazasSinElTipoRaza;
    }

    /*
        Propósito: Genera una secuencia aleatórea de Razas a partir del parámetro "razas"
    */
    private static TipoRaza[] tiposDeRazasAleatoreas(TipoRaza[] tipoRazas) {
        TipoRaza[] tipoDeRazasAleatoreas = tipoRazas;
        for (int i = 0; i < tipoRazas.length; i++) {
            tipoDeRazasAleatoreas[i] = tipoRazas[i];
        }
        int j;
        TipoRaza aux;
        for (int i = 1; i < tipoDeRazasAleatoreas.length; i++) {
            j = Aleatorio.entreMinyMax(0, i - 1);
            aux = tipoDeRazasAleatoreas[i];
            tipoDeRazasAleatoreas[i] = tipoDeRazasAleatoreas[j];
            tipoDeRazasAleatoreas[j] = aux;
        }
        return tipoDeRazasAleatoreas;
    }

    /*
        Propósito: describe 3 Razas elegidas de forma aleatoreas, pero sin la Raza "raza"
        Precondición: Hay al menos 3 Razas
    */
    private static TipoRaza[] tresTiposDeRazasAleatoreasSinLaRaza(TipoRaza tipoRaza) {
        //obtengo todas las razas sin la raza "tipoRaza"
        TipoRaza[] tipoDeRazasSinTipoDeRaza = TipoRaza.tipoDeRazasSinTipoDeRaza(TipoRaza.todosLosTiposDeRazas(), tipoRaza);
        //generar las razas aleatoreas a partir de  razasSinRazaAReconocer
        TipoRaza[] tiposDeRazasAleatoreasSinElTipoRaza = TipoRaza.tiposDeRazasAleatoreas(tipoDeRazasSinTipoDeRaza);
        TipoRaza[] tresTiposDeRazasAleatoreasSinLaRaza = new TipoRaza[3];
        //obtengo las 3 razas
        tresTiposDeRazasAleatoreasSinLaRaza[0] = tipoDeRazasSinTipoDeRaza[0];
        tresTiposDeRazasAleatoreasSinLaRaza[1] = tipoDeRazasSinTipoDeRaza[1];
        tresTiposDeRazasAleatoreasSinLaRaza[2] = tipoDeRazasSinTipoDeRaza[2];
        return tresTiposDeRazasAleatoreasSinLaRaza;
    }

}
