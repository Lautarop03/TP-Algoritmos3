package org.fiuba.algoritmos3.persistencia.Deserializers;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeDano;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeEstadisticaAtaque;

import java.lang.reflect.Type;

@JsonAdapter(HabilidadDeEstadisticaAtaque.class)
public class HabilidadDeEstadisticaAtaqueDeserializer implements JsonDeserializer<HabilidadDeEstadisticaAtaque> {
    public HabilidadDeEstadisticaAtaque deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String nombre = jsonObject.get("nombre").getAsString();
        Integer cantidadDeUsos = jsonObject.get("cantidadDeUsos").getAsInt();
        Tipo tipo = context.deserialize(jsonObject.get("tipo"), Tipo.class);
        Integer porcentajeDeModificacion = jsonObject.get("porcentajeDeModificacion").getAsInt();

        return new HabilidadDeEstadisticaAtaque(nombre,cantidadDeUsos,tipo,porcentajeDeModificacion);
    }
}
