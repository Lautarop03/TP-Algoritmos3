package org.fiuba.algoritmos3.viewsJavaFX.habilidadViewJavaFX;

import org.fiuba.algoritmos3.model.pokemon.habilidades.*;

public class FactoryHabilidadViewJavaFX {

    public HabilidadViewJavaFX createHabilidadView(Habilidad habilidad) {
        if (habilidad.getClass() == HabilidadDeEstadisticaVida.class) {
            return new HabilidadDeEstadisticaVidaViewJavaFX();
        }
        if (habilidad.getClass() == HabilidadDeEstadisticaDefensa.class) {
            return new HabilidadDeEstadisticaDefensaViewJavaFX();
        }
        if (habilidad.getClass() == HabilidadDeEstadisticaAtaque.class) {
            return new HabilidadDeEstadisticaAtaqueViewJavaFX();
        }
        if (habilidad.getClass() == HabilidadDeEstado.class) {
            return new HabilidadDeEstadoViewJavaFX();
        }
        if (habilidad.getClass() == HabilidadDeClima.class) {
            return new HabilidadDeClimaViewJavaFX();
        }
        return new HabilidadDeDanoViewJavaFX();
    }
}
