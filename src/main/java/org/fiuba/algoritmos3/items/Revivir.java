package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.ModificacionVida;
import org.fiuba.algoritmos3.pokemon.Pokemon;

public class Revivir extends Item implements ModificacionVida {
    public Revivir(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Revivir";
    }

    public boolean revivir(Pokemon pokemon){
        if (pokemon.getVidaActual() <= 0){
            this.modificarVida(pokemon);
            this.seleccionar();
            return true;
        }
        return false;
    }

    public void modificarVida(Pokemon pokemon) {
        pokemon.setVidaActual(pokemon.getVidaMaxima()/2);
    }
}