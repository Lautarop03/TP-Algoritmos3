package org.fiuba.algoritmos3.viewsJavaFX.habilidadViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;

public class HabilidadDeEstadisticaAtaqueViewJavaFX extends HabilidadViewJavaFX {

    public String mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonTarget){
        if (pokemonActual == pokemonTarget) {
            return ("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " su nuevo ataque es de " + pokemonTarget.getAtaque());
        } else {
            return ("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " en " + pokemonTarget.getNombre()
                    + " su nuevo ataque es de " + pokemonTarget.getAtaque());
        }
    }
}
