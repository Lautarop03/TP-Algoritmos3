package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.modificadores.ModificacionDefensa;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class ItemModificadorDefensa extends ItemDeEstadistica implements ModificacionDefensa {

    public ItemModificadorDefensa(Integer cantidadDeItems) {
        super(cantidadDeItems);
        this.nombre = "Modificador de defensa";
        this.porcentajeDeModificacion = 10;
        this.descripcion = "Aumenta la defensa en un 10%";

    }

    @Override
    public boolean aplicarItem(Pokemon pokemon) {
        if (super.aplicarItem(pokemon)) {
            return true;
        }
        modificarDefensa(pokemon);
        return false;
    }
    public void modificarDefensa(Pokemon pokemon) {
        pokemon.setDefensa((pokemon.getDefensa() + (pokemon.getDefensa()/100)*this.porcentajeDeModificacion));
    }
}