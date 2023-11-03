package org.fiuba.algoritmos3.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;

public class HabilidadDeEstado extends Habilidad {

    private final Estado estado;

    public HabilidadDeEstado(String nombre, Integer cantidadDeUsos, Tipo tipo, Estado estado) {
        super(nombre, cantidadDeUsos, tipo);
        this.estado = estado;
    }
    @Override
    public boolean usarHabilidad(Pokemon pokemon, Pokemon pokemonAModificar){
        super.usarHabilidad(pokemon, pokemonAModificar);
        return !pokemonAModificar.setEstado(this.crearNuevoEstado());
    }

    private Estado crearNuevoEstado() {
        return this.estado.clonarEstado(this.estado);
    }
}
