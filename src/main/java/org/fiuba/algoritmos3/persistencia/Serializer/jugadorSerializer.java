package org.fiuba.algoritmos3.persistencia.Serializer;

import com.google.gson.*;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class jugadorSerializer implements JsonSerializer<Jugador> {

    @Override
    public JsonElement serialize(Jugador jugador, Type type, JsonSerializationContext jsonSerializationContext) {
        Gson builder = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Item.class,new itemSerializer())
                .create();
        JsonObject json = new JsonObject();

        json.addProperty("nombre",jugador.getNombre());
        json.addProperty("ganador",jugador.getGanador());

        Map<Integer, Integer> itemsMap = new HashMap<>();
        for (Item item : jugador.getItems()) {
            itemsMap.put(item.getID(), item.getCantidad());
        }

        json.add("items", builder.toJsonTree(itemsMap));

        JsonArray pokemonsArray = new JsonArray();
        for (Pokemon pokemon: jugador.getPokemones()) {
            JsonObject pokemonJson = new JsonObject();
            pokemonJson.addProperty("id",pokemon.getID());
            pokemonJson.addProperty("vidaRestante",pokemon.getVidaActual());

            if (pokemon.getEstados() != null && !pokemon.getEstados().isEmpty()) {
                JsonArray estadosArray = new JsonArray();
                for (Estado estado : pokemon.getEstados()) {
                    estadosArray.add(estado.getNombre());
                }
                pokemonJson.add("estados",estadosArray);
            }
            pokemonsArray.add(pokemonJson);
        }
        json.add("pokemons",pokemonsArray);
        return json;
    }
}
