package org.fiuba.algoritmos3.model.pokemon.estados;

import org.fiuba.algoritmos3.model.modificadores.ModificacionVida;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import java.util.Random;

public class Confuso extends Estado implements ModificacionVida {
    final double probabilidadDeConfundirse = 0.33;
    private int contadorDeTurnos = 0;
    private int turnosDeDuracion = 3;

    public Confuso() { this.nombre = "Confuso"; }

    @Override
    public boolean aplicarEfecto(Pokemon pokemon) {
        Random random = new Random();
        double numeroAleatorio = random.nextDouble();
        if (numeroAleatorio <= probabilidadDeConfundirse) {
            pokemon.bajarVida((pokemon.getVidaMaxima()*15)/100);
        }
        if (contadorDeTurnos == turnosDeDuracion) {
            pokemon.quitarEstado(this);
            return false;
        }
        contadorDeTurnos++;
        return true;
    }

    public void modificarVida(Pokemon pokemon, Integer modificadorDeVida) {
        pokemon.bajarVida(modificadorDeVida);
    }

    public Estado clonarEstado(Estado estado) {
        return new Confuso();
    }
}
