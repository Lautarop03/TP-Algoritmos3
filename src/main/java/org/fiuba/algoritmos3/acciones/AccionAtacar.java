package org.fiuba.algoritmos3.acciones;

import org.fiuba.algoritmos3.model.AdministradorDeJuego;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.PaqueteDeRespuesta;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;

public class AccionAtacar implements Accion {

    @Override
    public boolean realizarAccion(Juego juego) {
        AdministradorDeJuego administradorDeJuego = juego.getAdministradorDeJuego();
        Pokemon pokemonActual = juego.getJugadorActual().getPokemonActual();
        PaqueteDeRespuesta<Habilidad> paqueteHabilidad = administradorDeJuego.pedirHabilidad(pokemonActual);
        return juego.atacar(paqueteHabilidad);
    }
}
