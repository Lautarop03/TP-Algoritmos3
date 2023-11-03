package org.fiuba.algoritmos3.acciones;

import org.fiuba.algoritmos3.model.Juego;


public class AccionCambiarPokemon implements Accion{
    public boolean realizarAccion(Juego juego) {
        return juego.cambiarPokemon();
    }

}
