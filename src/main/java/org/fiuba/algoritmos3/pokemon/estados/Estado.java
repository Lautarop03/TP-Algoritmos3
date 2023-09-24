package org.fiuba.algoritmos3.pokemon.estados;

import org.fiuba.algoritmos3.pokemon.Pokemon;

public class Estado extends Pokemon {
    private int cantidadTurnos;

    public Estado(int cantidadTurnos) {
        this.cantidadTurnos = cantidadTurnos;
    }
}
