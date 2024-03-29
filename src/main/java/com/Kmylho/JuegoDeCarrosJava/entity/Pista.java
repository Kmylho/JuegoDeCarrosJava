package com.Kmylho.JuegoDeCarrosJava.entity;

import com.Kmylho.JuegoDeCarrosJava.entity.values.Values;

public class Pista implements Values {
    private final Integer kilometros;
    private final Integer numeroDeCarriles;

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
