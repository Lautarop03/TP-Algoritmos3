package integration.model;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Confuso;
import org.fiuba.algoritmos3.model.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.model.pokemon.estados.Paralizado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonEstadoItemTest {

    @Test
    public void testEstadosAplicadosPokemon() {
        //Arrange
        Random random = mock(Random.class);
//        when(random.Random()).thenReturn(r);
        List<Habilidad> habilidades = List.of(mock(Habilidad.class));
        Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0,habilidades);
        pokemon.setEstado(new Paralizado());
        pokemon.setEstado(new Confuso());

        //Act
        List<Boolean> resultado = pokemon.aplicarEstados();

        //Assert
        assertEquals(List.of(true, true), resultado);
    }
}
