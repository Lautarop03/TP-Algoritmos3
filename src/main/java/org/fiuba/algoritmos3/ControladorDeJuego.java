package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.views.PokemonView;
import org.fiuba.algoritmos3.views.JugadorView;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;

import java.util.ArrayList;
import java.util.List;
import  java.util.PriorityQueue;

public class ControladorDeJuego {
    final static int rendirse = 1;
    final static int verCampoDeBatalla = 2;
    final static int intercambiarPokemon = 3;
    final static int item = 4;
    final static int ataque = 5;
    private final Juego juego;
    private final Inputs inputs;
    private final PokemonView pokemonView;

    public ControladorDeJuego(Juego juego, Inputs inputs) {
        this.juego = juego;
        this.inputs = inputs;
        this.pokemonView = new PokemonView();
    }

    private boolean rendirse(){
        juego.getJugadorActual().rendirse();
        return true;
    }
    private boolean verCampo() {
        List<Jugador> jugadores = juego.getJugadores();
        for (Jugador jugador : jugadores) {
            System.out.println("Pokemon de: " + jugador.getNombre());
            Pokemon pokemon = jugador.getPokemonActual();
            pokemonView.mostrarPokemon(pokemon);
        }
        return false;
    }

    private boolean usarItem() {
        Jugador jugadorActual = juego.getJugadorActual();
        List<Item> items = jugadorActual.getItems();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        boolean realizado = false;
        while(!realizado){
            int numeroItem = inputs.pedirItem(items);
            int numeroPokemon = inputs.pedirPokemon(pokemones);
            Item item = items.get(numeroItem);
            if (!item.aplicarItem(jugadorActual.getPokemones().get(numeroPokemon))) {
                System.out.println("No se pudo aplicar el item: " + item.getNombre());
            } else {
                realizado = true;
                return true;
            }
        }
        return false;
    }

    private boolean cambiarPokemon(){
        Jugador jugadorActual = juego.getJugadorActual();
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
        Jugador jugadorActual = juego.getJugadorActual();
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

    public void jugarTurno() {
        System.out.println("Turno de: " + juego.getJugadorActual().getNombre());
        boolean repetir = true;
        do {
            int accion = inputs.pedirAccion();
            switch (accion) {
                case rendirse -> repetir = rendirse();
                case verCampoDeBatalla -> repetir = verCampo();
                case intercambiarPokemon -> repetir = cambiarPokemon();// Luego de cambiar el Pokemon del campo de batalla se termina el turno
                case item -> repetir = usarItem();
                case ataque -> repetir = atacar();
                // TODO: terminar todos los cases y sus respectivas funciones (5 acciones) y ver como manejar los casos (no siempre cambia el turno y termina la accion)
            }
        } while (!repetir);


        juego.cambiarTurno();
    }
}
