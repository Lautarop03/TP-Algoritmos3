package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.modificadores.ModificacionDefensa;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class ItemModificadorDefensa extends ItemDeEstadistica implements ModificacionDefensa {

    public ItemModificadorDefensa(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Modificador de defensa";
        this.porcentajeDeModificacion = 10;
    }

    @Override
    public boolean aplicarItem(Pokemon pokemon) {
        modificarDefensa(pokemon);
        super.aplicarItem(pokemon);
        return true;
    }
    public void modificarDefensa(Pokemon pokemon) {
        pokemon.setDefensa((pokemon.getDefensa() + (pokemon.getDefensa()/100)*this.porcentajeDeModificacion));
    }
}