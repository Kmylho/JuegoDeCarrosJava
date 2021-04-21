package com.Kmylho.JuegoDeCarrosJava.entity;

import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.Nombre;

public class Jugador {
    private Nombre nombre;
    private Integer puntos;

    public Jugador(Nombre nombre, Integer puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public Nombre nombre() {
        return this.nombre;
    }

    public void asignarPuntos(Integer puntos) {
    }
}
