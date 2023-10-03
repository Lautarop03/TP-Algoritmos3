package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        Inputs input = new Inputs();
        AdministradorDeJuego admin = new AdministradorDeJuego();
        String nombre = input.pedirNombre();
        Jugador jugador1 = new Jugador(nombre, admin.asignarPokemones(),admin.asignarItems());
        String nombre2 = input.pedirNombre();
        Jugador jugador2 = new Jugador(nombre2, admin.asignarPokemones(),admin.asignarItems());

        Juego juego = new Juego(List.of(jugador1,jugador2));
        ControladorDeJuego controladorDeJuego = new ControladorDeJuego(juego,input);

        while (!juego.terminado()) {
            controladorDeJuego.jugarTurno();
        }
        System.out.println("Juego terminado!");
    }
}
