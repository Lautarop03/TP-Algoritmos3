package org.fiuba.algoritmos3.pokemon.estados;

import org.fiuba.algoritmos3.pokemon.Pokemon;

public abstract class Estado {
    protected String nombre;
    protected int cantidadTurnos;
    protected Estado estado;

    public Estado() {
    }

    public boolean aplicarEfecto(Pokemon pokemon){
        return true;
    }

    public void aumentarTurnos(){
        cantidadTurnos++;
    }

    public abstract Estado clonarEstado(Estado estado);

    public int getCantidadTurnos(){
        return this.cantidadTurnos;
    }

    public String getNombre() {
        return nombre;
    }
}
