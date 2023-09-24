package org.fiuba.algoritmos3.pokemon.habilidades;

import org.fiuba.algoritmos3.pokemon.Tipo;

public class HabilidadDeEstadistica extends Habilidad {
    private Integer nuevoValorAtributo;

    public HabilidadDeEstadistica(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer nuevoValorAtributo) {
        super(nombre, cantidadDeUsos, tipo);
        this.nuevoValorAtributo = nuevoValorAtributo;
    }

    public void modificarAtributo() {
        return;
    }
}
