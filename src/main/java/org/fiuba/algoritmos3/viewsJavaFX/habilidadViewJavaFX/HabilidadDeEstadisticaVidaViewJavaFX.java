package org.fiuba.algoritmos3.viewsJavaFX.habilidadViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;

public class HabilidadDeEstadisticaVidaViewJavaFX extends HabilidadViewJavaFX {

    public String mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonTarget){
        if (pokemonActual == pokemonTarget) {
            return ("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " su nueva vida es de " + pokemonTarget.getDefensa());
        } else {
            return ("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " en " + pokemonTarget.getNombre()
                    + " su nueva vida es de " + pokemonTarget.getDefensa());
        }
    }
}
