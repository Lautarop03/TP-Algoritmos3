package org.fiuba.algoritmos3.persistencia.Deserializers.Items;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.fiuba.algoritmos3.model.items.MegaPocion;

import java.lang.reflect.Type;

public class MegaPocionDeserializer implements JsonDeserializer<MegaPocion> {
    @Override
    public MegaPocion deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new MegaPocion(0);
    }
}
