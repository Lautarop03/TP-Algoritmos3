package org.fiuba.algoritmos3.model.clima;

import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class Huracan extends ClimaDeDano{
    public Huracan() {
        super();
        setNombre("Huracan");
        this.tiposBeneficiados = List.of(Tipo.Volador);
    }
}
