package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;

public class PokemonView {

    private Pokemon pokemon;

    public void imprimirPokemon(){
        System.out.printf("Pokemon: : %s",pokemon.getNombre());
        System.out.printf("Nivel: %d",pokemon.getNivel());
        System.out.printf("Tipo: %s",pokemon.getTipo());
        System.out.printf("Vida Maxima: %d",pokemon.getVidaMaxima());
        System.out.printf("Vida actual: %d",pokemon.getVidaActual());
        System.out.printf("Velocidad: %d",pokemon.getVelocidad());
        System.out.printf("Defensa: %d",pokemon.getDefensa());
        System.out.printf("Ataque: %d",pokemon.getAtaque());
        //System.out.printf("Estado: %d",pokemon.getEstado());
        //System.out.printf("Habilidades: %d",pokemon.getHabilidades());
    }

}