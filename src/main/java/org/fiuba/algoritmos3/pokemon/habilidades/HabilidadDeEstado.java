package org.fiuba.algoritmos3.habilidades;

import org.fiuba.algoritmos3.Estado;
import org.fiuba.algoritmos3.Tipo;

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
