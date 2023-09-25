package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.ModificacionVida;
import org.fiuba.algoritmos3.pokemon.Pokemon;

public abstract class ItemRestauradorDeVida extends Item implements ModificacionVida {

    protected Integer cantidadDeCura;


    public ItemRestauradorDeVida(Integer cantidadDeItems) {
        super(cantidadDeItems);
    }

    public void modificarVida(Pokemon pokemon) {
        int nuevaCantidadVida = this.cantidadDeCura + pokemon.getVidaActual();
        if (nuevaCantidadVida > pokemon.getVidaMaxima()){
            pokemon.setVidaActual(pokemon.getVidaMaxima());
        }else{
           pokemon.setVidaActual(nuevaCantidadVida);
        }
    }
}