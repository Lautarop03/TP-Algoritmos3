package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;


public abstract class Item{
    protected Integer cantidadDeItems;

    protected String nombre;

    public Item(Integer cantidadDeItems){
        this.cantidadDeItems = cantidadDeItems;
    }

    public boolean aplicarItem(Pokemon pokemon){
        if(this.cantidadDeItems == 0) {
            return true;
        }
        this.cantidadDeItems = this.cantidadDeItems - 1;
        return false;
    }

    public Integer getCantidad() {
        return cantidadDeItems;
    }
    public String getNombre() {
        return nombre;
    }
}