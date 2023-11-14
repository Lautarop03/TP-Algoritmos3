package org.fiuba.algoritmos3.persistencia.Deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.fiuba.algoritmos3.model.clima.*;
import org.fiuba.algoritmos3.model.pokemon.estados.*;

import java.lang.reflect.Type;

public class ClimaDeserializer implements JsonDeserializer<Clima> {

    @Override
    public Clima deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String clima = json.getAsString();
        return switch (clima) {
            case "Huracan" -> new Huracan();
            case "Lluvia" -> new Lluvia();
            case "Niebla" -> new Niebla();
            case "Soleado" -> new Soleado();
            case "TormentaDeArena" -> new TormentaDeArena();
            case "TormentaDeRayos" -> new TormentaDeRayos();
            default -> null;
        };
    }
}