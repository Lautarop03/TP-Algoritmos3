package org.fiuba.algoritmos3.viewsJavaFX.estadoViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;

public class EstadoDormidoViewJavaFX extends EstadoViewJavaFX{

    public String mostrarEstado(Pokemon pokemon, Estado estado, boolean aplicado){
        if (aplicado){
            return ("El pokemon " + pokemon.getNombre() + " no ataco, esta " + estado.getNombre());
        } else {
            return ("El pokemon " + pokemon.getNombre() + " se ha despertado!");
        }
    }
}
