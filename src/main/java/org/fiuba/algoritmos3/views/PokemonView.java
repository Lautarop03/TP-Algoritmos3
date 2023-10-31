package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;

import java.util.List;

public class PokemonView {
    public void mostrarPokemon(Pokemon pokemon){
        String estado = verEstado(pokemon);
        System.out.println(pokemon.getNombre() + " Nivel: " + pokemon.getNivel() + " Vida restante: " + pokemon.getVidaActual() + estado);
    }

    private String verEstado(Pokemon pokemon) {
        List<Estado> estados = pokemon.getEstados();
        if (estados != null) {
            for(Estado estadoActual : estados) {
                return (" Estado: " + estadoActual.getNombre());
            }
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