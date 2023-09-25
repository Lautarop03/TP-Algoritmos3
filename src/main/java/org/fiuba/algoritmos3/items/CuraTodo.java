package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.pokemon.Pokemon;

public class CuraTodo extends Item {

    public CuraTodo(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Curatodo";
    }

    public void quitarEstadoActual(Pokemon pokemon){
        if(pokemon.getEstado() != null){
            pokemon.setEstado(null);
        }
    }
}