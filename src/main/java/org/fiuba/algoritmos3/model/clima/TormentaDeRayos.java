package org.fiuba.algoritmos3.model.clima;

import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class TormentaDeRayos extends ClimaDeDano{
    public TormentaDeRayos() {
        super();
        this.tiposBeneficiados = List.of(Tipo.Electrico);
    }
}
