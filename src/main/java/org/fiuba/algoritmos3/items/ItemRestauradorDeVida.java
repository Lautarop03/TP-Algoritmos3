package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.ModificacionVida;
import org.fiuba.algoritmos3.pokemon.Pokemon;

public abstract class ItemRestauradorDeVida extends Item implements ModificacionVida {

    protected Integer cantidadDeCura;


    public ItemRestauradorDeVida(Integer cantidadDeItems) {
        super(cantidadDeItems);
    }

    public void actualizarVida(Pokemon pokemon) {
        int nuevaCantidadVida = this.cantidadDeCura + pokemon.getVidaActual();
        modificarVida(pokemon, nuevaCantidadVida);
    }

    public void modificarVida(Pokemon pokemon, Integer nuevaCantidadVida) {
        if (nuevaCantidadVida > pokemon.getVidaMaxima()){
            pokemon.setVidaActual(pokemon.getVidaMaxima());
        }else{
           pokemon.setVidaActual(nuevaCantidadVida);
        }
        //todo no se puede usar la pocion y tirar excepcion


    }
}