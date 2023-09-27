package org.fiuba.algoritmos3.pokemon.habilidades;

import org.fiuba.algoritmos3.ModificacionVida;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.Tipo;

public class HabilidadDeEstadisticaVida extends HabilidadDeEstadistica implements ModificacionVida {
    public HabilidadDeEstadisticaVida(String nombre, Integer cantidadDeUsos, Tipo tipo, Integer porcentajeDeModificacion) {
        super(nombre, cantidadDeUsos, tipo, porcentajeDeModificacion);
    }
    public void actualizarVida(Pokemon pokemon){
        double vidaActual = pokemon.getVidaActual();
        double nuevaVida = vidaActual + (vidaActual/100) * this.porcentajeDeModificacion;
        modificarVida(pokemon,(int)nuevaVida);
    }

    public void modificarVida(Pokemon pokemon, Integer nuevaVida) {
        if (nuevaVida <= pokemon.getVidaMaxima()){
            pokemon.setVidaActual(nuevaVida);
        }else{
            pokemon.setVidaActual(pokemon.getVidaMaxima());
        }
    }
}
