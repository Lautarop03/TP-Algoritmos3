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

    private HabilidadDeEstadisticaVida habilidadDeEstadisticaVidaBuff = new HabilidadDeEstadisticaVida("",1,Tipo.Electrico,50);
    private HabilidadDeEstadisticaVida habilidadDeEstadisticaVidaNerf = new HabilidadDeEstadisticaVida("",1,Tipo.Electrico,-50);


    @Test
    public void testUsarHabilidadDeEstadisticaVidaEnSiMismoAFavor(){
        //Arrange
        Integer vidaResultado = 150;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaVidaBuff.usarHabilidad(pokemon,pokemon);

        //Assert
        assertEquals(pokemon.getVidaActual(),vidaResultado);
        assertFalse(fueUsado);

    }
    @Test
    public void testUsarHabilidadDeEstadisticaVidaEnSiMismoEnContra(){
        //Arrange
        Integer vidaResultado = 50;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaVidaNerf.usarHabilidad(pokemon,pokemon);

        //Assert
        assertEquals(pokemon.getVidaActual(),vidaResultado);
        assertFalse(fueUsado);
    }

    @Test
    public void testUsarHabilidadDeEstadisticaVidaEnPokemonEnemigoAFavor(){
        //Arrange
        Integer vidaResultado = 150;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaVidaBuff.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        assertEquals(pokemonEnemigo.getVidaActual(),vidaResultado);
        assertFalse(fueUsado);
    }

    @Test
    public void testUsarHabilidadDeEstadisticaVidaEnPokemonEnemigoEnContra(){
        //Arrange
        Integer vidaResultado = 50;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaVidaNerf.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        assertEquals(pokemonEnemigo.getVidaActual(),vidaResultado);
        assertFalse(fueUsado);
    }

    @Test
    public void testUsarHabilidadDeEstadisticaVidaCantidadDespuesDeUso(){
        //Arrange
        Integer resultado = habilidadDeEstadisticaVidaBuff.getCantidadDeUsos();

        //Act
        Boolean fueUsado = habilidadDeEstadisticaVidaBuff.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        assertSame(habilidadDeEstadisticaVidaBuff.getCantidadDeUsos(),resultado-1);
        assertFalse(fueUsado);
    }
}
