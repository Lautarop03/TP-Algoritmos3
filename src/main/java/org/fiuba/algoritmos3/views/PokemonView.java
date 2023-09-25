package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;

import java.util.List;

public class PokemonView {
    public void imprimirPokemon(Pokemon pokemon){
        System.out.printf("Nombre: : %s",pokemon.getNombre());
        System.out.printf("Nivel: %d",pokemon.getNivel());
        //System.out.printf("Estado: %d",pokemon.getEstado()); SOLO EN CASO QUE NO SEA ESTADO NORMAL
        System.out.printf("Vida restante: %d",pokemon.getVidaActual());
    }
    public void mostrarHabilidades(Pokemon pokemon) {
        List<Habilidad> habilidades = pokemon.getHabilidades();
        for (Habilidad habilidad : habilidades) {
            System.out.println(habilidad.getNombre()+" Usos: " + habilidad.getCantidadDeUsos());
        }
    }
}