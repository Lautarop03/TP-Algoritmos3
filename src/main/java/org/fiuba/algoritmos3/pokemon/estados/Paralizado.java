package org.fiuba.algoritmos3.pokemon.estados;

import org.fiuba.algoritmos3.pokemon.Pokemon;

import java.util.Random;

public class Paralizado extends Estado{
    final Double ProbabilidadParalidazo = 0.5;

    public Paralizado(int cantidadTurnos) {
        super(cantidadTurnos);
        this.nombre = "Paralizado";
    }

    @Override
    public boolean aplicarEfecto(Pokemon pokemon) {
        double probabilidad =  ProbabilidadParalidazo;
        Random random = new Random();
        double numeroAleatorio = random.nextDouble();
        return numeroAleatorio <= probabilidad;
    }

    public Estado clonarEstado(Estado estado) {
        return new Paralizado(this.cantidadTurnos);
    }
}
