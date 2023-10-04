package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.estados.Estado;

public class EstadoDormidoView extends EstadoView{

    public void mostrarEstado(Pokemon pokemon, Estado estado, boolean aplicado){
        if (aplicado){
            System.out.println("El pokemon " + pokemon.getNombre() + " no ataco, esta " + estado.getNombre());
        } else {
            System.out.println("El pokemon " + pokemon.getNombre() + " se ha despertado!");
        }
    }
}
