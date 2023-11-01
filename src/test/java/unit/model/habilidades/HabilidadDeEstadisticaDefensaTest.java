package unit.model.habilidades;

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

    private HabilidadDeEstadisticaDefensa habilidadDeEstadisticaDefensa = new HabilidadDeEstadisticaDefensa("Acorazado",1,Tipo.Electrico,50);


    @Test
    public void testUsarHabilidadDeEstadisticaDefensaEnSiMismo(){
        //Arrange
        Double defensaResultado = 150.0;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaDefensa.usarHabilidad(pokemon,pokemon);

        //Assert
        assertEquals(pokemon.getDefensa(),defensaResultado);
        assertFalse(fueUsado);
    }

    @Test
    public void testUsarHabilidadDeEstadisticaDefensaEnPokemonEnemigo(){
        //Arrange
        Double defensaResultado = 150.0;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaDefensa.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        assertEquals(pokemonEnemigo.getDefensa(),defensaResultado);
        assertFalse(fueUsado);
    }

    @Test
    public void testUsarHabilidadDeEstadisticaDefensaCantidadDespuesDeUso(){
        //Arrange
        Integer resultado = habilidadDeEstadisticaDefensa.getCantidadDeUsos();

        //Act
        Boolean fueUsado = habilidadDeEstadisticaDefensa.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        assertSame(habilidadDeEstadisticaDefensa.getCantidadDeUsos(),resultado-1);
        assertFalse(fueUsado);
    }
}

