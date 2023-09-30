package org.fiuba.algoritmos3.pokemon.habilidades;

import org.fiuba.algoritmos3.ModificacionVida;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.Tipo;

public class HabilidadDeEstadisticaVida extends HabilidadDeEstadistica {
    public HabilidadDeEstadisticaVida(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer porcentajeDeModificacion) {
        super(nombre, cantidadDeUsos, tipo, porcentajeDeModificacion);
    }

    @Override
    public boolean usarHabilidad(Pokemon pokemon, Pokemon pokemonAModificar){
        super.usarHabilidad(pokemonAModificar, pokemon);
        actualizarVida(pokemonAModificar);
        return true;

    }
    public void actualizarVida(Pokemon pokemon){
        double vidaActual = pokemon.getVidaActual();
        double nuevaVida = (vidaActual/100) * this.porcentajeDeModificacion;
        pokemon.sumarVida((int)nuevaVida);
    }
}
