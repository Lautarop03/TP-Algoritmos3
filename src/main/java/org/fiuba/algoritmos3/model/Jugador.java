package org.fiuba.algoritmos3.model;

import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jugador {
    private Pokemon pokemonActual;
    private final ArrayList<Pokemon> pokemones; // invariante, el pokemon actual siempre es el del indice 0
    private final String nombre;
    private final List<Item> items;
    private Boolean ganador;

    public Jugador(String nombre,ArrayList<Pokemon> pokemones, List<Item> items) {
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
        this.pokemonActual = pokemones.get(0);
        this.ganador = false;
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
    public void setGanador(Boolean bool) {
        this.ganador = bool;
    }

    public Boolean getGanador(){
        return ganador;
    }

    public int getCantidadPokemonVivos(){
        int contador = 0;
        for (Pokemon pokemon : this.pokemones) {
            if (pokemon.estaVivo()) {
                contador += 1;
            }
        }
        return contador;
    }
}
