package org.fiuba.algoritmos3;
import java.util.list;

public class Juego {
    private List<Jugador> jugadores;
    //private Integer turno;

    public Juego(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void iniciarJuego() {
    }

    public void comprobarVictoria() {
        Jugador ganador;
        int j = 0;
        while (j < jugadores.length()) {
            if (jugadores[j].derrotado()) {
                ganador = jugadores[ (j + 1) % jugadores.length() ]
            }
        }
    }

    public void comprobarJugadores(){

    }

    public void mostrarJuego(){

    }

}
