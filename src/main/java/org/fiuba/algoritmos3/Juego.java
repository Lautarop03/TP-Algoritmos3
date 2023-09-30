package org.fiuba.algoritmos3;
import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.views.ViewControlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Juego {
    private final AdministradorDeTurno administradorDeTurno;
    private final Inputs inputs;
    private final List<Jugador> jugadores;
    private final ViewControlador viewControlador;

    public Juego(List<Jugador> jugadores) throws IOException {
        this.inputs = new Inputs();
        this.viewControlador = new ViewControlador();
        this.jugadores = jugadores;
        this.administradorDeTurno = new AdministradorDeTurno(jugadores);
    }

    public boolean terminado() {
        return false;
    } // TODO: Ver cuando el juego esta terminado

    public void aplicarEstados() { // TODO : Aplicar efectos de un pokemon
    }
    public void cambiarTurno() {
        administradorDeTurno.pasarTurno();
    }
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public Jugador getJugadorActual() {
        return administradorDeTurno.getJugadorActual();
    }

    public boolean rendirse(){
        getJugadorActual().rendirse();
        return true;
    }
    public boolean verCampo() {
        viewControlador.mostrarCampo(this.jugadores);  // TODO: MOSTRAR EL ESTADO DEL POKEMON(si tiene)
        return false;
    }

    public boolean usarItem() { // TODO: El usuario debe tener una forma de cancelar la operacion
        Jugador jugadorActual = getJugadorActual();
        List<Item> items = jugadorActual.getItems();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        boolean realizado = false;
        while(!realizado){
            int numeroItem = inputs.pedirItem(items);
            int numeroPokemon = inputs.pedirPokemon(pokemones);
            Item item = items.get(numeroItem);
            if (!item.aplicarItem(jugadorActual.getPokemones().get(numeroPokemon))) { // TODO: si no se puede aplicar el item devolver error
                System.out.println("No se pudo aplicar el item: " + item.getNombre());
            } else {
                realizado = true;
                return true;
            }
        }
        return false; // TODO: Mostrar la accion realizada para el otro jugador
    }

    public boolean cambiarPokemon(){
        Jugador jugadorActual = getJugadorActual();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        while (true) {
            int numeroPokemon = inputs.pedirPokemon(pokemones);
            if (numeroPokemon == 6) { // Volver al menu
                return false;
            }
            boolean realizado = jugadorActual.intercambiarPokemon(pokemones.get(numeroPokemon));
            if (realizado) {
                return true;
            }
        }
        // TODO: se debe mostrar un mensaje que muestre la accion realizada para el otro jugador.
        // donde iria este metodo/funcion?
    }

    public boolean atacar() {
        Jugador jugadorActual = getJugadorActual();
        Pokemon pokemonActual = jugadorActual.getPokemonActual();
        while(true){
            int numeroHabilidad = inputs.pedirHabilidad(pokemonActual.getHabilidades());
            if (numeroHabilidad == 6) {
                return false;
            }
            if (pokemonActual.getHabilidades().get(numeroHabilidad).getCantidadDeUsos() == 0){//ver como comprobar de manera decente (no como hice yo) que la habilidad tenga usos restantes
                System.out.println("Habilidad sin usos, elegir otra");
            } else {
                // Todo: hay que agregar la habilidad a un heap de minimo ordenada por las velocidades de los pokemones
                return true;
            }

        }
    }
}
