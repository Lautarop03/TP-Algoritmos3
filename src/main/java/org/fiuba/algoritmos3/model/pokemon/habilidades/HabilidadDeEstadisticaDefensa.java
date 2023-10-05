package org.fiuba.algoritmos3.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.modificadores.ModificacionDefensa;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;

public class HabilidadDeEstadisticaDefensa extends  HabilidadDeEstadistica implements ModificacionDefensa {
    public HabilidadDeEstadisticaDefensa(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer porcentajeDeModificacion) {
        super(nombre, cantidadDeUsos, tipo, porcentajeDeModificacion);
    }

    @Override
    public boolean usarHabilidad(Pokemon pokemon, Pokemon pokemonAModificar){
        super.usarHabilidad(pokemon, pokemonAModificar);
        modificarDefensa(pokemonAModificar);
        return true;
    }
    @Override
    public void modificarDefensa(Pokemon pokemon) {
        double defensaActual = pokemon.getAtaque();
        double nuevaDefensa = defensaActual + (defensaActual/100) * this.porcentajeDeModificacion;
        pokemon.setDefensa((int)nuevaDefensa);
    }
}
