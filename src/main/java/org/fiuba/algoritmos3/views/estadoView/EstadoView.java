package org.fiuba.algoritmos3.views.estadoView;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;


public abstract class EstadoView implements MostrarEstado {
    public abstract void mostrarEstado(Pokemon pokemon, Estado estado, boolean aplicado);

}
