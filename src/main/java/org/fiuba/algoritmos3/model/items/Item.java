package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;


public abstract class Item{
    protected Integer cantidadDeItems;

    protected String nombre;
    private int ID;

    public Item(Integer cantidadDeItems){
        if (cantidadDeItems > 0) {
            this.cantidadDeItems = cantidadDeItems;
        }
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

    public void setCantidadDeItems(Integer cantidadDeItems) {
        this.cantidadDeItems = cantidadDeItems;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}