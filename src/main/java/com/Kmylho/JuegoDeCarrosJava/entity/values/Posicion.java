package com.Kmylho.JuegoDeCarrosJava.entity.values;

public class Posicion implements Props {
    private Integer actual;
    private Integer meta;

    public Integer actual() {
        return this.actual;
    }

    public Integer meta() {
        return this.meta;
    }

    public void setActual(Integer actual) {
        this.actual = actual;
    }

    public Posicion(Integer actual, Integer meta) {
        this.actual = actual;
        this.meta = meta;
    }
}
