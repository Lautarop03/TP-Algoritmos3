package org.fiuba.algoritmos3.persistencia.Deserializers.Items;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.fiuba.algoritmos3.model.items.ItemModificadorAtaque;

import java.lang.reflect.Type;

public class ItemModificadorAtaqueDeserializer implements JsonDeserializer<ItemModificadorAtaque> {
    @Override
    public ItemModificadorAtaque deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new ItemModificadorAtaque(0);
    }
}
