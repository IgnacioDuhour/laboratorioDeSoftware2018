package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaDificultadDificil extends JugadaDificultad {

    protected int CANT_ELEMENTOS = 4;

    /*
       Constructor de la clase
    */
    public JugadaDificultadDificil(JugadaTipo jugadaTipo) {
        this.tipoAReconocer = jugadaTipo.tipoAReconocer;
        this.tipoGanador = jugadaTipo.tipoAReconocer;
        this.tiposAInteraccionar = jugadaTipo.nTiposAleatoreosConElTipo(jugadaTipo.tipoAReconocer, CANT_ELEMENTOS);
    }

    @Override
    public String tipoDeJugada() {
        return "jugada dificultad dificil"; //creo que esto no se usa, ver como se puede eliminar
    }
}
