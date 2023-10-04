package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.estados.Estado;

public class PokemonView {
    public void mostrarPokemon(Pokemon pokemon){
        String estado = verEstado(pokemon);
        System.out.println(pokemon.getNombre() + " Nivel: " + pokemon.getNivel() + " Vida restante: " + pokemon.getVidaActual() + estado);
    }

    private String verEstado(Pokemon pokemon) {
        Estado estado = pokemon.getEstado();
        if (estado != null) {
            return (" Estado: " + estado.getNombre()) ;
        }
        return "";
    }

    public void mostrarErrorIntercambiarSinVida() {
        System.out.println("Error, pokemon sin vida.");
    }

    public void mostrarErrorIntercambiarMismo() {
        System.out.println("Error, es el mismo pokemon.");
    }

    public void mostrarCambioPokemon(Pokemon pokemon){
        System.out.println("El pokemon se cambio por: "+ pokemon.getNombre());
    }
}