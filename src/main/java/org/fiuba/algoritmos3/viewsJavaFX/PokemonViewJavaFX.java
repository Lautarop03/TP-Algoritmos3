package org.fiuba.algoritmos3.viewsJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;

import java.util.List;

public class PokemonViewJavaFX {
    public void mostrarPokemon(Pokemon pokemon){
        String estado = verEstado(pokemon);
        System.out.println(pokemon.getNombre() + " Nivel: " + pokemon.getNivel() + " Vida restante: " + pokemon.getVidaActual() + estado);
    }

    private String verEstado(Pokemon pokemon) {
        List<Estado> estados = pokemon.getEstados();
        StringBuilder res = new StringBuilder();
        if (estados != null && !estados.isEmpty()) {
            res.append(" Estado: ");
            for(Estado estadoActual : estados) {
                res.append(estadoActual.getNombre()).append(" ");
            }
        } else {
            return "";
        }
        return res.toString();
    }

    public void mostrarErrorIntercambiarSinVida() {
        System.out.println("Error, pokemon sin vida.");
    }

    public void mostrarErrorIntercambiarMismo() {
        System.out.println("Error, es el mismo pokemon.");
    }

    public String mostrarCambioPokemon(Pokemon pokemon){
        return ("El pokemon se cambio por: "+ pokemon.getNombre());
    }
}