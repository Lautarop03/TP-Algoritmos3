package org.fiuba.algoritmos3.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.pokemon.MatrizDeEfectividad;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;



public class HabilidadDeDano extends Habilidad{

    private Integer potencia;

    public HabilidadDeDano(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer potencia) {
        super(nombre, cantidadDeUsos, tipo);
        this.potencia = potencia;
    }

    @Override
    public boolean usarHabilidad(Pokemon pokemonActual, Pokemon pokemonEnemigo) {
        double dano = this.calcularDano(pokemonEnemigo, pokemonActual);
        pokemonEnemigo.bajarVida((int)dano);
        super.usarHabilidad(pokemonActual, pokemonEnemigo);
        return true;

    }

    private double calcularDano(Pokemon pokemonActual, Pokemon pokemonEnemigo) {
        double danoFinal;
        MatrizDeEfectividad matriz = new MatrizDeEfectividad();
        danoFinal = (2 * pokemonActual.getNivel() * this.potencia * (pokemonActual.getAtaque()/pokemonEnemigo.getDefensa()))/5;
        danoFinal = ((danoFinal + 2) / 50) * this.STAB(pokemonActual) * matriz.getMatriz()[this.tipo.getIndice()][pokemonEnemigo.getTipo().getIndice()] * Math.random()* 38 + 217;
        return danoFinal;
    }

    private double STAB(Pokemon pokemonActual) {
        double stab = 1;
        if (pokemonActual.getTipo() == this.getTipo()){
            return stab = 1.5;
        }
        return  stab;
    }
}
