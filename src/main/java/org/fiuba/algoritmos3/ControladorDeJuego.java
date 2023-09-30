package org.fiuba.algoritmos3;

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
        do {
            int accion = inputs.pedirAccion();
            switch (accion) {
                case rendirse -> repetir = juego.rendirse();
                case verCampoDeBatalla -> repetir = juego.verCampo();
                case intercambiarPokemon -> repetir = juego.cambiarPokemon();// Luego de cambiar el Pokemon del campo de batalla se termina el turno
                case item -> repetir = juego.usarItem();
                case ataque -> repetir = juego.atacar();
                // TODO: terminar todos los cases y sus respectivas funciones (5 acciones) y ver como manejar los casos (no siempre cambia el turno y termina la accion)
            }
        } while (!repetir);
        juego.aplicarEstados(); // TODO: Cuando termina el turno o arranca aplicar los Estados del pokemon
        juego.cambiarTurno();
    }
}
