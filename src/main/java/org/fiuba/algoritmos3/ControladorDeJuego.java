package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.acciones.*;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.acciones.*;

import java.util.List;

public class ControladorDeJuego {
    private final Juego juego;
    private final Inputs inputs;
    private Accion accion;
    private final List<Accion> acciones;


    public ControladorDeJuego(Juego juego, Inputs inputs) {
        this.juego = juego;
        this.inputs = inputs;
        this.acciones = List.of(new AccionRendirse(),new AccionVerCampo(),new AccionCambiarPokemon(), new AccionUsarItem(), new AccionAtacar());
    }
    private void setAccion(int numeroAccion) {
        this.accion = this.acciones.get(numeroAccion-1);
    }

    public void jugarTurno() {
        System.out.println("Turno de: " + juego.getJugadorActual().getNombre());
        boolean repetir = true;
        juego.aplicarClima();
        do {
            juego.comprobarPokemonActualEstaVivo();
            int accion = inputs.pedirAccion();
            this.setAccion(accion);
            repetir = this.accion.realizarAccion(juego);
        } while (!repetir);
        if (!juego.aplicarEstados().contains(true)){
            juego.realizarAtaque();
        }
        juego.comprobarPokemonActualEstaVivo();
        juego.cambiarTurno();
    }
}
