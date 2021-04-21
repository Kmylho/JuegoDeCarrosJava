package com.Kmylho.JuegoDeCarrosJava.entity.values;

public class Pista implements Values {
    private Integer kilometros;
    private Integer numeroDeCarriles;

    public Pista(Integer kilometros, Integer numeroDeCarriles) {
        this.kilometros = kilometros;
        this.numeroDeCarriles = numeroDeCarriles;
    }

    public Integer kilometros() {
        return this.kilometros;
    }

    public Integer numeroDeCarriles() {
        return this.numeroDeCarriles;
    }
}