package com.laboratorio.entrega.razasypelejesdiazduhour;

import java.util.Random;

public class Aleatorio {

    //Propósito: Retorna un número aleatóreo entre "min" y "max"
    public static int entreMinyMax(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
