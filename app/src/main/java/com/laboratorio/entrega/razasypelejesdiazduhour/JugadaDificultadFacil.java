package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaDificultadFacil extends JugadaDificultad {

    protected int CANT_ELEMENTOS = 2;

    /*
       Constructor de la clase
    */
    public JugadaDificultadFacil(JugadaTipo jugadaTipo) {
        this.tipoAReconocer = jugadaTipo.tipoAReconocer;
        this.tipoGanador = jugadaTipo.tipoGanador;
        this.tiposAInteraccionar = jugadaTipo.nTiposAleatoreosConElTipo(jugadaTipo.tipoAReconocer, CANT_ELEMENTOS);
    }

    @Override
    public String tipoDeJugada() {
        return null;
    }
}
