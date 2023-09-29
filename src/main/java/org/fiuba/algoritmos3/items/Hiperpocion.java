package org.fiuba.algoritmos3.items;

public class Hiperpocion extends ItemRestauradorDeVida {

    public Hiperpocion(Integer cantidad) {
        super(cantidad);
        this.cantidadDeCura = 100;
        this.nombre = "HiperPoción";
    }


}