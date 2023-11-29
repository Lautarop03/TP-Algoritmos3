package org.fiuba.algoritmos3.persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.persistencia.Serializer.jugadorSerializer;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class JsonEscritura {

    public JsonEscritura() {
    }

    public void escribirInforme(Juego juego) {
        List<Jugador> jugadores = juego.getJugadores();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Jugador.class,new jugadorSerializer())
                .create();
        String json = gson.toJson(jugadores);

//        String nombreArchivo = getNombreArchivo();

        try (FileWriter writer = new FileWriter("informe.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getNombreArchivo() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int hora = localDateTime.getHour();
        int minutos = localDateTime.getMinute();
        int segundos = localDateTime.getSecond();
        return  "informe" + hora +":"+ minutos +":"+ segundos + ".json";
    }
}

