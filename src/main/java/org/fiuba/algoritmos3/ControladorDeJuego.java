package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.views.ItemView;
import org.fiuba.algoritmos3.views.PokemonView;

import java.util.List;

public class ControladorDeJuego {
    final static int rendirse = 1;
    final static int verCampoDeBatalla = 2;
    final static int intercambiarPokemon = 3;
    final static int item = 4;
    final static int ataque = 5;
    private Juego juego;
    private Inputs inputs;
    private PokemonView pokemonView;
    public ControladorDeJuego(Juego juego, Inputs inputs) {
        this.juego = juego;
        this.inputs = inputs;
        this.pokemonView = new PokemonView();
    }
    public void verCampo() {
        List<Jugador> jugadores = juego.getJugadores();
        for (Jugador jugador : jugadores) {
            System.out.println("Pokemon de: " + jugador.getNombre());
            Pokemon pokemon = jugador.getPokemonActual();
            pokemonView.imprimirPokemon(pokemon);
        }
    }
    public void aplicarItem() {
        Jugador jugadorActual = juego.getJugadorActual();
        int item = inputs.pedirItem(jugadorActual.getItems());
        // TODO: aplicar item recibido por input
    }

    public void jugarTurno() {
        // mostrar juego?

        int accion = inputs.pedirAccion();

        switch (accion) {
            case verCampoDeBatalla -> verCampo();
            case item -> aplicarItem();
            // TODO: terminar todos los case y sus respectivas funciones (5 acciones)
        }
    }
}
