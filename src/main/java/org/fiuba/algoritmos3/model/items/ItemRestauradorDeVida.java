package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;


public abstract class ItemRestauradorDeVida extends Item {

    protected Integer cantidadDeCura;

    public ItemRestauradorDeVida(Integer cantidadDeItems) {
        super(cantidadDeItems);
    }

    public boolean aplicarItem(Pokemon pokemon){
        if (pokemon.tieneVidaLlena() || pokemon.estaMuerto()) {
            return false;
        }
        pokemon.sumarVida(this.cantidadDeCura);
        super.aplicarItem(pokemon);
        return true;
    }
}

