package org.fiuba.algoritmos3.persistencia.Deserializers.Items;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.fiuba.algoritmos3.model.items.PocionMolestaAlumnos;

import java.lang.reflect.Type;

public class MolestaAlumnosDeserializer implements JsonDeserializer<PocionMolestaAlumnos> {
    @Override
    public PocionMolestaAlumnos deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new PocionMolestaAlumnos(0);
    }
}
