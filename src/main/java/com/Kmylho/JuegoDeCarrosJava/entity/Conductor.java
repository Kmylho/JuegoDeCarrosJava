package com.Kmylho.JuegoDeCarrosJava.entity;

public class Conductor {
    private String nombre;

    public Conductor() {
    }

    public Conductor(String nombre) {
        this.nombre = nombre;
    }

    public String nombre() {
        return this.nombre;
    }

    public Integer lanzarDado() {
        return (int)(Math.random() * 6 + 1);
    }
}
