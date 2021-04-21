package com.Kmylho.JuegoDeCarrosJava.entity.idenficadores;

import java.util.UUID;

public class JugadorId {
    private UUID id;

    public JugadorId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return this.id.toString();
    }
}
