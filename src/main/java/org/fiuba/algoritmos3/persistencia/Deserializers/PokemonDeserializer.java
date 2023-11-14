package org.fiuba.algoritmos3.persistencia.Deserializers;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.lang.reflect.Type;
@JsonAdapter(Pokemon.class)
public class PokemonDeserializer implements JsonDeserializer<Pokemon> {

    public Pokemon deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String nombre = jsonObject.get("nombre").getAsString();
        Integer nivel = jsonObject.get("nivel").getAsInt();
        Tipo tipo = context.deserialize(jsonObject.get("tipo"), Tipo.class);
        String historia = jsonObject.get("historia").getAsString();
        Integer vidaMaxima = jsonObject.get("vidaMaxima").getAsInt();
        Integer vidaActual = jsonObject.get("vidaMaxima").getAsInt();
        Integer velocidad = jsonObject.get("velocidad").getAsInt();
        Double defensa = jsonObject.get("defensa").getAsDouble();
        Double ataque = jsonObject.get("ataque").getAsDouble();

        return new Pokemon(nombre, nivel, tipo, historia, vidaMaxima, vidaActual, velocidad, defensa, ataque, null);
    }
}
