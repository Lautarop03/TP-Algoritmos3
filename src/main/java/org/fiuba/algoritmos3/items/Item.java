package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.pokemon.Pokemon;


public abstract class Item{
    protected Integer cantidadDeItems;

    protected String nombre;

    public Item(Integer cantidadDeItems){
        this.cantidadDeItems = cantidadDeItems;
    }

    /*Intenta aplicar un item al pokemon recibido
     Devuelve true si se pudo aplicar, false si no.*/
    public boolean aplicarItem(Pokemon pokemon){
        this.cantidadDeItems = this.cantidadDeItems - 1;
        return true;
    }

    public Integer getCantidad() {
        return cantidadDeItems;
    }
    public String getNombre() {
        return nombre;
    }
}