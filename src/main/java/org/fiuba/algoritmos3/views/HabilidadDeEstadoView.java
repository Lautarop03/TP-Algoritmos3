package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeEstado;

public class HabilidadDeEstadoView extends HabilidadView {

    public void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonEnemigo){
        System.out.println("El pokemon " + pokemonActual.getNombre()
                + " ha utilizado " + habilidad.getNombre()
                + " en " + pokemonEnemigo.getNombre()
                + " que ahora tiene el estado " + habilidad.getNombre());
    }
}
