package org.fiuba.algoritmos3.clima;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class Clima {
    protected int turnosRestantes;
    protected List<Tipo> tiposBeneficiados;
    protected Clima() {
        this.turnosRestantes = 5;
    }
    public void aplicarClima(Pokemon pokemon1, Pokemon pokemon2) {
        this.turnosRestantes -= 1;
        //TODO: Como potenciar los ataques de los pokemones actuales(si son beneficiados) 10% mas de poder
    }

}
