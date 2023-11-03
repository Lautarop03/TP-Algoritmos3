package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;


public abstract class ItemRestauradorDeVida extends Item {

    protected Integer cantidadDeCura;

    public ItemRestauradorDeVida(Integer cantidadDeItems) {
        super(cantidadDeItems);
    }

    public boolean aplicarItem(Pokemon pokemon){
        if (pokemon.tieneVidaLlena() || pokemon.estaMuerto()) {
            return true;
        }
        if (super.aplicarItem(pokemon)) {
            return true;
        }
        pokemon.sumarVida(this.cantidadDeCura);
        return false;
    }

    public Integer getcantidadDeCura(){
        return this.cantidadDeCura;
    }
}

