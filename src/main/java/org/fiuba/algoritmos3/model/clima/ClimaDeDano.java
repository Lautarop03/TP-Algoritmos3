package org.fiuba.algoritmos3.model.clima;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public abstract class ClimaDeDano extends Clima{
    private final int porcentajeDeDano;
    public ClimaDeDano() {
        super();
        this.porcentajeDeDano = 3;
    }
    @Override
    public boolean aplicarClima(Pokemon pokemon1, Pokemon pokemon2) {
        if(super.aplicarClima(pokemon1,pokemon2)) {
            if (!this.tiposBeneficiados.contains(pokemon1.getTipo())) {
                pokemon1.bajarVida((pokemon1.getVidaMaxima()*porcentajeDeDano)/100);
            }
            if (!this.tiposBeneficiados.contains(pokemon2.getTipo())) {
                pokemon2.bajarVida((pokemon2.getVidaMaxima()*porcentajeDeDano)/100);
            }
            return true;
        }
        return false;
        }

    }

