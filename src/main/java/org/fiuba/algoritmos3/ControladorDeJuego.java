package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.views.PokemonView;

import java.util.ArrayList;
import java.util.List;

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
    private void verCampo() {
        List<Jugador> jugadores = juego.getJugadores();
        for (Jugador jugador : jugadores) {
            System.out.println("Pokemon de: " + jugador.getNombre());
            Pokemon pokemon = jugador.getPokemonActual();
            pokemonView.mostrarPokemon(pokemon);
        }
    }
    private void aplicarItem() {
        Jugador jugadorActual = juego.getJugadorActual();
        List<Item> items = jugadorActual.getItems();
        int numeroitem = inputs.pedirItem(items);
        Item item = items.get(numeroitem);
        //item.aplicarItem();
        // TODO: aplicar item recibido por input
    }

    private Boolean cambiarPokemon(){
        Jugador jugadorActual = juego.getJugadorActual();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        while (true) {
            int numeroPokemon = inputs.pedirPokemon(pokemones);
            if (numeroPokemon == 6) { // Volver al menu
                return false;
            }
            Boolean realizado = jugadorActual.intercambiarPokemon(pokemones.get(numeroPokemon));
            if (realizado) {
                return true;
            }
        }
        // TODO: se debe mostrar un mensaje que muestre la accion realizada para el otro jugador.
        // donde iria este metodo/funcion?
    }
    public void atacar() {
        Jugador jugadorActual = juego.getJugadorActual();
        Pokemon pokemonActual = jugadorActual.getPokemonActual();
        // TODO: terminar esto
    }


    public void jugarTurno() {
        System.out.println("Turno de: " + juego.getJugadorActual().getNombre());

        int accion = inputs.pedirAccion();

        switch (accion) {
            case intercambiarPokemon -> cambiarPokemon(); // Luego de cambiar el Pokemon del campo de batalla se termina el turno
            case verCampoDeBatalla -> verCampo();
            case item -> aplicarItem();
            case ataque -> atacar();
            // TODO: terminar todos los cases y sus respectivas funciones (5 acciones) y ver como manejar los casos (no siempre cambia el turno y termina la accion)
        }

        juego.cambiarTurno();
    }
}
