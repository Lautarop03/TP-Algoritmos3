package org.fiuba.algoritmos3.viewsJavaFX;

import org.fiuba.algoritmos3.model.clima.Clima;

public class ClimaViewJavaFX {
    public void mostrarClima(Clima clima) {
        System.out.println("El clima actual es " + clima.getNombre());
    }

    public void mostrarEfectoClima(Clima clima) {
        System.out.println("");
    }
    //TODO: Mostrar si afecta a los pokemones
}
