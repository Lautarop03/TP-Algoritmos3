package org.fiuba.algoritmos3.model.pokemon.estados;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.util.Random;

public class Dormido extends Estado {
    final Double ProbabilidadDeDespertarse = 0.25;
    private int contadorDeTurnos = 0;

    public Dormido() {
        this.nombre = "Dormido";
    }

    @Override
    public boolean aplicarEfecto(Pokemon pokemon) {
        double probabilidad = ProbabilidadDeDespertarse + contadorDeTurnos * ProbabilidadDeDespertarse;
        Random random = new Random();
        double numeroAleatorio = random.nextDouble();
        if (numeroAleatorio <= probabilidad) {
            pokemon.quitarEstados();
            return false;
        }
        contadorDeTurnos++;
        return true;
    }

    public Estado clonarEstado(Estado estado) {
        return new Dormido();
    }
}