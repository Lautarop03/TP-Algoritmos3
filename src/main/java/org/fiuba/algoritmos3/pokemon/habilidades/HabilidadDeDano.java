package org.fiuba.algoritmos3.pokemon.habilidades;

import org.fiuba.algoritmos3.ModificacionVida;
import org.fiuba.algoritmos3.pokemon.MatrizDeEfectividad;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.Tipo;



public class HabilidadDeDano extends Habilidad implements ModificacionVida {

    private Integer potencia;

    public HabilidadDeDano(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer potencia) {
        super(nombre, cantidadDeUsos, tipo);
        this.potencia = potencia;
    }

    private double calcularDano(Pokemon pokemonActual, Pokemon pokemonEnemigo) {
        double danoFinal;
        MatrizDeEfectividad matriz = new MatrizDeEfectividad();
        danoFinal = (2 * pokemonActual.getNivel() * this.potencia * (pokemonActual.getAtaque()/pokemonEnemigo.getDefensa()))/5;
        danoFinal = ((danoFinal + 2) / 50) * this.STAB(pokemonActual) * matriz.getMatriz()[this.tipo.getIndice()][pokemonEnemigo.getTipo().getIndice()] * Math.random()* 38 + 217;
        return danoFinal;
    }

    public void modificarVida(Pokemon pokemonEnemigo, Integer modificadorDeVida) {
         pokemonEnemigo.setVidaActual(pokemonEnemigo.getVidaActual() - modificadorDeVida);
    }

    public void atacar(Pokemon pokemonActual, Pokemon pokemonEnemigo){
        double dano = this.calcularDano(pokemonEnemigo, pokemonActual);
        this.modificarVida(pokemonEnemigo, (int)dano);
    }

    private double STAB(Pokemon pokemonActual) {
        double stab = 1;
        if (pokemonActual.getTipo() == this.getTipo()){
            return stab = 1.5;
        }
        return  stab;
    }
}
