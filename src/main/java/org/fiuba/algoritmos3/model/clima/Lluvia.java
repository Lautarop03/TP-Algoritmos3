package org.fiuba.algoritmos3.model.clima;

import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class Lluvia extends Clima{
    public Lluvia() {
        super();
        setNombre("Lluvia");
        this.tiposBeneficiados = List.of(Tipo.Agua,Tipo.Planta);
    }
}
