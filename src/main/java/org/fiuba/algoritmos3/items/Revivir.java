package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.ModificacionVida;
import org.fiuba.algoritmos3.pokemon.Pokemon;

public class Revivir extends Item implements ModificacionVida {
    public Revivir(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Revivir";
    }

    public boolean revivir(Pokemon pokemon){
        if (pokemon.getVidaActual() > 0) {
            return false;
        }
        Integer modificadorDeVida = pokemon.getVidaMaxima() / 2;
        this.modificarVida( pokemon, modificadorDeVida);
        this.seleccionar();
        return true;
    }

    public void modificarVida(Pokemon pokemon, Integer modificadorDeVida) {
        pokemon.setVidaActual(pokemon.getVidaMaxima()/2);
    }
}