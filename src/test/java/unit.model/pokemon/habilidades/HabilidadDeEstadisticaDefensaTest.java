package unit.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeEstadisticaDefensa;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class HabilidadDeEstadisticaDefensaTest {
    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,200,0,100.0,0.0,null);
    private Pokemon pokemonEnemigo = new Pokemon("",0, Tipo.Electrico, "", 200,200,0,100.0,0.0,null);

    private HabilidadDeEstadisticaDefensa habilidadDeEstadisticaDefensaBuff = new HabilidadDeEstadisticaDefensa("Acorazado",1,Tipo.Electrico,50);
    private HabilidadDeEstadisticaDefensa habilidadDeEstadisticaDefensaNerf = new HabilidadDeEstadisticaDefensa("Acorazado",1,Tipo.Electrico,-50);


    @Test
    public void testUsarHabilidadDeEstadisticaDefensaEnSiMismoAFavor(){
        //Arrange
        Double defensaResultado = 150.0;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaDefensaBuff.usarHabilidad(pokemon,pokemon);

        //Assert
        assertEquals(pokemon.getDefensa(),defensaResultado);
        assertFalse(fueUsado);
    }
    @Test
    public void testUsarHabilidadDeEstadisticaDefensaEnSiMismoEnContra(){
        //Arrange
        Double defensaResultado = 50.0;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaDefensaNerf.usarHabilidad(pokemon,pokemon);

        //Assert
        assertEquals(pokemon.getDefensa(),defensaResultado);
        assertFalse(fueUsado);
    }

    @Test
    public void testUsarHabilidadDeEstadisticaDefensaEnPokemonEnemigoAFavor(){
        //Arrange
        Double defensaResultado = 150.0;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaDefensaBuff.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        assertEquals(pokemonEnemigo.getDefensa(),defensaResultado);
        assertFalse(fueUsado);
    }

    @Test
    public void testUsarHabilidadDeEstadisticaDefensaEnPokemonEnemigoEncContra(){
        //Arrange
        Double defensaResultado = 50.0;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaDefensaNerf.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        assertEquals(pokemonEnemigo.getDefensa(),defensaResultado);
        assertFalse(fueUsado);
    }

    @Test
    public void testUsarHabilidadDeEstadisticaDefensaCantidadDespuesDeUso(){
        //Arrange
        Integer resultado = habilidadDeEstadisticaDefensaBuff.getCantidadDeUsos();

        //Act
        Boolean fueUsado = habilidadDeEstadisticaDefensaBuff.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        assertSame(habilidadDeEstadisticaDefensaBuff.getCantidadDeUsos(),resultado-1);
        assertFalse(fueUsado);
    }

}

