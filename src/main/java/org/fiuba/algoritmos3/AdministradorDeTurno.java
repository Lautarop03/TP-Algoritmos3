package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.pokemon.Pokemon;

import java.util.List;

public class AdministradorDeTurno {
    private List<Jugador> jugadores;
    private int indiceJugadorActual;
    public int definirTurno() {
        int velocidadMax = 0;
        int indiceJugador = -1;
        for (int i = 0; i < jugadores.size();i++) {
            List<Pokemon> pokemones = jugadores.get(i).getPokemones();
            for (Pokemon pokemon : pokemones) {
                if (pokemon.getVelocidad() > velocidadMax) {
                    velocidadMax = pokemon.getVelocidad();
                    indiceJugador = i;
                }
            }
        }
        return indiceJugador;
    }
    public AdministradorDeTurno(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.indiceJugadorActual = definirTurno();
    }
    public void pasarTurno() {
        indiceJugadorActual = (indiceJugadorActual + 1) % jugadores.size();
    }
    public Jugador getJugadorActual() {
        return jugadores.get(indiceJugadorActual);
    }
}
