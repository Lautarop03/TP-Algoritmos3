package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.ModificacionVida;
import org.fiuba.algoritmos3.pokemon.Pokemon;

import java.io.EOFException;

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

