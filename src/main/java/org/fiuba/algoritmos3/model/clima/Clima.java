package org.fiuba.algoritmos3.model.clima;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class Clima {
    protected int turnosRestantes;
    private Pokemon benef1;
    private Pokemon benef2;
    protected List<Tipo> tiposBeneficiados;
    private String nombre;

    protected Clima() {
        this.turnosRestantes = 5;
        this.benef2 = null;
        this.benef1 = null;
    }

    public boolean aplicarClima(Pokemon pokemon1, Pokemon pokemon2) {
        if (turnosRestantes == 0) {
            quitarBeneficios(benef1,benef2);
            return false;
        }
        if (benef1 != null && benef2 != null) {
            quitarBeneficios(benef1,benef2);
        }
        benef1 = pokemon1;
        benef2 = pokemon2;
        potenciarBeneficiados(benef1,benef2);
        this.turnosRestantes -= 1;
        return true;
    }

    public void potenciarBeneficiados(Pokemon pokemon1, Pokemon pokemon2) {
        Double ataque1 = pokemon1.getAtaque();
        Double ataque2 = pokemon2.getAtaque();

        if (this.tiposBeneficiados.contains(pokemon1.getTipo())) {
            pokemon1.setAtaque(ataque1+(ataque1*0.01));
        }
        if (this.tiposBeneficiados.contains(pokemon2.getTipo())) {
            pokemon2.setAtaque(ataque2+(ataque2*0.01));
        }
    }

    public void quitarBeneficios(Pokemon pokemon1, Pokemon pokemon2){
        Double ataque1 = pokemon1.getAtaque();
        Double ataque2 = pokemon2.getAtaque();

        if (this.tiposBeneficiados.contains(pokemon1.getTipo())) {
            pokemon1.setAtaque(ataque1-(ataque1*0.01));
        }
        if (this.tiposBeneficiados.contains(pokemon2.getTipo())) {
            pokemon2.setAtaque(ataque2-(ataque2*0.01));
        }
    }

    public String getNombre() {
        return nombre;
    }
}

