package org.fiuba.algoritmos3.model.pokemon.estados;

import org.fiuba.algoritmos3.model.modificadores.ModificacionVida;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class Envenenado extends Estado implements ModificacionVida {
    private Integer porcentajeDeVidaABajar = 5;

    public Envenenado() {
        this.nombre = "Envenenado";
    }

    @Override
    public boolean aplicarEfecto(Pokemon pokemon) {
        Integer modificadorDeVida = pokemon.getVidaActual()- pokemon.getVidaActual()/100 * this.porcentajeDeVidaABajar;
        this.modificarVida(pokemon, modificadorDeVida);
        return false;
    }

    public void modificarVida(Pokemon pokemon, Integer modificadorDeVida) {
        pokemon.setVidaActual(modificadorDeVida);
    }

    public Estado clonarEstado(Estado estado) {
        return new Envenenado();
    }
}
