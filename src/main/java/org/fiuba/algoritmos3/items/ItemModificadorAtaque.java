package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.ModificacionAtaque;
import org.fiuba.algoritmos3.pokemon.Pokemon;

public class ItemModificadorAtaque extends ItemDeEstadistica implements ModificacionAtaque {

    public ItemModificadorAtaque(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Modificador de ataque";
        this.porcentajeDeModificacion = 10;
    }

    public void modificarAtaque(Pokemon pokemon) {
        pokemon.setAtaque((pokemon.getAtaque() + ((pokemon.getAtaque()/100)*this.porcentajeDeModificacion)));
    }
}