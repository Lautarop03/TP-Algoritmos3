package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.persistencia.JsonLectura;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        System.setProperty("org.jline.terminal.dumb", "true");
        Inputs input = new Inputs();

        JsonLectura jsonLectura = new JsonLectura();
        List<Jugador> jugadores = jsonLectura.inicializarPartida();
        Juego juego = new Juego(jugadores);
        ControladorDeJuego controladorDeJuego = new ControladorDeJuego(juego,input);

        while (!juego.terminado()) {
            controladorDeJuego.jugarTurno();
        }
        System.out.println("Juego terminado!");
    }
}
