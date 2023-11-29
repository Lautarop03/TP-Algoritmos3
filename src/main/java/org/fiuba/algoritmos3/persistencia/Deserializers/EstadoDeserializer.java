package org.fiuba.algoritmos3.persistencia.Deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.fiuba.algoritmos3.model.pokemon.estados.*;

import java.lang.reflect.Type;

public class EstadoDeserializer implements JsonDeserializer<Estado> {

    @Override
    public Estado deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String estado = json.getAsString();
        return switch (estado) {
            case "Confuso" -> new Confuso();
            case "Dormido" -> new Dormido();
            case "Envenenado" -> new Envenenado();
            case "Paralizado" -> new Paralizado();
            default -> null;
        };
    }
}
