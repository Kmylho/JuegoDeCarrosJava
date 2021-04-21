package com.Kmylho.JuegoDeCarrosJava.entity;

import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.CarroId;
import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.JuegoId;

import java.util.HashMap;
import java.util.Map;

public class Carro {
    protected Conductor conductor;
    protected Integer distancia;
    protected JuegoId juegoId;
    private final Map<CarroId, Conductor> carros = new HashMap();

    public Carro() {
    }

    public Carro(Conductor conductor, Integer distancia,  JuegoId juegoId) {
        this.conductor = conductor;
        this.distancia = distancia;
        this.juegoId = juegoId;
    }

    public void asignarConductor(CarroId carroId, Conductor conductor) {
        this.carros.put(carroId, conductor);
    }

    public Map<CarroId, Conductor> carros() {
        return this.carros;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Integer numeroCarros() {
        return this.carros.size();
    }

    public Conductor conductor() {
        return this.conductor;
    }

    public Integer distancia() {
        return this.distancia;
    }
}