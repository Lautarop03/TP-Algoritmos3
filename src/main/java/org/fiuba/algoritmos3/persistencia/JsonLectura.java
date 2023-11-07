package org.fiuba.algoritmos3.persistencia;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonLectura {

    private Gson gson;

    public JsonLectura(Gson gson) {
        this.gson = new Gson();
    }

    public void CargarPokemon(String rutaArchivo) { // TODO: Ver que hacer con lo que devuelvo
        try {
            // Leer un archivo JSON de Pokémon
            JsonObject[] jsonPokemons = gson.fromJson(new FileReader(rutaArchivo), JsonObject[].class);

            Map<Integer,JsonObject> pokemonMap = new HashMap<>(); // Map de ID : Datos de Pokemon

            for (JsonObject jsonPokemon : jsonPokemons) {
                int id = jsonPokemon.get("id").getAsInt();
                pokemonMap.put(id, jsonPokemon);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarHabilidades(String rutaArchivo){
        try {
            // Leer un archivo JSON de Pokémon
            JsonObject[] jsonHabilidades = gson.fromJson(new FileReader(rutaArchivo), JsonObject[].class);

            Map<Integer,JsonObject> habilidadesMap = new HashMap<>(); // Map de ID : Datos de Habilidad

            for (JsonObject jsonHabilidad : jsonHabilidades) {
                int id = jsonHabilidad.get("id").getAsInt();
                habilidadesMap.put(id, jsonHabilidad);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarItems(String rutaArchivo){
        try {
            JsonObject[] jsonItems = gson.fromJson(new FileReader(rutaArchivo), JsonObject[].class);

            Map<Integer,JsonObject> itemsMap = new HashMap<>(); // Map de ID : Datos de item

            for (JsonObject jsonItem : jsonItems) {
                int id = jsonItem.get("id").getAsInt();
                itemsMap.put(id, jsonItem);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarPartida(String rutaArchivo){ // Tengo que devolver [jugador1,jugador2] = String nombre,arraylist<Pokemon>,List<Item> (X2)
        try {
            JsonObject[] jsonJugadores = gson.fromJson(new FileReader(rutaArchivo), JsonObject[].class);

            for (JsonObject jsonJugador : jsonJugadores) {
                jsonJugador.get("nombre");
                jsonJugador.get("items"); // diccionario de items "id":"cant"
                jsonJugador.get("pokemons"); // lista de pokemones
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //TODO: cargar todo los items y habilidades, despues cargar los datos de los jugadores y crear sus respectivos items y habilidades y pokemones, y devolverlos para asignar en el main
    }

}
