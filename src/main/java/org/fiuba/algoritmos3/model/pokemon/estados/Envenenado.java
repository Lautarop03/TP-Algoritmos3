package org.fiuba.algoritmos3.model.pokemon.estados;

import org.fiuba.algoritmos3.model.modificadores.ModificacionVida;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class Envenenado extends Estado implements ModificacionVida {

    public Envenenado() {
        this.nombre = "Envenenado";
    }

    @Override
    public boolean aplicarEfecto(Pokemon pokemon) {
        Integer modificadorDeVida = (int) (pokemon.getVidaMaxima() * 0.05);
        this.modificarVida(pokemon, modificadorDeVida);
        return pokemon.estaMuerto();
    }

    public void modificarVida(Pokemon pokemon, Integer modificadorDeVida) {
        pokemon.bajarVida(modificadorDeVida);
    }

    public Estado clonarEstado(Estado estado) {
        return new Envenenado();
    }
}
