package org.fiuba.algoritmos3.clima;

import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class Lluvia extends Clima{
    public Lluvia() {
        super();
        this.tiposBeneficiados = List.of(Tipo.Agua,Tipo.Planta);
    }
}
