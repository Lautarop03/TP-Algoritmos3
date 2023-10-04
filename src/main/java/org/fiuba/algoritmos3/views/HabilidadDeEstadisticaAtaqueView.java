package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeEstadisticaAtaque;

public class HabilidadDeEstadisticaAtaqueView extends HabilidadView {

    public void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonTarget){
        if (pokemonActual == pokemonTarget) {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " su nuevo ataque es de" + pokemonTarget.getAtaque());
        } else {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " en " + pokemonTarget.getNombre()
                    + " su nuevo ataque es de " + pokemonTarget.getAtaque());
        }
    }
}
