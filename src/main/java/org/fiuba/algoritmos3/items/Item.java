package org.fiuba.algoritmos3.items;

public abstract class Item{
    protected Integer cantidadDeItems;

    protected String nombre;

    public Item(Integer cantidadDeItems){
        this.cantidadDeItems = cantidadDeItems;
    }

    public void seleccionar(){
        this.cantidadDeItems = this.cantidadDeItems - 1;
    }

    public Integer getCantidad() {
        return cantidadDeItems;
    }
    public String getNombre() {
        return nombre;
    }
}