package org.fiuba.algoritmos3.pokemon.habilidades;

import org.fiuba.algoritmos3.Tipo;

public class HabilidadDeDano extends Habilidad {
    private Integer potencia;
    public HabilidadDeDano(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer potencia) {
        super(nombre, cantidadDeUsos, tipo);
        this.potencia = potencia;
    }
}

