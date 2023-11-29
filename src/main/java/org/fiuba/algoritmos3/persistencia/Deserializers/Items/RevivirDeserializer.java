package org.fiuba.algoritmos3.persistencia.Deserializers.Items;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.fiuba.algoritmos3.model.items.Pocion;
import org.fiuba.algoritmos3.model.items.Revivir;

import java.lang.reflect.Type;

public class RevivirDeserializer implements JsonDeserializer<Revivir> {
    @Override
    public Revivir deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new Revivir(0);
    }
}