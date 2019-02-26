package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaDificultadFacil extends JugadaDificultad {

    protected int CANT_ELEMENTOS = 2;

    /*
       Constructor de la clase
    */
    public JugadaDificultadFacil(JugadaTipo jugadaTipo) {
        this.tipoAReconocer = jugadaTipo.tipoAReconocer;
        this.tipoGanador = jugadaTipo.tipoAReconocer;
        this.tiposAInteraccionar = jugadaTipo.nTiposAleatoreosConElTipo(jugadaTipo.tipoAReconocer, CANT_ELEMENTOS);
    }

    @Override
    public String tipoDeJugada() {
        return "Jugada dificultad facil"; //creo qiue no se usa, ver como se puede eliminar o algo asi
    }
}
