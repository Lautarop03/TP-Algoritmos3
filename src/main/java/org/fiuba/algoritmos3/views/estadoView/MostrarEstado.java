package org.fiuba.algoritmos3.views.estadoView;

import org.fiuba.algoritmos3.model.pokemon.estados.*;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public interface MostrarEstado {
    void mostrarEstado(Pokemon pokemon, Estado estado, boolean aplicado);
}
