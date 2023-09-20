package org.fiuba.algoritmos3;

public class Item{
    private Integer cantidad;

    public Item(Integer cantidad){
        this.cantidad = cantidad;
    }

    public void seleccionar(){
        this.cantidad = this.cantidad - 1;
    }

}