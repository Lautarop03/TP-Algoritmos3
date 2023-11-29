package org.fiuba.algoritmos3.persistencia.Deserializers.Items;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.fiuba.algoritmos3.model.items.Hiperpocion;

import java.lang.reflect.Type;

public class HiperPocionDeserializer implements JsonDeserializer<Hiperpocion> {
    @Override
    public Hiperpocion deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new Hiperpocion(0);
    }
}
