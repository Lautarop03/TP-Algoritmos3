package org.fiuba.algoritmos3.model.pokemon.estados;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public abstract class Estado {
    protected String nombre;
    protected Estado estado;

    public Estado() {
    }

    public boolean aplicarEfecto(Pokemon pokemon){
        return true;
    }

    public abstract Estado clonarEstado(Estado estado);

    public String getNombre() {
        return nombre;
    }
}
