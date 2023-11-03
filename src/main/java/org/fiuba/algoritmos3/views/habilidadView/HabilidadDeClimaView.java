package org.fiuba.algoritmos3.views.habilidadView;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeClima;

public class HabilidadDeClimaView extends HabilidadView{
    public void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonEnemigo){
        System.out.println("El pokemon " + pokemonActual.getNombre()
                + " ha utilizado " + habilidad.getNombre()
                + " y el clima actual es: " + habilidad.getNombre());
    }
}
