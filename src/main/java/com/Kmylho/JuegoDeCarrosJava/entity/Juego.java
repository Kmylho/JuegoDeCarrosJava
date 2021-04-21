package com.Kmylho.JuegoDeCarrosJava.entity;

import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.CarroId;
import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.JuegoId;
import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.JugadorId;
import com.Kmylho.JuegoDeCarrosJava.entity.idenficadores.Nombre;
import com.Kmylho.JuegoDeCarrosJava.entity.values.Posicion;

import java.util.*;

public class Juego {
    protected HashMap<JugadorId, Jugador> jugadores = new HashMap<>();
    protected Pista pista;
    protected Boolean jugando;
    protected Podio podio = new Podio();
    protected ArrayList<Pista> pistas = new ArrayList<>();
    protected ArrayList<Carro> carrosEnJuego = new ArrayList<>();
    protected ArrayList<Carril> carrilesEnJuego = new ArrayList<>();
    private final Carro carro = new Carro();

    public Juego() {
        //constructor
    }

    public void crearJugador(JugadorId jugadorId, Nombre nombre) {
        Jugador jugador = new Jugador(nombre, 0);
        this.jugadores.put(jugadorId, jugador);
        this.crearConductor(nombre);
    }

    public void crearConductor(Nombre nombre) {
        Conductor conductor = new Conductor(nombre.getNombre());
        UUID id = UUID.randomUUID();
        CarroId carroId = new CarroId(id);
        this.carro.asignarConductor(carroId, conductor);
    }

    public void crearPistas() {
        int numeroCarriles = this.carro.numeroCarros();
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de KM de la pista: " );
        int kilometrosRandom = in.nextInt();
        Pista pista = new Pista(kilometrosRandom, numeroCarriles);
        this.pistas.add(pista);
    }

    public void asignarPrimerLugar(JugadorId jugadorId) {
        this.podio.asignarPrimerLugar(this.jugadores.get(jugadorId));
        System.out.println((this.jugadores.get(jugadorId)).nombre().getNombre() + ": Primer Lugar");
    }

    public void asignarSegundoLugar(JugadorId jugadorId) {
        this.podio.asignarSegundoLugar(this.jugadores.get(jugadorId));
        System.out.println((this.jugadores.get(jugadorId)).nombre().getNombre() + ": Segundo Lugar");
    }

    public void asignarTercerLugar(JugadorId jugadorId) {
        this.podio.asignarTercerLugar(this.jugadores.get(jugadorId));
        System.out.println((this.jugadores.get(jugadorId)).nombre().getNombre() + ": Tercer Lugar");
    }

    public void iniciarJuego() {
        UUID id = UUID.randomUUID();
        JuegoId juegoId = new JuegoId(id);
        Scanner in = new Scanner(System.in);
        System.out.println("Elige una pista:  ");
        int counter = 1;

        mostrarLasPistas(counter);

        int pistaElegida = in.nextInt();
        this.carro.carros().forEach((key, value) -> {
            Carro carrosJuego = new Carro(value, 0, juegoId);
            this.carrosEnJuego.add(carrosJuego);
            int kilometrosToMetros = (this.pistas.get(pistaElegida - 1)).kilometros() * 1000;
            Posicion posicion = new Posicion(0, kilometrosToMetros);
            Carril carriles = new Carril(key, juegoId, posicion, kilometrosToMetros, false);
            this.carrilesEnJuego.add(carriles);
        });
        this.jugando = true;
        Conductor conductor = new Conductor();
        System.out.println("La carrera va a iniciar");

        mostrarDistanciaDeLaPista(conductor);

        this.mostrarPodio();
        this.repetirJuego();
    }

    private void mostrarDistanciaDeLaPista(Conductor conductor) {
        while(this.jugando) {
            int contador = 0;
            System.out.println("Esta pista tiene una distancia de: " + (this.carrilesEnJuego.get(contador)).metros() + " metros");
            mostrarAvanceDeLosCarros(conductor, contador);
            if (this.podio.estaLleno()) {
                break;
            }
        }
    }

    private void mostrarAvanceDeLosCarros(Conductor conductor, int contador) {
        for(Iterator<Carro> var8 = this.carrosEnJuego.iterator(); var8.hasNext(); ++contador) {
            Carro carros = var8.next();
            if (!this.yaGanoCarro(carros.conductor().nombre())) {
                int mover = conductor.lanzarDado() * 100;
                carros.setDistancia(carros.distancia() + mover);
                (this.carrilesEnJuego.get(contador)).moverCarro((this.carrilesEnJuego.get(contador)).posicion(), mover);
                System.out.println(carros.conductor().nombre() + ": avansa: " + mover + " Nueva posición: " + carros.distancia());
                asignarPodioSiEstaVacio(contador, carros);
            }
        }
    }

    private void asignarPodioSiEstaVacio(int contador, Carro carros) {
        if ((this.carrilesEnJuego.get(contador)).desplazamientoFinal()) {
            asignarPodioSiEstaVacioPodio(carros);
        }
    }

    private void asignarPodioSiEstaVacioPodio(Carro carros) {
        if (this.podio.primerLugar() == null) {
            this.asignarPrimerLugar(this.jugadorID(carros.conductor().nombre()));
        } else if (this.podio.segundoLugar() == null) {
            this.asignarSegundoLugar(this.jugadorID(carros.conductor().nombre()));
        } else if(this.podio.tercerLugar() == null)
            this.asignarTercerLugar(this.jugadorID(carros.conductor().nombre()));
    }

    private void mostrarLasPistas(int counter) {
        for(Iterator<Pista> var5 = this.pistas.iterator(); var5.hasNext(); ++counter) {
            Pista p = var5.next();
            System.out.println(counter + ".Cantidad en KM: " + p.kilometros());
        }
    }

    public Map<JugadorId, Jugador> jugadores() {
        return this.jugadores;
    }

    public Boolean jugando() {
        return this.jugando;
    }

    public JugadorId jugadorID(String nombre) {
        JugadorId lookId = null;
        Iterator<JugadorId> var3 = this.jugadores.keySet().iterator();

        while(var3.hasNext()) {
            JugadorId keys = var3.next();
            if ((this.jugadores.get(keys)).nombre().getNombre().equals(nombre)) {
                lookId = keys;
            }
        }

        return lookId;
    }

    public Boolean yaGanoCarro(String nombre) {
        return this.podio.tercerLugar() == this.jugadores.get(this.jugadorID(nombre)) || this.podio.primerLugar() == this.jugadores.get(this.jugadorID(nombre)) || this.podio.segundoLugar() == this.jugadores.get(this.jugadorID(nombre));
    }

    public void repetirJuego() {
        Scanner in = new Scanner(System.in);
        System.out.println("Desea jugar otra carrera?  Y/N");

        while(!in.hasNext("[yYnN]")) {
            System.out.println("Solo se reciben como respuesta Y/N ó y/n");
            in.next();
        }

        String jugarOtro = in.next();
        if (jugarOtro.equals("Y") || jugarOtro.equals("y")) {
            this.carrosEnJuego.clear();
            this.carrilesEnJuego.clear();
            this.podio = new Podio();
            this.iniciarJuego();
        }

    }

    public void mostrarPodio() {
        System.out.println("Podio");
        System.out.println("Primer Puesto:  " + this.podio.primerLugar().nombre().getNombre());
        System.out.println("Segundo Puesto:  " + this.podio.segundoLugar().nombre().getNombre());
        System.out.println("Tercer Puesto:  " + this.podio.tercerLugar().nombre().getNombre());
    }
}
