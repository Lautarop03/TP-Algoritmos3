package org.fiuba.algoritmos3.persistencia.Deserializers.Habilidades;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeEstado;

import java.lang.reflect.Type;

@JsonAdapter(HabilidadDeEstado.class)
public class HabilidadDeEstadoDeserializer implements JsonDeserializer<HabilidadDeEstado> {
    public HabilidadDeEstado deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String nombre = jsonObject.get("nombre").getAsString();
        Integer cantidadDeUsos = jsonObject.get("cantidadDeUsos").getAsInt();
        Tipo tipo = context.deserialize(jsonObject.get("tipo"), Tipo.class);
        Estado estado = context.deserialize(jsonObject.get("estado"), Estado.class);

        return new HabilidadDeEstado(nombre,cantidadDeUsos,tipo,estado);
    }
}
