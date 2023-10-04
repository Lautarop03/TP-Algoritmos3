package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeEstadisticaVida;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeEstadisticaDefensa;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeEstadisticaAtaque;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeEstado;

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
        return new HabilidadDeDanoView();
    }
}
