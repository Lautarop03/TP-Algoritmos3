package org.fiuba.algoritmos3.pokemon.habilidades;

import org.fiuba.algoritmos3.pokemon.Tipo;

public  abstract class HabilidadDeEstadistica extends Habilidad{
    protected Integer porcentajeDeModificacion;

    public HabilidadDeEstadistica(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer porcentajeDeModificacion) {
        super(nombre, cantidadDeUsos, tipo);
        this.porcentajeDeModificacion = porcentajeDeModificacion;
    }
}
