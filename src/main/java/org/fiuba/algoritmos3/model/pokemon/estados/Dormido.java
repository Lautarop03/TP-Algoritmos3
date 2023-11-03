package org.fiuba.algoritmos3.model.pokemon.estados;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.util.Random;

public class Dormido extends Estado {
    final Double ProbabilidadDeDespertarse = 0.25;
    private int contadorDeTurnos = 0;
    private Random random = new Random();

    public Dormido() {
        this.nombre = "Dormido";
    }

    @Override
    public boolean aplicarEfecto(Pokemon pokemon) {
        double probabilidad = ProbabilidadDeDespertarse + contadorDeTurnos * ProbabilidadDeDespertarse;
        Random random = this.random;
        if (random == null) {
            random = new Random();
        }
        double numeroAleatorio = random.nextDouble();
        if (numeroAleatorio <= probabilidad) {
            pokemon.quitarEstado(this);
            return false;
        }
        contadorDeTurnos++;
        return true;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Estado clonarEstado(Estado estado) {
        return new Dormido();
    }
}