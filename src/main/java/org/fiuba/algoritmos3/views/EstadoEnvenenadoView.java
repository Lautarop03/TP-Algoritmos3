package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.estados.Estado;


public class EstadoEnvenenadoView extends EstadoView{

    public void mostrarEstado(Pokemon pokemon, Estado estado, boolean aplicado){
        System.out.println("El pokemon " + pokemon.getNombre()
                + " ha sufrido daño por envenenamiento!" +
                " Su nueva vida es " + pokemon.getVidaActual());
    }
}
