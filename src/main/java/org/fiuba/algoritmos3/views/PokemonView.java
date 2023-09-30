package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;

import java.util.List;

public class PokemonView {
    public void mostrarPokemon(Pokemon pokemon){
        System.out.println(pokemon.getNombre() + " Nivel:" + pokemon.getNivel() + " Vida restante:" + pokemon.getVidaActual());
    }
}