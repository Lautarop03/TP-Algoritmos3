package org.fiuba.algoritmos3;

public class ItemRestauradorDeVida extends Item implements ModificacionVida{

    private Integer cantidadDeCura;


    public ItemRestauradorDeVida(Integer cantidad, Integer cantidadDeCura) {
        super(cantidad);
        this.cantidadDeCura = cantidadDeCura;
    }

    public curar(){

    }

}