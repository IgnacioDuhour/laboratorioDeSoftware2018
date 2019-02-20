package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaDificultadDificil extends JugadaDificultad {

    protected int CANT_ELEMENTOS = 4;

    /*
       Constructor de la clase
    */
    public JugadaDificultadDificil(JugadaTipo jugadaTipo) {
        this.tipoAReconocer = jugadaTipo.tipoAReconocer;
        this.tipoGanador = jugadaTipo.tipoGanador;
        this.tiposAInteraccionar = jugadaTipo.nTiposAleatoreosConElTipo(jugadaTipo.tipoAReconocer, CANT_ELEMENTOS);
    }
}
