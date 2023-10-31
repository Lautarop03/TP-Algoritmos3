package org.fiuba.algoritmos3.model.pokemon.estados;

import org.fiuba.algoritmos3.model.modificadores.ModificacionVida;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import java.util.Random;

public class Confuso extends Estado implements ModificacionVida {
    final double probabilidadDeConfundirse = 0.15;
    private int contadorDeTurnos = 0;
    private int turnosDeDuracion = 3;

    public Confuso() { this.nombre = "Confuso"; }

    @Override
    public boolean aplicarEfecto(Pokemon pokemon) {
        Random random = new Random();
        double numeroAleatorio = random.nextDouble();
        if (numeroAleatorio <= probabilidadDeConfundirse) {
            //TODO lógica de Confuso
        }
        if (contadorDeTurnos == turnosDeDuracion) {
            pokemon.quitarEstado(); // TODO: solo sacar el estado confuso
            return false;
        }
        contadorDeTurnos++;
        return true;
    }

    public void modificarVida(Pokemon pokemon, Integer modificadorDeVida) {
        pokemon.bajarVida(modificadorDeVida);
    }

    @Override
    public Estado clonarEstado(Estado estado) {
        return null;
    }
}
