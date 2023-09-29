package org.fiuba.algoritmos3.pokemon.estados;

import org.fiuba.algoritmos3.pokemon.Pokemon;

import java.util.Random;

public class Dormido extends Estado {
    final Double ProbabilidadDeDespertarse = 0.25;
    private int contadorDeTurnos = 0;

    public Dormido(int cantidadTurnos) {
        super(cantidadTurnos);
        this.nombre = "Dormido";
    }

    @Override
    public boolean aplicarEfecto(Pokemon pokemon) {
        double probabilidad = ProbabilidadDeDespertarse + cantidadTurnos * ProbabilidadDeDespertarse;
        Random random = new Random();
        double numeroAleatorio = random.nextDouble();
        if (numeroAleatorio <= probabilidad){
            return true;
        }
        contadorDeTurnos++;
        return false;
    }
}