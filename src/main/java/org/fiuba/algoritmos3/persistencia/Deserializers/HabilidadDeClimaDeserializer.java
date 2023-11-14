package org.fiuba.algoritmos3.persistencia.Deserializers;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import org.fiuba.algoritmos3.model.clima.Clima;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeClima;

import java.lang.reflect.Type;

@JsonAdapter(HabilidadDeClima.class)
public class HabilidadDeClimaDeserializer implements JsonDeserializer<HabilidadDeClima> {

    public HabilidadDeClima deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String nombre = jsonObject.get("nombre").getAsString();
        Integer cantidadDeUsos = jsonObject.get("cantidadDeUsos").getAsInt();
        Tipo tipo = context.deserialize(jsonObject.get("tipo"), Tipo.class);
        Clima clima = context.deserialize(jsonObject.get("clima"), Clima.class);

        return new HabilidadDeClima(nombre,cantidadDeUsos,tipo,clima);
    }
}