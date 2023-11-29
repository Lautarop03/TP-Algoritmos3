package org.fiuba.algoritmos3.persistencia.Deserializers.Items;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.fiuba.algoritmos3.model.items.CuraTodo;
import org.fiuba.algoritmos3.model.items.Pocion;

import java.lang.reflect.Type;

public class CuraTodoDeserializer implements JsonDeserializer<CuraTodo> {
    @Override
    public CuraTodo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new CuraTodo(0);
    }
}