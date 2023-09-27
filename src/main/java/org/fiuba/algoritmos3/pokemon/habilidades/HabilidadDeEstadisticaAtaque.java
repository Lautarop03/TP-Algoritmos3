package org.fiuba.algoritmos3.pokemon.habilidades;

import org.fiuba.algoritmos3.ModificacionAtaque;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.Tipo;

public class HabilidadDeEstadisticaAtaque extends HabilidadDeEstadistica implements ModificacionAtaque {
    public HabilidadDeEstadisticaAtaque(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer porcentajeDeModificacion) {
        super(nombre, cantidadDeUsos, tipo, porcentajeDeModificacion);
    }

    public void modificarAtaque(Pokemon pokemon) {
        double ataqueActual = pokemon.getAtaque();
        double nuevoAtaque = ataqueActual + (ataqueActual/100) * this.porcentajeDeModificacion;
        pokemon.setAtaque((int)nuevoAtaque);
    }
}
