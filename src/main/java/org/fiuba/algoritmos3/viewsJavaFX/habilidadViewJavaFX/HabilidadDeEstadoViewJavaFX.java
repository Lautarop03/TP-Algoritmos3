package org.fiuba.algoritmos3.viewsJavaFX.habilidadViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;

public class HabilidadDeEstadoViewJavaFX extends HabilidadViewJavaFX {

    public String mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonEnemigo){
        return ("El pokemon " + pokemonActual.getNombre()
                + " ha utilizado " + habilidad.getNombre()
                + " en " + pokemonEnemigo.getNombre()
                + " que ahora tiene el estado " + habilidad.getNombre());
    }
}
