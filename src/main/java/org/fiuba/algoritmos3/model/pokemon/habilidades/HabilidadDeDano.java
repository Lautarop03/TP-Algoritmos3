package org.fiuba.algoritmos3.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.pokemon.MatrizDeEfectividad;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;



public class HabilidadDeDano extends Habilidad{

    private final Integer potencia;

    public HabilidadDeDano(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer potencia) {
        super(nombre, cantidadDeUsos, tipo);
        this.potencia = potencia;
    }

    @Override
    public boolean usarHabilidad(Pokemon pokemonActual, Pokemon pokemonEnemigo) {
        double dano = this.calcularDano(pokemonActual, pokemonEnemigo);
        pokemonEnemigo.bajarVida((int)dano);
        super.usarHabilidad(pokemonActual, pokemonEnemigo);
        return false;
    }

    private double probabilidadCritico(){
        double random = Math.random()* 100;
        if (random < 9){
            return 2.0;
        } else {
            return 1.0;
        }
    }


    private double calcularDano(Pokemon pokemonActual, Pokemon pokemonEnemigo) {
        double danoFinal;
        MatrizDeEfectividad matriz = new MatrizDeEfectividad();
        danoFinal = 2 * pokemonActual.getNivel() * this.potencia * this.probabilidadCritico();
        double AYD = (pokemonActual.getAtaque()/pokemonEnemigo.getDefensa());
        danoFinal = ((danoFinal * AYD/5) + 2)/50;
        danoFinal = danoFinal * this.STAB(pokemonActual) * matriz.getMatriz()[this.tipo.getIndice()][pokemonEnemigo.getTipo().getIndice()];
        danoFinal = danoFinal * (Math.random()* 38 + 217)/255;
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
