package org.fiuba.algoritmos3.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.pokemon.MatrizDeEfectividad;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.Random;


public class HabilidadDeDano extends Habilidad{

    private final Integer potencia;
    private final double[] arrayEfectividad;
    private Random random = null;

    public HabilidadDeDano(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer potencia) {
        super(nombre, cantidadDeUsos, tipo);
        MatrizDeEfectividad matrizDeEfectividad = new MatrizDeEfectividad();
        this.potencia = potencia;
        this.arrayEfectividad = matrizDeEfectividad.getArrayTipo(tipo);
    }

    @Override
    public boolean usarHabilidad(Pokemon pokemonActual, Pokemon pokemonEnemigo) {
        double dano = this.calcularDano(pokemonActual, pokemonEnemigo);
        pokemonEnemigo.bajarVida((int)dano);
        super.usarHabilidad(pokemonActual, pokemonEnemigo);
        return false;
    }

    private double probabilidadCritico(){
        Random random = this.random;
        if (random == null) {
            random = new Random();
        }
        double valorRandom = random.nextDouble() * 100;
        if (valorRandom < 9){
            return 2.0;
        } else {
            return 1.0;
        }
    }


    private double calcularDano(Pokemon pokemonActual, Pokemon pokemonEnemigo) {
        double danoFinal;
        Random random = this.random;
        if (random == null) {
            random = new Random();
        }
        double valorRandom = random.nextDouble();

        danoFinal = 2 * pokemonActual.getNivel() * this.potencia * this.probabilidadCritico();
        double AYD = (pokemonActual.getAtaque()/pokemonEnemigo.getDefensa());
        danoFinal = ((danoFinal * AYD/5) + 2)/50;
        danoFinal = danoFinal * this.STAB(pokemonActual) * this.arrayEfectividad[pokemonEnemigo.getTipo().getIndice()];
        danoFinal = danoFinal * (valorRandom* 38 + 217)/255;
        return danoFinal;
    }

    public double STAB(Pokemon pokemonActual) {
        double stab = 1;
        if (pokemonActual.getTipo() == this.getTipo()){
            stab = 1.5;
        }
        return  stab;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public double getProbabilidadCritico(){
        return  this.probabilidadCritico();
    }

    public double[] getArrayEfectividad(){
        return this.arrayEfectividad;
    }

    public double getSTAB(Pokemon pokemon){
        return  this.STAB(pokemon);
    }

    public void setRandom(Random random){
        this.random = random;
    }

}
