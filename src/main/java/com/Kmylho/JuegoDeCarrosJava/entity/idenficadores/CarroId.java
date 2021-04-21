package com.Kmylho.JuegoDeCarrosJava.entity.idenficadores;

import java.util.UUID;

public class CarroId {
    private UUID id;

    public CarroId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return this.id.toString();
    }
}
