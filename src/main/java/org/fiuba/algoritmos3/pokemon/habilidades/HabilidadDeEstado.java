package org.fiuba.algoritmos3.pokemon.habilidades;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.Tipo;
import org.fiuba.algoritmos3.pokemon.estados.Estado;




public class HabilidadDeEstado extends Habilidad {

    private Estado estado;

    public HabilidadDeEstado(String nombre, Integer cantidadDeUsos, Tipo tipo, Estado estado) {
        super(nombre, cantidadDeUsos, tipo);
        this.estado = estado;
    }
    @Override
    public boolean usarHabilidad(Pokemon pokemon, Pokemon pokemonAModificar){
        super.usarHabilidad(pokemon, pokemonAModificar);
        if (!pokemon.setEstado(this.crearNuevoEstado())){
            return false;
        }
        return true;

    }

    private Estado crearNuevoEstado() {
        return this.estado.clonarEstado(this.estado);
    }
}
