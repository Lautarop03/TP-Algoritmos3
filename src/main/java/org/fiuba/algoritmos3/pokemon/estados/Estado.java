package org.fiuba.algoritmos3.pokemon.estados;

import org.fiuba.algoritmos3.pokemon.Pokemon;

public abstract class Estado {
    protected String nombre;
    protected int cantidadTurnos;

    protected Estado estado;

    public Estado(int cantidadTurnos) {
        this.cantidadTurnos = cantidadTurnos;
    }

    public boolean aplicarEfecto(Pokemon pokemon){
        return true;
    }
    public void aumentarTurnos (){
        cantidadTurnos++;
    }
}