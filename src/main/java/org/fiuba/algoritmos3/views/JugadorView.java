package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.Jugador;
import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;

import java.util.List;

public class JugadorView {

    public void mostrarPokemonesJugador(Jugador jugador) {
        List<Pokemon> pokemones = jugador.getPokemones();
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon);
        }
    }

    public void mostrarItemsJugador(Jugador jugador) {
        List<Item> items = jugador.getItems();
        for (Item item : items) {
            System.out.println("Item: "+item.getNombre()+", Cantidad restante: " + item.getCantidad());
        }
    }
}