package com.Kmylho.JuegoDeCarrosJava.entity;

import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.CarroId;
import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.JuegoId;
import com.Kmylho.JuegoDeCarrosJava.entity.values.Posicion;

public class Carril {
    protected CarroId carroId;
    protected JuegoId juegoId;
    protected Posicion posicion;
    protected Integer metros;
    protected Boolean desplazamientoFinal;

    public Carril(CarroId carroId, JuegoId juegoId, Posicion posicion, Integer metros, Boolean desplazamientoFinal) {
        this.carroId = carroId;
        this.juegoId = juegoId;
        this.posicion = posicion;
        this.metros = metros;
        this.desplazamientoFinal = desplazamientoFinal;
    }

    public void alcanzarLaMeta() {
        if (this.posicionActual() >= this.posicionDeseada()) {
            this.desplazamientoFinal = true;
        }
    }

    public void moverCarro(Posicion posicion, Integer cantidad) {
        this.posicion = posicion;
        posicion.setActual(posicion.actual() + cantidad);
        this.alcanzarLaMeta();
    }

    public Integer metros() {
        return this.metros;
    }

    public Posicion posicion() {
        return this.posicion;
    }

    public Integer posicionActual() {
        return this.posicion.actual();
    }

    public Integer posicionDeseada() {
        return this.posicion.meta();
    }

    public Boolean desplazamientoFinal() {
        return this.desplazamientoFinal;
    }
}
