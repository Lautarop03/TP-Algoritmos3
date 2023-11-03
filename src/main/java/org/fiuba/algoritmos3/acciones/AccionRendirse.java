package org.fiuba.algoritmos3.acciones;

import org.fiuba.algoritmos3.model.Juego;

public class AccionRendirse implements Accion {

    @Override
    public boolean realizarAccion(Juego juego) {
        return juego.rendirse();
    }
}
