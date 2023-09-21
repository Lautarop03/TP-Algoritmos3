package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.ModificacionVida;
import org.fiuba.algoritmos3.items.Item;

public class ItemRestauradorDeVida extends Item implements ModificacionVida {

    private Integer cantidadDeCura;


    public ItemRestauradorDeVida(Integer cantidad, Integer cantidadDeCura) {
        super(cantidad);
        this.cantidadDeCura = cantidadDeCura;
    }

    public void curar(){
        return;
    }
}