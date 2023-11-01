package unit.model.habilidades;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeEstadisticaAtaque;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeEstadisticaVida;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class HabilidadDeEstadisticaVidaTest {
        private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0,null);
        private Pokemon pokemonEnemigo = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0,null);

        private HabilidadDeEstadisticaVida habilidadDeEstadisticaVida = new HabilidadDeEstadisticaVida("",1,Tipo.Electrico,50);


        @Test
        public void testUsarHabilidadDeEstadisticaVidaEnSiMismo(){
            //Arrange
            Integer vidaResultado = 150;

            //Act
            Boolean fueUsado = habilidadDeEstadisticaVida.usarHabilidad(pokemon,pokemon);

            //Assert
            assertEquals(pokemon.getVidaActual(),vidaResultado);
            assertFalse(fueUsado);

        }

        @Test
        public void testUsarHabilidadDeEstadisticaVidaEnPokemonEnemigo(){
            //Arrange
            Integer vidaResultado = 150;

            //Act
            Boolean fueUsado = habilidadDeEstadisticaVida.usarHabilidad(pokemon,pokemonEnemigo);

            //Assert
            assertEquals(pokemonEnemigo.getVidaActual(),vidaResultado);
            assertFalse(fueUsado);
        }

        @Test
        public void testUsarHabilidadDeEstadisticaVidaCantidadDespuesDeUso(){
            //Arrange
            Integer resultado = habilidadDeEstadisticaVida.getCantidadDeUsos();

            //Act
            Boolean fueUsado = habilidadDeEstadisticaVida.usarHabilidad(pokemon,pokemonEnemigo);

            //Assert
            assertSame(habilidadDeEstadisticaVida.getCantidadDeUsos(),resultado-1);
            assertFalse(fueUsado);
        }
}
