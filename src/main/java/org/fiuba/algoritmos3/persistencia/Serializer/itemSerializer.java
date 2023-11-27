package org.fiuba.algoritmos3.persistencia.Serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.fiuba.algoritmos3.model.items.Item;

import java.lang.reflect.Type;

public class itemSerializer implements JsonSerializer<Item> {

    @Override
    public JsonElement serialize(Item item, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        String id = String.valueOf(item.getID());
        jsonObject.addProperty(id,item.getCantidad());
        return jsonObject;
    }
}
