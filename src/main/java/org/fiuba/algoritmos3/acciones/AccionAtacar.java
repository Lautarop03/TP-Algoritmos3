package org.fiuba.algoritmos3.acciones;

import org.fiuba.algoritmos3.model.Juego;

public class AccionAtacar implements Accion {
    @Override
    public boolean realizarAccion(Juego juego) {
        return juego.atacar();
    }
}
