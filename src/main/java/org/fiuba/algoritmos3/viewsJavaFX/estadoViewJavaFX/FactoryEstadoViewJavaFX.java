package org.fiuba.algoritmos3.viewsJavaFX.estadoViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.estados.*;

public class FactoryEstadoViewJavaFX {

    public EstadoViewJavaFX createEstadoView(Estado estado) {
        if (estado.getClass() == Dormido.class) {
            return new EstadoDormidoViewJavaFX();
        }
        if (estado.getClass() == Envenenado.class) {
            return new EstadoEnvenenadoViewJavaFX();
        }
        return new EstadoParalizadoViewJavaFX();
    }
}
