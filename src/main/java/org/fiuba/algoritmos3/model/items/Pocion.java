package org.fiuba.algoritmos3.model.items;

public class Pocion extends ItemRestauradorDeVida {

    public Pocion(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.cantidadDeCura = 20;
        this.nombre = "Pocion";
        this.descripcion = "Restaura 20 de vida.";
    }
}