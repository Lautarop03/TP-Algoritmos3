package org.fiuba.algoritmos3.viewsJavaFX.estadoViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;


public class EstadoEnvenenadoViewJavaFX extends EstadoViewJavaFX{

    public String mostrarEstado(Pokemon pokemon, Estado estado, boolean aplicado){
        return ("El pokemon " + pokemon.getNombre()
                + " ha sufrido daño por envenenamiento!" +
                " Su nueva vida es " + pokemon.getVidaActual());
    }
}
