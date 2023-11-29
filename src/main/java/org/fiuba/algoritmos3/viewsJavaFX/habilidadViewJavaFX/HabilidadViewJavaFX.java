package org.fiuba.algoritmos3.viewsJavaFX.habilidadViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.*;

public abstract class HabilidadViewJavaFX {

    public void mostrarHabilidad(Habilidad habilidad) {
        System.out.println("Habilidad:" + habilidad.getNombre() + " Usos:" + habilidad.getCantidadDeUsos());
    }

    public abstract void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonTarget);
}
