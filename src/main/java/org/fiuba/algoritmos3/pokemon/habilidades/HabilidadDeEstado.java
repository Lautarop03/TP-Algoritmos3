package org.fiuba.algoritmos3.pokemon.habilidades;

import org.fiuba.algoritmos3.pokemon.estados.Estado;
import org.fiuba.algoritmos3.pokemon.Tipo;

public class HabilidadDeEstado extends Habilidad {
    private Estado estado;

    public HabilidadDeEstado(String nombre, Integer cantidadDeUsos, Tipo tipo, Estado estado) {
        super(nombre, cantidadDeUsos, tipo);
        this.estado = estado;
    }

    public void aplicarEstado() {
        return;
    }
}
