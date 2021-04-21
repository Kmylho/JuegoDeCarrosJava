package com.Kmylho.JuegoDeCarrosJava.entity.values;

import com.Kmylho.JuegoDeCarrosJava.entity.Jugador;

public class Podio implements Puestos {
    private Jugador primerLugar;
    private Jugador segundoLugar;
    private Jugador tercerLugar;

    public Podio() {
    }

    public void asignarPrimerLugar(Jugador jugador) {
        this.primerLugar = jugador;
    }

    public void asignarSegundoLugar(Jugador jugador) {
        this.segundoLugar = jugador;
    }

    public void asignarTercerLugar(Jugador jugador) {
        this.tercerLugar = jugador;
    }

    public Jugador primerLugar() {
        return this.primerLugar;
    }

    public Jugador segundoLugar() {
        return this.segundoLugar;
    }

    public Jugador tercerLugar() {
        return this.tercerLugar;
    }

    public Boolean estaLleno() {
        Boolean lleno = false;
        if (this.primerLugar != null && this.segundoLugar != null && this.tercerLugar != null) {
            lleno = true;
        }

        return lleno;
    }
}
