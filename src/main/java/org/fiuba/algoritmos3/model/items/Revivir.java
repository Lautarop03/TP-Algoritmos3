package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class Revivir extends Item{
    public Revivir(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Revivir";
    }
    @Override
    public boolean aplicarItem(Pokemon pokemon){
        if (!pokemon.estaMuerto()){
            return true;
        }
        Integer nuevaVida = pokemon.getVidaMaxima() / 2;
        pokemon.sumarVida(nuevaVida);
        super.aplicarItem(pokemon);
        return false;
    }
}