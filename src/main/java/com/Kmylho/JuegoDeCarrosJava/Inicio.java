package com.Kmylho.JuegoDeCarrosJava;

import com.Kmylho.JuegoDeCarrosJava.entity.Juego;
import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.JugadorId;
import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.Nombre;

import java.util.Scanner;
import java.util.UUID;

public class Inicio {
    public Inicio() {
        //constructor
    }

    private static void asignarConductoresAJugadores(Juego nuevoJuego, int numeroConductores) {
        for(int i = 0; i < numeroConductores; ++i) {
            JugadorId jugadorId = new JugadorId(UUID.randomUUID());
            Nombre nombre = new Nombre(" Conductor " + (i + 1));
            nuevoJuego.crearJugador(jugadorId, nombre);
        }
    }

    public static void main(String[] args) {
        Juego nuevoJuego = new Juego();
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de conductores: ");
        int numeroConductores = in.nextInt();

        if (numeroConductores >= 3) {
            asignarConductoresAJugadores(nuevoJuego, numeroConductores);

            nuevoJuego.crearPistas();
            nuevoJuego.iniciarJuego();
        } else {
            System.out.println("La carrera debe iniciar con mínimo 3 jugadores");
        }

    }

}
