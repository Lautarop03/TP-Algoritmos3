package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.*;

public class HabilidadView{

    public void mostrarHabilidad(Habilidad habilidad){
        System.out.println("Habilidad:" + habilidad.getNombre() + " Usos:" + habilidad.getCantidadDeUsos());
    }

    public void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonEnemigo){
        System.out.println("El pokemon " + pokemonActual.getNombre()
                + " ha utilizado " + habilidad.getNombre()
                + " en " + pokemonEnemigo.getNombre());
    }

    public void mostrarAccion(HabilidadDeDano habilidad, Pokemon pokemonActual, Pokemon pokemonEnemigo){
        System.out.println("El pokemon " + pokemonActual.getNombre()
                + " ha utilizado " + habilidad.getNombre()
                + " en " + pokemonEnemigo.getNombre()
                + " cuya vida actual es de: " + pokemonEnemigo.getVidaActual());
    }

    public void mostrarAccion(HabilidadDeEstado habilidad, Pokemon pokemonActual, Pokemon pokemonEnemigo){
        System.out.println("El pokemon " + pokemonActual.getNombre()
                + " ha utilizado " + habilidad.getNombre()
                + " en " + pokemonEnemigo.getNombre()
                + " que ahora tiene el estado " + habilidad.getNombre());
    }

    public void mostrarAccion(HabilidadDeEstadisticaAtaque habilidad, Pokemon pokemonActual, Pokemon pokemonTarget){
        if (pokemonActual == pokemonTarget) {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " su nuevo ataque es de" + pokemonTarget.getAtaque());
        } else {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " en " + pokemonTarget.getNombre()
                    + " su nuevo ataque es de " + pokemonTarget.getAtaque());
        }
    }

    public void mostrarAccion(HabilidadDeEstadisticaDefensa habilidad, Pokemon pokemonActual, Pokemon pokemonTarget){
        if (pokemonActual == pokemonTarget) {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " su nueva defensa es de" + pokemonTarget.getDefensa());
        } else {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " en " + pokemonTarget.getNombre()
                    + " su nueva defensa es de" + pokemonTarget.getDefensa());
        }
    }

    public void mostrarAccion(HabilidadDeEstadisticaVida habilidad, Pokemon pokemonActual, Pokemon pokemonTarget){
        if (pokemonActual == pokemonTarget) {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " su nueva vida es de" + pokemonTarget.getDefensa());
        } else {
            System.out.println("El pokemon " + pokemonActual.getNombre()
                    + " ha utilizado " + habilidad.getNombre()
                    + " en " + pokemonTarget.getNombre()
                    + " su nueva vida es de" + pokemonTarget.getDefensa());
        }
    }
}
