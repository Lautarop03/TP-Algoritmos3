package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;


public abstract class ItemRestauradorDeVidaPorcentual extends Item {

    protected float porcentajeDeCura;

    public ItemRestauradorDeVidaPorcentual(Integer cantidadDeItems) {
        super(cantidadDeItems);
    }

    public boolean aplicarItem(Pokemon pokemon){
        if (pokemon.tieneVidaLlena() || pokemon.estaMuerto()) {
            return true;
        }
        float vidaASumar = (pokemon.getVidaMaxima() * porcentajeDeCura);
        pokemon.sumarVida((int)vidaASumar);
        super.aplicarItem(pokemon);
        return false;
    }
}

