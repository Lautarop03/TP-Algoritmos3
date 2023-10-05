package org.fiuba.algoritmos3.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;

public  abstract class HabilidadDeEstadistica extends Habilidad{
    protected Integer porcentajeDeModificacion;

    public HabilidadDeEstadistica(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer porcentajeDeModificacion) {
        super(nombre, cantidadDeUsos, tipo);
        this.porcentajeDeModificacion = porcentajeDeModificacion;
    }
    @Override
    public boolean usarHabilidad(Pokemon pokemon, Pokemon pokemonAModificar){
        super.usarHabilidad(pokemon, pokemonAModificar);
        return true;

    }
}
