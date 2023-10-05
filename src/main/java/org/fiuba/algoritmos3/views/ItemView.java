package org.fiuba.algoritmos3.views;


import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class ItemView {
    public void mostrarItem(Item item) {
        System.out.println(item.getNombre()+ " Cantidad:" + item.getCantidad());
    }

    public void mostrarUsoItem(Jugador jugador, Item item, Pokemon pokemon) {
        System.out.println("El jugador " + jugador.getNombre() + " uso el item " + item.getNombre() + " en el pokemon " + pokemon.getNombre());
    }

    public void mostrarErrorUsoItem(Item item){
        System.out.println("No se pudo aplicar el item: " + item.getNombre());
    }
}