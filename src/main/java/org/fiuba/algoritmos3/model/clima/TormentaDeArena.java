package org.fiuba.algoritmos3.model.clima;

import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class TormentaDeArena extends ClimaDeDano {
    public TormentaDeArena() {
        super();
        setNombre("Tormenta de arena");
        this.tiposBeneficiados = List.of(Tipo.Tierra,Tipo.Roca);
    }
}
