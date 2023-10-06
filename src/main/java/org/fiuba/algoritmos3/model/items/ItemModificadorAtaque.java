package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.modificadores.ModificacionAtaque;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class ItemModificadorAtaque extends ItemDeEstadistica implements ModificacionAtaque {

    public ItemModificadorAtaque(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Modificador de ataque";
        this.porcentajeDeModificacion = 10;
    }

    @Override
    public boolean aplicarItem(Pokemon pokemon){
        modificarAtaque(pokemon);
        super.aplicarItem(pokemon);
        return false;
    }

    public void modificarAtaque(Pokemon pokemon) {
        pokemon.setAtaque((pokemon.getAtaque() + ((pokemon.getAtaque()/100)*this.porcentajeDeModificacion)));
    }
}