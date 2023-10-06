package org.fiuba.algoritmos3.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;

public abstract class Habilidad {
    private final String nombre;
    protected Integer cantidadDeUsos;
    protected Tipo tipo;

    public Habilidad(String nombre, Integer cantidadDeUsos, Tipo tipo) {
        this.nombre = nombre;
        this.cantidadDeUsos = cantidadDeUsos;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }


    public Integer getCantidadDeUsos() {
        return cantidadDeUsos;
    }

    public boolean usarHabilidad(Pokemon pokemonActual, Pokemon pokemonAModificar){
        cantidadDeUsos--;
        return false;
    }
}