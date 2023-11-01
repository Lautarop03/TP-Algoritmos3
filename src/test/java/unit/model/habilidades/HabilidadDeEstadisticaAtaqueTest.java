package unit.model.habilidades;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeEstadisticaAtaque;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeEstadisticaDefensa;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class HabilidadDeEstadisticaAtaqueTest {
    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,200,0,0.0,100.0,null);
    private Pokemon pokemonEnemigo = new Pokemon("",0, Tipo.Electrico, "", 200,200,0,0.0,100.0,null);

    private HabilidadDeEstadisticaAtaque habilidadDeEstadisticaAtaque = new HabilidadDeEstadisticaAtaque("",1,Tipo.Electrico,50);


    @Test
    public void testUsarHabilidadDeEstadisticaAtaqueEnSiMismo(){
        //Arrange
        Double ataqueResultado = 150.0;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaAtaque.usarHabilidad(pokemon,pokemon);

        //Assert
        assertEquals(pokemon.getAtaque(),ataqueResultado);
        assertFalse(fueUsado);

    }

    @Test
    public void testUsarHabilidadDeEstadisticaAtaqueEnPokemonEnemigo(){
        //Arrange
        Double ataqueResultado = 150.0;

        //Act
        Boolean fueUsado = habilidadDeEstadisticaAtaque.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        assertEquals(pokemonEnemigo.getAtaque(),ataqueResultado);
        assertFalse(fueUsado);
    }

    @Test
    public void testUsarHabilidadDeEstadisticaAtaqueCantidadDespuesDeUso(){
        //Arrange
        Integer resultado = habilidadDeEstadisticaAtaque.getCantidadDeUsos();

        //Act
        Boolean fueUsado = habilidadDeEstadisticaAtaque.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        assertSame(habilidadDeEstadisticaAtaque.getCantidadDeUsos(),resultado-1);
        assertFalse(fueUsado);
    }
}
