package org.fiuba.algoritmos3.clima;

import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class TormentaDeArena extends ClimaDeDano {
    public TormentaDeArena() {
        super();
        this.tiposBeneficiados = List.of(Tipo.Tierra,Tipo.Roca);
    }
}
