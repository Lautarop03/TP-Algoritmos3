package org.fiuba.algoritmos3.acciones;

import org.fiuba.algoritmos3.model.AdministradorDeJuego;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.PaqueteDeRespuesta;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.util.ArrayList;


public class AccionCambiarPokemon implements Accion{
    public boolean realizarAccion(Juego juego) {
        AdministradorDeJuego administradorDeJuego = juego.getAdministradorDeJuego();
        Jugador jugadorActual = juego.getJugadorActual();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        while (true) {
            PaqueteDeRespuesta<Integer> paquetePokemon = administradorDeJuego.pedirPokemon(pokemones);
            if (!paquetePokemon.getError()) {
                return false;
            }
            if (jugadorActual.getPokemonActual() == pokemones.get(paquetePokemon.getGenerico())){
                administradorDeJuego.errorPokemonActual();
                continue;
            }
            boolean realizado = juego.cambiarPokemon(paquetePokemon.getGenerico());
            if (realizado) {
                administradorDeJuego.mostrarCambioPokemon(jugadorActual.getPokemonActual());
                return true;
            } else {
                administradorDeJuego.errorIntercambiarPokemonSinVida();
            }
        }

    }

}
