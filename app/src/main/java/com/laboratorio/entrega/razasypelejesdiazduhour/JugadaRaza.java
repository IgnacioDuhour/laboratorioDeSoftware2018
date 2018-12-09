package com.laboratorio.entrega.razasypelejesdiazduhour;

public class JugadaRaza extends Jugada {

    private Raza raza;

    public JugadaRaza(Raza razaAReconocer) {
        this.raza = razaAReconocer;
        this.nombreAReconocer = razaAReconocer.toString();
        this.interaccionConimagenesDeCaballos = new InteraccionConImagenesDeCaballos[NIVEL_DIFICULTAD_2];
        this.reconocimientoTexto = new ReconocimientoTexto();
    }

    public String tipoDeJugada(){
        return "Raza";
    }

}
