package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class CuraTodo extends Item {

    public CuraTodo(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Curatodo";
    }

    @Override
    public boolean aplicarItem(Pokemon pokemon){
        if(pokemon.getEstado() == null){
            return false;
            //Todo: lanzar excepcion si el pokemon no tiene estado
        }
        pokemon.quitarEstado();
        super.aplicarItem(pokemon);
        return true;
    }
}