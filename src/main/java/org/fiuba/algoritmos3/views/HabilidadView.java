package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;

public class HabilidadView{
    public void mostrarHabilidad(Habilidad habilidad){
        System.out.println("Habilidad:" + habilidad.getNombre() + " Usos:" + habilidad.getCantidadDeUsos());
    };
}