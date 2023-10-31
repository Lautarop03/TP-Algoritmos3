package org.fiuba.algoritmos3.clima;

import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class Soleado extends Clima{
    public Soleado() {
        super();
        this.tiposBeneficiados = List.of(Tipo.Fuego);
    }
}
