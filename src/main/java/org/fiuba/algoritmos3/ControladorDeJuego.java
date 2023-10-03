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
            if (!juego.comprobarPokemonActualEstaVivo()){
                juego.cambiarPokemon();//ACA HICE CAMBIOSS MATEX
            }
            int accion = inputs.pedirAccion();
            switch (accion) {
                case rendirse -> repetir = juego.rendirse();
                case verCampoDeBatalla -> repetir = juego.verCampo();
                case intercambiarPokemon -> repetir = juego.cambiarPokemon();
                case item -> repetir = juego.usarItem();
                case ataque -> repetir = juego.atacar();
            }
        } while (!repetir);

        if (!juego.aplicarEstado()){//ACA HICE CAMBIOSS MATEX
            juego.realizarAtaque();
        }
        juego.cambiarTurno();
    }
}
