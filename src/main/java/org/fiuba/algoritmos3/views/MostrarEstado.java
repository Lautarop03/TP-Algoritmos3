package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.estados.*;
import org.fiuba.algoritmos3.pokemon.Pokemon;

public interface MostrarEstado {
    void mostrarEstado(Pokemon pokemon, Estado estado, boolean aplicado);
}
