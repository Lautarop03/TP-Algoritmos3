package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.model.AdministradorDeJuego;
import org.fiuba.algoritmos3.model.Inputs;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        System.setProperty("org.jline.terminal.dumb", "true");
        Inputs input = new Inputs();
        AdministradorDeJuego admin = new AdministradorDeJuego();
        String nombre = input.pedirNombre();
        Jugador jugador1 = new Jugador(nombre, admin.asignarPokemones(),admin.asignarItems());
        String nombre2 = input.pedirNombre();
        Jugador jugador2 = new Jugador(nombre2, admin.asignarPokemones2(),admin.asignarItems());

        Juego juego = new Juego(List.of(jugador1,jugador2));
        ControladorDeJuego controladorDeJuego = new ControladorDeJuego(juego,input);

        while (!juego.terminado()) {
            controladorDeJuego.jugarTurno();
        }
        System.out.println("Juego terminado!");
    }
}
