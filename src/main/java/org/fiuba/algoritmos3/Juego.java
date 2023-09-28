package org.fiuba.algoritmos3;
import java.util.List;

public class Juego {
    private AdministradorDeTurno administradorDeTurno;
    private List<Jugador> jugadores;
    //private Integer turno;

    public Juego(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.administradorDeTurno = new AdministradorDeTurno(jugadores);
    }

    public boolean terminado() {
        return false;
    }

    public void aplicarEfecto() {
    }
    public void cambiarTurno() {
        administradorDeTurno.pasarTurno();
    }
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public Jugador getJugadorActual() {
        return administradorDeTurno.getJugadorActual();
    }
}
