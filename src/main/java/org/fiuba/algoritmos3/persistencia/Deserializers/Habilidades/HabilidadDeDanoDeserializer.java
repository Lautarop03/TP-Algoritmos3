package org.fiuba.algoritmos3.persistencia.Deserializers.Habilidades;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeDano;

import java.lang.reflect.Type;

@JsonAdapter(HabilidadDeDano.class)
public class HabilidadDeDanoDeserializer implements JsonDeserializer<HabilidadDeDano> {

    public HabilidadDeDano deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String nombre = jsonObject.get("nombre").getAsString();
        Integer cantidadDeUsos = jsonObject.get("cantidadDeUsos").getAsInt();
        Tipo tipo = context.deserialize(jsonObject.get("tipo"), Tipo.class);
        Integer potencia = jsonObject.get("potencia").getAsInt();

        return new HabilidadDeDano(nombre,cantidadDeUsos,tipo,potencia);
    }
}
