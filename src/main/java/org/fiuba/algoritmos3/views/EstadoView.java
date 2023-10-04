package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.estados.Estado;


public abstract class EstadoView implements MostrarEstado{
    public abstract void mostrarEstado(Pokemon pokemon, Estado estado, boolean aplicado);

}
