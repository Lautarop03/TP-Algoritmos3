package org.fiuba.algoritmos3.pokemon.habilidades;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.estados.Estado;
import org.fiuba.algoritmos3.pokemon.Tipo;

public class HabilidadDeEstado extends Habilidad {
    public HabilidadDeEstado(String nombre, Integer cantidadDeUsos, Tipo tipo) {
        super(nombre, cantidadDeUsos, tipo);
    }

    public void aplicarEstado(Pokemon pokemon, Estado estado) {
        pokemon.setEstado(estado);
    }
}
