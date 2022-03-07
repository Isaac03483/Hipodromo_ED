package com.ameri.enums;

public enum Orden {

    ALFABETICO("Alfabético"),
    NUMERICO("Numérico");

    private String orden;

    Orden(String orden){
        this.orden = orden;
    }

    public String getOrden(){
        return this.orden;
    }

    public static Orden obtenerOrden(String value){

        if(value.equals(ALFABETICO.getOrden())){
            return ALFABETICO;
        } else if(value.equals(NUMERICO.getOrden())){
            return NUMERICO;
        }

        return null;
    }
}
