package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.*;

public interface MostrarAccion {
    void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonEnemigo);

}