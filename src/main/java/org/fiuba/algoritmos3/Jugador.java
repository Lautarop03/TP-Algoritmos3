package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jugador {
    private Pokemon pokemonActual;
    private final ArrayList<Pokemon> pokemones; // invariante, el pokemon actual siempre es el del indice 0
    private final String nombre;
    private final List<Item> items;

    public Jugador(String nombre,ArrayList<Pokemon> pokemones, List<Item> items) {
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
        this.pokemonActual = pokemones.get(0);
    }
    public ArrayList<Pokemon> getPokemones() {
        return pokemones;
    }
    public String getNombre() {
        return nombre;
    }
    public Pokemon getPokemonActual() {
        return pokemonActual;
    }
    public List<Item> getItems() {
        return items;
    }
    public Boolean intercambiarPokemon(Pokemon nuevoPokemon){
        if (!nuevoPokemon.estaVivo()) {
            return false;
        } else {
            pokemonActual = nuevoPokemon;
            Collections.swap(pokemones,0,pokemones.indexOf(nuevoPokemon));
            return true;
        }
    }
    public void rendirse() {
        this.pokemones.clear();
    }
}
