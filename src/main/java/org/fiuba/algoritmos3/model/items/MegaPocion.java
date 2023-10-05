package org.fiuba.algoritmos3.model.items;

public class MegaPocion extends ItemRestauradorDeVida {

    public MegaPocion(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.cantidadDeCura = 50;
        this.nombre = "MegaPoción";
    }
}
