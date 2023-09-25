package org.fiuba.algoritmos3.items;

public class Item{
    private Integer cantidad;

    private String nombre;

    public Item(Integer cantidad){
        this.cantidad = cantidad;
    }

    public void seleccionar(){
        this.cantidad = this.cantidad - 1;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public String getNombre() {
        return nombre;
    }
}