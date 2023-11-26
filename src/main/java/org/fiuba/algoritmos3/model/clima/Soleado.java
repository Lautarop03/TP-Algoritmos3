package org.fiuba.algoritmos3.model.clima;

import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class Soleado extends Clima{
    public Soleado() {
        super();
        setNombre("Soleado");
        this.tiposBeneficiados = List.of(Tipo.Fuego);
    }
}
