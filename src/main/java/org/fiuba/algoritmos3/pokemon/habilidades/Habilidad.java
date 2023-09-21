package org.fiuba.algoritmos3.habilidades;

import org.fiuba.algoritmos3.Tipo;

public class Habilidad {
    private String nombre;
    private Integer cantidadDeUsos;
    private Tipo tipo;

    public Habilidad(String nombre, Integer cantidadDeUsos, Tipo tipo) {
        this.nombre = nombre;
        this.cantidadDeUsos = cantidadDeUsos;
        this.tipo = tipo;
    }
}
