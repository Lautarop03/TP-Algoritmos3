package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.pokemon.Pokemon;

public class Revivir extends Item{
    public Revivir(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Revivir";
    }
    @Override
    public boolean aplicarItem(Pokemon pokemon){
        //Todo: que no se pueda aplicar el revivir al pokemon en el campo de juego
        if (!pokemon.estaMuerto()){
            return false;
        }
        Integer nuevaVida = pokemon.getVidaMaxima() / 2;
        pokemon.sumarVida(nuevaVida);
        super.aplicarItem(pokemon);
        return true;
    }
}