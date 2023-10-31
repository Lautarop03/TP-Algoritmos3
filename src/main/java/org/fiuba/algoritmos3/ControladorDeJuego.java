package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.model.Juego;

public class ControladorDeJuego {
    final int rendirse = 1;
    final int verCampoDeBatalla = 2;
    final int intercambiarPokemon = 3;
    final int item = 4;
    final int ataque = 5;
    private final Juego juego;
    private final Inputs inputs;


    public ControladorDeJuego(Juego juego, Inputs inputs) {
        this.juego = juego;
        this.inputs = inputs;
    }

    public void jugarTurno() {
        System.out.println("Turno de: " + juego.getJugadorActual().getNombre());
        boolean repetir = true;
        boolean intercambioPokemon = true;

        do {
            juego.comprobarPokemonActualEstaVivo();
            int accion = inputs.pedirAccion();
            switch (accion) {
                //TODO mover lógica de inputs (viewControlador) acá
                case rendirse -> repetir = juego.rendirse();
                case verCampoDeBatalla -> repetir = juego.verCampo();
                case intercambiarPokemon -> {
                    repetir = juego.cambiarPokemon();
                    intercambioPokemon = false;
                }
                case item -> repetir = juego.usarItem();
                case ataque -> repetir = juego.atacar();
            }
        } while (!repetir);
        if (intercambioPokemon && !juego.aplicarEstados()){
            juego.realizarAtaque();
        }
        juego.comprobarPokemonActualEstaVivo();
        juego.cambiarTurno();
    }
}
