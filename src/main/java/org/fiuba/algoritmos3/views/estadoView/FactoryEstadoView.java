package org.fiuba.algoritmos3.views.estadoView;

import org.fiuba.algoritmos3.model.pokemon.estados.*;

public class FactoryEstadoView {

    public EstadoView createEstadoView(Estado estado) {
        if (estado.getClass() == Dormido.class) {
            return new EstadoDormidoView();
        }
        if (estado.getClass() == Envenenado.class) {
            return new EstadoDormidoView();
        }
        return new EstadoParalizadoView();
    }
}
