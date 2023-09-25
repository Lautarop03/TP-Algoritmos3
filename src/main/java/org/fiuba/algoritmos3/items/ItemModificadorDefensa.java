package org.fiuba.algoritmos3.items;

import org.fiuba.algoritmos3.ModificacionDefensa;
import org.fiuba.algoritmos3.pokemon.Pokemon;

public class ItemModificadorDefensa extends ItemDeEstadistica implements ModificacionDefensa {

    public ItemModificadorDefensa(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Modificador de defensa";
        this.porcentajeDeModificacion = 10;
    }

    public void modificarDefensa(Pokemon pokemon) {
        pokemon.setDefensa((pokemon.getDefensa() + (pokemon.getDefensa()/this.porcentajeDeModificacion)));
    }
}