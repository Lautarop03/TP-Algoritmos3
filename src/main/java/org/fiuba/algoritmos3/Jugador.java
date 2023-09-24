package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;

import java.util.List;

public class Jugador {

    private List<Pokemon> pokemones;

    private List<Item> items;

    public Jugador(List<Pokemon> pokemones, List<Item> items) {
        this.pokemones = pokemones;
        this.items = items;
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
