package org.fiuba.algoritmos3.model;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.util.List;

public class AdministradorDeTurno {
    private final List<Jugador> jugadores;
    private int indiceJugadorActual;
    public int definirTurno() {
        int velocidadMax = 0;
        int indiceJugador = -1;
        for (int i = 0; i < jugadores.size();i++) {
            Pokemon pokemon = jugadores.get(i).getPokemonActual();
            if (pokemon.getVelocidad() > velocidadMax) {
                velocidadMax = pokemon.getVelocidad();
                indiceJugador = i;
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
    public Jugador getOponente() {return jugadores.get((indiceJugadorActual+1) % jugadores.size());}

}
