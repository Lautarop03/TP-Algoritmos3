package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.Jugador;
import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;

import java.util.List;

public class ViewControlador {
    private PokemonView pokemonView;
    private HabilidadView habilidadView;
    private ItemView itemView;

    public ViewControlador() {
    }

    public void mostrarItem(Item item) {
        if (this.itemView == null) {
            this.itemView = new ItemView();
        }
        itemView.mostrarItem(item);
    }
    public void mostrarPokemon(Pokemon pokemon) {
        if (this.pokemonView == null) {
            this.pokemonView = new PokemonView();
        }
        pokemonView.mostrarPokemon(pokemon);
    }

    public void mostrarHabilidad(Habilidad habilidad) {
        if (this.habilidadView == null) {
            this.habilidadView = new HabilidadView();
        }
        habilidadView.mostrarHabilidad(habilidad);
    }

    public void mostrarCampo(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            System.out.println("Pokemon de: " + jugador.getNombre());
            Pokemon pokemon = jugador.getPokemonActual();
            pokemonView.mostrarPokemon(pokemon);
        }
    }
}
