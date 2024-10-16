package org.fiuba.algoritmos3.views.habilidadView;

import org.fiuba.algoritmos3.model.pokemon.habilidades.*;

public class FactoryHabilidadView {

    public HabilidadView createHabilidadView(Habilidad habilidad) {
        if (habilidad.getClass() == HabilidadDeEstadisticaVida.class) {
            return new HabilidadDeEstadisticaVidaView();
        }
        if (habilidad.getClass() == HabilidadDeEstadisticaDefensa.class) {
            return new HabilidadDeEstadisticaDefensaView();
        }
        if (habilidad.getClass() == HabilidadDeEstadisticaAtaque.class) {
            return new HabilidadDeEstadisticaAtaqueView();
        }
        if (habilidad.getClass() == HabilidadDeEstado.class) {
            return new HabilidadDeEstadoView();
        }
        if (habilidad.getClass() == HabilidadDeClima.class) {
            return new HabilidadDeClimaView();
        }
        return new HabilidadDeDanoView();
    }
}
