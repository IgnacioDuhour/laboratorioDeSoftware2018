package com.laboratorio.entrega.razasypelejesdiazduhour;

public enum Pelaje {
    ALAZAN("PRIMAVERA"),
    ALAZAN_2("CACIQUE"),
    ALAZAN_PINTADO("PINTADA"),
    ALAZAN_RUANO("BIONDA"),
    ALAZAN_TOSTADO("AMBAR"),
    BAYO("JUANA"),
    BAYO_GATEADO("TIGRE"),
    BLANCO("BLANCO"),
    MORO("NALA"),
    OVERO_AZULAEJO("BONITA"),
    OVERO_ROSADO("MUNECO"),
    OVERO_ZAINO("ANTU"),
    PICASO("HUALFIN"),
    TOBIANO("CANDELARIA"),
    TORDILLO("ZORZAL"),
    TORDILLO_CANELA("CIRO"),
    TORDILLO_MORO("MORA"),
    ZAINO("FELIPE"),
    ZAINO_2("PAMPERITO"),
    ZAINO_3("POCHITO"),
    ZAINO_COLORADO("ANGOLA"),
    ZAINO_OSCURO("TUPAC");

    String nombre;

    Pelaje(String pelaje) {
        this.nombre = pelaje;
    }

    String nombre() {
        return nombre;
    }

    /*
        Propósito: Describe la cantidad de pelajes existentes
    */
    public static int cantidadDePelajes() {
        return Pelaje.values().length;
    }

}