package unit.model.habilidades;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeDano;
import org.junit.Test;

import static org.junit.Assert.*;

public class HabilidadDeDanoTest {
    private Pokemon pokemonEnemigo = new Pokemon("Charizard",20, Tipo.Fuego, "asd", 78,78,100,78.0,84.0, null);
    private Pokemon pokemon = new Pokemon("Pikachu",15, Tipo.Electrico, "asd", 35,35,90,40.0,55.0, null);
    private HabilidadDeDano habilidad = new HabilidadDeDano("",1,Tipo.Agua,70);

    @Test
    public void testUsarHabilidadDeDanoReduceVidaEnemigo(){
        //Arrange
        Integer vidaEnemigo = pokemonEnemigo.getVidaActual();

        //Act
        habilidad.usarHabilidad(pokemon,pokemonEnemigo);
        Integer vidaEnemigoDespues = pokemonEnemigo.getVidaActual();

        //Assert
        assertNotEquals(vidaEnemigo,vidaEnemigoDespues);
        assertTrue(vidaEnemigo>vidaEnemigoDespues);
    }

    @Test
    public void testUsarHabilidadDeDanoReduceCantidadDeUsos(){
        //Arrange
        int usos = habilidad.getCantidadDeUsos();

        //Act
        habilidad.usarHabilidad(pokemon,pokemonEnemigo);
        habilidad.usarHabilidad(pokemon,pokemonEnemigo);

        int usosDespues = habilidad.getCantidadDeUsos();

        //Assert
        assertEquals(usos,usosDespues+2);
    }
}


