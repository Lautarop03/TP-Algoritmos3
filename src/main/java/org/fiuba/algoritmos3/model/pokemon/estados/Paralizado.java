package org.fiuba.algoritmos3.model.pokemon.estados;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.util.Random;

public class Paralizado extends Estado{

    public Paralizado() {
        this.nombre = "Paralizado";
    }

    @Override
    public boolean aplicarEfecto(Pokemon pokemon) {
        double probabilidad = 0.5;
        Random random = new Random();
        double numeroAleatorio = random.nextDouble();
        return numeroAleatorio <= probabilidad;
    }

    public Estado clonarEstado(Estado estado) {return new Paralizado();}
}
