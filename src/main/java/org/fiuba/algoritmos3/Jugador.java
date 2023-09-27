package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;

import java.util.List;

public class Jugador {

    private List<Pokemon> pokemones;
    private String nombre;
    private List<Item> items;

    public Jugador(String nombre,List<Pokemon> pokemones, List<Item> items) {
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
    }

    public void asignarPokemones(List<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon getPokemonActual() {
        return pokemones.get(0);
    }
    public List<Item> getItems() {
        return items;
    }

    public void usarHabilidad() {
        return;
    }
    public void usarItem() {
        return;
    }
    public void cambiarPokemon(){
        return;
    }
    public void rendirse() {
        return;
    }
}
