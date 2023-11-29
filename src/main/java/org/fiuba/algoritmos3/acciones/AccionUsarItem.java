package org.fiuba.algoritmos3.acciones;

import org.fiuba.algoritmos3.model.AdministradorDeJuego;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.PaqueteDeRespuesta;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class AccionUsarItem implements Accion{

    @Override
    public boolean realizarAccion(Juego juego) {
        AdministradorDeJuego administradorDeJuego = juego.getAdministradorDeJuego();
        Jugador jugadorActual = juego.getJugadorActual();
        List<Item> items = jugadorActual.getItems();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        while (true) { // boolean false o true retorno, excepcion imprimo y sigo
                PaqueteDeRespuesta<Integer> paqueteItem = administradorDeJuego.pedirItem(items);
                if (!paqueteItem.getError()) {
                    return false;
                }
                PaqueteDeRespuesta<Integer> paquetePokemon = administradorDeJuego.pedirPokemon(pokemones);
                if (!paquetePokemon.getError()) {
                    return false;
                }
                Item item = items.get(paqueteItem.getGenerico());
                boolean aplicado = juego.usarItem(item, paquetePokemon.getGenerico());
                if (aplicado) {
                    administradorDeJuego.mostrarUsoItem(jugadorActual, item, pokemones.get((int) paquetePokemon.getGenerico()));
                    return true;
                } else {
                    administradorDeJuego.errorUsoItem(item);
                }
        }
    }
}
