package org.fiuba.algoritmos3.viewsJavaFX.habilidadViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeClima;

public class HabilidadDeClimaViewJavaFX extends HabilidadViewJavaFX{
    public String mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonEnemigo){
        return ("El pokemon " + pokemonActual.getNombre()
                + " ha utilizado " + habilidad.getNombre()
                + " y el clima actual es: " + habilidad.getNombre());
    }
}
