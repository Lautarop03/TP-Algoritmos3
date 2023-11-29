package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class Revivir extends Item{
    public Revivir(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Revivir";
        this.descripcion = "Revive con mitad de vida a un pokemon.";
    }
    @Override
    public boolean aplicarItem(Pokemon pokemon){
        if (pokemon.estaVivo()) {
            return true;
        }
        if (super.aplicarItem(pokemon)) {
            return true;
        }
        Integer nuevaVida = pokemon.getVidaMaxima() / 2;
        pokemon.sumarVida(nuevaVida);
        return false;
    }
}