package org.fiuba.algoritmos3.viewsJavaFX.habilidadViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;

public class HabilidadDeEstadisticaAtaqueViewJavaFX extends HabilidadViewJavaFX {

    public void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonTarget){
        if (pokemonActual == pokemonTarget) {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " su nuevo ataque es de " + pokemonTarget.getAtaque());
        } else {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " en " + pokemonTarget.getNombre()
                    + " su nuevo ataque es de " + pokemonTarget.getAtaque());
        }
    }
}
