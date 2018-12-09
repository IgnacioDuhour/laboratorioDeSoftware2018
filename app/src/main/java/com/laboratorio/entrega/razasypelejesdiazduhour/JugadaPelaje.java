package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaPelaje extends Jugada {

    private Pelaje pelaje;

    public JugadaPelaje(Pelaje pelajeAReconocer) {
        this.pelaje = pelajeAReconocer;
        this.nombreAReconocer = pelajeAReconocer.toString();
        this.interaccionConimagenesDeCaballos = new InteraccionConImagenesDeCaballos[NIVEL_DIFICULTAD_2];
        this.reconocimientoTexto = new ReconocimientoTexto();
    }

    public String tipoDeJugada(){
        return "Pelaje";
    }
}
