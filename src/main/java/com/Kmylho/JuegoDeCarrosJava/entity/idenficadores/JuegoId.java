package com.Kmylho.JuegoDeCarrosJava.entity.idenficadores;

import java.util.UUID;

public class JuegoId {
    private UUID id;

    public JuegoId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return this.id.toString();
    }
}