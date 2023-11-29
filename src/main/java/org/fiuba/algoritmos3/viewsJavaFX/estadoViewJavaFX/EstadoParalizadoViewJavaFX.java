package org.fiuba.algoritmos3.viewsJavaFX.estadoViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;

public class EstadoParalizadoViewJavaFX extends EstadoViewJavaFX{

    public void mostrarEstado(Pokemon pokemon, Estado estado, boolean aplicado){
        if (aplicado){
            System.out.println("El pokemon " + pokemon.getNombre()
                    + " fue paralizado y no puede atacar este turno!!");
        } else {
            System.out.println("El pokemon " + pokemon.getNombre()
                    + " esta paralizado pero este turno ha logrado atacar!");
        }
    }

}
