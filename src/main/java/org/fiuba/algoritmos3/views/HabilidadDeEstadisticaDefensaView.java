package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeEstadisticaDefensa;

public class HabilidadDeEstadisticaDefensaView extends HabilidadView {

    public void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonTarget){
        if (pokemonActual == pokemonTarget) {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " su nueva defensa es de" + pokemonTarget.getDefensa());
        } else {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " en " + pokemonTarget.getNombre()
                    + " su nueva defensa es de" + pokemonTarget.getDefensa());
        }
    }
}
