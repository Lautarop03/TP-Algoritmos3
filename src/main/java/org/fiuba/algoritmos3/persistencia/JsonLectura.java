package org.fiuba.algoritmos3.persistencia;

import com.google.gson.*;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.clima.Clima;
import org.fiuba.algoritmos3.model.items.*;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.*;
import org.fiuba.algoritmos3.persistencia.Deserializers.*;

import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;


public class JsonLectura {

    private Gson gson;
    private Map<String, Class<? extends Habilidad>> mapaHabilidades;
    private Map<String, Class<? extends Item>> mapaItems;

    public JsonLectura() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(Pokemon.class,new PokemonDeserializer())
                .registerTypeAdapter(HabilidadDeDano.class,new HabilidadDeDanoDeserializer())
                .registerTypeAdapter(HabilidadDeClima.class,new HabilidadDeClimaDeserializer())
                .registerTypeAdapter(HabilidadDeEstadisticaAtaque.class,new HabilidadDeEstadisticaAtaqueDeserializer())
                .registerTypeAdapter(HabilidadDeEstadisticaDefensa.class,new HabilidadDeEstadisticaDefensaDeserializer())
                .registerTypeAdapter(HabilidadDeEstadisticaVida.class,new HabilidadDeEstadisticaVidaDeserializer())
                .registerTypeAdapter(HabilidadDeEstado.class,new HabilidadDeEstadoDeserializer())
                .registerTypeAdapter(Estado.class, new EstadoDeserializer())
                .registerTypeAdapter(Clima.class, new ClimaDeserializer())
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        this.mapaHabilidades = Map.of(
                "HabilidadDeEstado", HabilidadDeEstado.class,
                "HabilidadDeClima", HabilidadDeClima.class,
                "HabilidadDeDano", HabilidadDeDano.class,
                "HabilidadDeEstadisticaAtaque" , HabilidadDeEstadisticaAtaque.class,
                "HabilidadDeEstadisticaDefensa" , HabilidadDeEstadisticaDefensa.class,
                "HabilidadDeEstadisticaVida", HabilidadDeEstadisticaVida.class
        );
        this.mapaItems = Map.of(
                "CuraTodo", CuraTodo.class,
                "HiperPocion", Hiperpocion.class,
                "MegaPocion", MegaPocion.class,
                "Pocion", Pocion.class,
                "ItemModificadorAtaque", ItemModificadorAtaque.class,
                "ItemModificadorDefensa", ItemModificadorDefensa.class,
                "ItemRestauradorDeVida", ItemRestauradorDeVida.class,
                "ItemRestauradorDeVidaPorcentual", ItemRestauradorDeVidaPorcentual.class,
                "PocionMolestaAlumnos", PocionMolestaAlumnos.class,
                "Revivir", Revivir.class
        );
    }

    private Map<Integer, JsonObject> cargarPokemon(String rutaArchivo) {
        Map<Integer, JsonObject> pokemonMap = null;
        try {
            // Leer un archivo JSON de Pokémon
            JsonObject[] jsonPokemons = gson.fromJson(new FileReader(rutaArchivo), JsonObject[].class);

            pokemonMap = new HashMap<>(); // ID : JsonPokemon

            for (JsonObject jsonPokemon : jsonPokemons) {
                int id = jsonPokemon.get("id").getAsInt();
                pokemonMap.put(id, jsonPokemon);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pokemonMap;
    }

    private Map<Integer, JsonObject> cargarHabilidades(String rutaArchivo) {
        Map<Integer, JsonObject> habilidadesMap = null;
        try {
            JsonObject[] jsonHabilidades = gson.fromJson(new FileReader(rutaArchivo), JsonObject[].class);

            habilidadesMap = new HashMap<>(); // ID: JsonHabilidad

            for (JsonObject jsonHabilidad : jsonHabilidades) {
                int id = jsonHabilidad.get("id").getAsInt();
                habilidadesMap.put(id, jsonHabilidad);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return habilidadesMap;
    }

    private Map<Integer, JsonObject> cargarItems(String rutaArchivo) {
        Map<Integer, JsonObject> itemsMap = null;
        try {
            JsonObject[] jsonItems = gson.fromJson(new FileReader(rutaArchivo), JsonObject[].class);

            itemsMap = new HashMap<>(); // ID : JsonItem

            for (JsonObject jsonItem : jsonItems) {
                int id = jsonItem.get("id").getAsInt();
                itemsMap.put(id, jsonItem);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return itemsMap;
    }

    private Map<Integer, Integer> obtenerMapaItems(JsonObject jsonItems) {
        Map<Integer, Integer> mapaItems = new HashMap<>();

        Set<Entry<String, JsonElement>> entrySet = jsonItems.entrySet();
        for (Entry<String, JsonElement> entry : entrySet) {
            int idItem = Integer.parseInt(entry.getKey());
            int cantidad = entry.getValue().getAsInt();
            mapaItems.put(idItem, cantidad);
        }

        return mapaItems;
    }

    private List<Item> crearItems(Map<Integer, Integer> mapItems, Map<Integer, JsonObject> mapJson ) {
        List<Item> listaItems = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mapItems.entrySet() ) {
            Integer ID = entry.getKey();
            Integer cantidad = entry.getValue();
            Item item = gson.fromJson(mapJson.get(ID),obtenerClaseItem(mapJson.get(ID).get("nombre").getAsString()));
            item.setCantidadDeItems(cantidad);
            listaItems.add(item);
        }

        return listaItems;
    }

    private List<Habilidad> crearHabilidades(JsonArray arrayHabilidades ,Map<Integer, JsonObject> mapHabilidadesJson) {
        List<Habilidad> habilidades = new ArrayList<Habilidad>();
        for (JsonElement id : arrayHabilidades) {
            Integer ID = id.getAsInt();
            JsonObject jsonHabilidad = mapHabilidadesJson.get(ID);
            Habilidad habilidad = gson.fromJson(jsonHabilidad,obtenerClaseHabilidad(jsonHabilidad.get("tipoDeHabilidad").getAsString()));
            habilidades.add(habilidad);
        }
        return habilidades;
    }

    private ArrayList<Pokemon> crearPokemons(JsonArray arrayPokemon, Map<Integer, JsonObject> mapPokemonJson, Map<Integer, JsonObject> mapHabilidadesJson) {
        ArrayList<Pokemon> pokemones = new ArrayList<>();

        for(JsonElement id : arrayPokemon) {
            Integer ID = id.getAsInt();
            JsonObject jsonPokemon = mapPokemonJson.get(ID);
            JsonArray jsonHabilidades = jsonPokemon.get("habilidades").getAsJsonArray();
            List<Habilidad> habilidadesPokemon = crearHabilidades(jsonHabilidades,mapHabilidadesJson);

            Pokemon pokemon = gson.fromJson(jsonPokemon,Pokemon.class);
            pokemon.setHabilidades(habilidadesPokemon);
            pokemones.add(pokemon);
        }

        return pokemones;
    }

    private Class<? extends Habilidad> obtenerClaseHabilidad(String tipoDeHabilidad) {
        return this.mapaHabilidades.get(tipoDeHabilidad);
    }
    private Class<? extends Item> obtenerClaseItem(String tipoDeItem) {
        return this.mapaItems.get(tipoDeItem);
    }

    public ArrayList<Jugador> inicializarPartida(){ //TODO: VER DE MODIFICAR LOS PATHS
        Map<Integer, JsonObject> mapPokemonJson = cargarPokemon("src/main/java/org/fiuba/algoritmos3/persistencia/pokemons.json"); // ID : JsonObject Pokemon
        Map<Integer, JsonObject> mapHabilidadesJson = cargarHabilidades("src/main/java/org/fiuba/algoritmos3/persistencia/habilidades.json"); // ID : JsonHabilidad
        Map<Integer, JsonObject> mapItemsJson = cargarItems("src/main/java/org/fiuba/algoritmos3/persistencia/items.json"); // ID : JsonItem
        ArrayList<Jugador> jugadores = new ArrayList<>();
        try {
            JsonObject[] jsonJugadores = gson.fromJson(new FileReader("src/main/java/org/fiuba/algoritmos3/persistencia/partida.json"), JsonObject[].class);

            for (JsonObject jsonJugador : jsonJugadores) {
                String nombre = jsonJugador.get("nombre").getAsString();
                Map<Integer, Integer> mapaItems = obtenerMapaItems(jsonJugador.getAsJsonObject("items")); // diccionario de items "id":"cant"
                JsonArray arrayPokemons = jsonJugador.get("pokemons").getAsJsonArray(); // lista de pokemones

                List<Item> itemsJugador = crearItems(mapaItems,mapItemsJson);
                ArrayList<Pokemon> pokemonsJugador = crearPokemons(arrayPokemons,mapPokemonJson,mapHabilidadesJson);

                Jugador jugador = new Jugador(nombre,pokemonsJugador, itemsJugador);
                jugadores.add(jugador);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jugadores;
    }

}
