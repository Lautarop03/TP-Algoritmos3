package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class CuraTodo extends Item {

    public CuraTodo(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "CuraTodo";
        this.descripcion = "Este Cura Todo cura todos los estados.";
    }

    @Override
    public boolean aplicarItem(Pokemon pokemon){
        if(pokemon.getEstados().isEmpty()){
            return true;
        }
        if (super.aplicarItem(pokemon)) {
            return true;
        }
        pokemon.quitarEstados();
        return false;
    }
}