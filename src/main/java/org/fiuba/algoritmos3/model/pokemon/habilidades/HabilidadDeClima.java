package org.fiuba.algoritmos3.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.clima.Clima;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;

public class HabilidadDeClima extends Habilidad {
    private final Clima clima;

    public HabilidadDeClima(String nombre, Integer cantidadDeUsos, Tipo tipo, Clima clima) {
        super(nombre, cantidadDeUsos, tipo);
        this.clima = clima;
    }

    public boolean usarHabilidad(Pokemon pokemonActual, Pokemon pokemonEnemigo) {
        super.usarHabilidad(pokemonActual,pokemonEnemigo);
        return false;
    }

    public Clima getClima() {
        return clima;
    }
}
