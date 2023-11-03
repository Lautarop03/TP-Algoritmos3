package org.fiuba.algoritmos3.model.clima;

import org.fiuba.algoritmos3.model.pokemon.Tipo;

import java.util.List;

public class Niebla extends Clima{
    public Niebla() {
        super();
        this.tiposBeneficiados = List.of(Tipo.Fantasma,Tipo.Psiquico);
    }
}
