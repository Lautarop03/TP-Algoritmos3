package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeDano;

public class HabilidadDeDanoView extends HabilidadView{
    public void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonEnemigo){
        System.out.println("El pokemon " + pokemonActual.getNombre()
                + " ha utilizado " + habilidad.getNombre()
                + " en " + pokemonEnemigo.getNombre()
                + " cuya vida actual es de: " + pokemonEnemigo.getVidaActual());
    }
}
