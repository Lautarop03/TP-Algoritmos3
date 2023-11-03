package org.fiuba.algoritmos3.model.pokemon.estados;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.util.Random;

public class Paralizado extends Estado{
    private Random random = new Random();

    public Paralizado() {
        this.nombre = "Paralizado";
    }

    @Override
    public boolean aplicarEfecto(Pokemon pokemon) {
        double probabilidad = 0.5;
        Random random = this.random;
        double numeroAleatorio = random.nextDouble();
        return numeroAleatorio <= probabilidad;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Estado clonarEstado(Estado estado) {return new Paralizado();}
}
