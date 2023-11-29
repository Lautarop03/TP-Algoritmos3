package org.fiuba.algoritmos3.model.items;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;

public class PocionMolestaAlumnos extends ItemRestauradorDeVidaPorcentual{

    private final float probaDeCura = 0.33f;

    public PocionMolestaAlumnos(Integer cantidad) {
        super(cantidad);
        this.porcentajeDeCura = 1/3f;
        this.nombre = "Pocion Molesta Alumnos";
        this.descripcion = "Restaura un 33% de la vida maxima.";

    }

}
