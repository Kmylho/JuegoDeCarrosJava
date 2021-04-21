package com.Kmylho.JuegoDeCarrosJava.entity.values;

import com.Kmylho.JuegoDeCarrosJava.entity.Jugador;

public interface Puestos {
    Jugador primerLugar();

    Jugador segundoLugar();

    Jugador tercerLugar();

    Boolean estaLleno();
}