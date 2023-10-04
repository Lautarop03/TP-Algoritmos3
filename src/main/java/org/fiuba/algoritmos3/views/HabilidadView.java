package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.*;

public abstract class HabilidadView {

    public void mostrarHabilidad(Habilidad habilidad) {
        System.out.println("Habilidad:" + habilidad.getNombre() + " Usos:" + habilidad.getCantidadDeUsos());
    }

    public abstract void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonTarget);
}
