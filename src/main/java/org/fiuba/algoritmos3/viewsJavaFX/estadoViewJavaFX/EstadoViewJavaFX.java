package org.fiuba.algoritmos3.viewsJavaFX.estadoViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;


public abstract class EstadoViewJavaFX {
    public abstract void mostrarEstado(Pokemon pokemon, Estado estado, boolean aplicado);

}
