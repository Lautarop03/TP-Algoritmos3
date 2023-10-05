package org.fiuba.algoritmos3.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.modificadores.ModificacionAtaque;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;

public class HabilidadDeEstadisticaAtaque extends HabilidadDeEstadistica implements ModificacionAtaque {
    public HabilidadDeEstadisticaAtaque(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer porcentajeDeModificacion) {
        super(nombre, cantidadDeUsos, tipo, porcentajeDeModificacion);
    }

    @Override
    public boolean usarHabilidad(Pokemon pokemon, Pokemon pokemonAModificar){
        super.usarHabilidad(pokemonAModificar, pokemon);
        modificarAtaque(pokemonAModificar);
        return true;
    }

    public void modificarAtaque(Pokemon pokemon) {
        double ataqueActual = pokemon.getAtaque();
        double nuevoAtaque = ataqueActual + (ataqueActual/100) * this.porcentajeDeModificacion;
        pokemon.setAtaque((int)nuevoAtaque);
    }
}
