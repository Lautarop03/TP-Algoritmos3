package integration.model;

import org.fiuba.algoritmos3.model.items.CuraTodo;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Confuso;
import org.fiuba.algoritmos3.model.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.model.pokemon.estados.Envenenado;
import org.fiuba.algoritmos3.model.pokemon.estados.Paralizado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonEstadoItemTest {

    @Test
    public void testEstadosAplicadosPokemon() {
        //Arrange
        Random random = mock(Random.class);
        when(random.nextDouble()).thenReturn(0.0);

        List<Habilidad> habilidades = List.of(mock(Habilidad.class));
        Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0,habilidades);

        Confuso confuso = new Confuso();
        Paralizado paralizado = new Paralizado();
        pokemon.setEstado(paralizado);
        pokemon.setEstado(confuso);
        confuso.setRandom(random);
        paralizado.setRandom(random);
        Integer vidaDespuesDeConfuso = pokemon.getVidaActual() - pokemon.getVidaMaxima()*15/100;

        //Act
        List<Boolean> resultado = pokemon.aplicarEstados();

        //Assert
        assertEquals(List.of(true, true), resultado);
        assertEquals(vidaDespuesDeConfuso, pokemon.getVidaActual());
    }

    @Test
    public void testEstadosNoAplicadosPokemon() {
        //Arrange
        Random random = mock(Random.class);
        when(random.nextDouble()).thenReturn(0.6);

        List<Habilidad> habilidades = List.of(mock(Habilidad.class));
        Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0,habilidades);

        Confuso confuso = new Confuso();
        Paralizado paralizado = new Paralizado();
        pokemon.setEstado(paralizado);
        pokemon.setEstado(confuso);
        confuso.setRandom(random);
        paralizado.setRandom(random);
        Integer vidaDespuesDeConfuso = pokemon.getVidaActual();

        //Act
        List<Boolean> resultado = pokemon.aplicarEstados();

        //Assert
        assertEquals(List.of(false, true), resultado);
        assertEquals(vidaDespuesDeConfuso, pokemon.getVidaActual());
    }

    @Test
    public void testEstadosTerminarEfectoPokemon() {
        //Arrange
        Random random = mock(Random.class);
        when(random.nextDouble()).thenReturn(1.0);

        List<Habilidad> habilidades = List.of(mock(Habilidad.class));
        Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0,habilidades);

        Confuso confuso = new Confuso();
        pokemon.setEstado(confuso);
        confuso.setRandom(random);
        Integer vidaDespuesDeConfuso = pokemon.getVidaActual();

        //Act & Assert
        for (int i = 0;i < 2; i++ ) {
            List<Boolean> resultadoConfuso = pokemon.aplicarEstados();
            assertEquals(List.of(true), resultadoConfuso);
            assertEquals(vidaDespuesDeConfuso, pokemon.getVidaActual());
        }
        List<Boolean> resultado = pokemon.aplicarEstados();
        assertEquals(List.of(false), resultado);
        assertEquals(List.of(), pokemon.getEstados());

        //Arrange
        Dormido dormido = new Dormido();
        pokemon.setEstado(dormido);
        dormido.setRandom(random);

        //Act & Assert
        for (int i = 0;i < 3; i++ ) {
            List<Boolean> resultadoDormido = pokemon.aplicarEstados();
            assertEquals(List.of(true), resultadoDormido);
        }
        List<Boolean> resultadoDormido = pokemon.aplicarEstados();
        assertEquals(List.of(false), resultadoDormido);
        assertEquals(List.of(), pokemon.getEstados());
    }

    @Test
    public void testEstadosConCuraTodo() {
        //Arrange
        List<Habilidad> habilidades = List.of(mock(Habilidad.class));
        Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0,habilidades);
        CuraTodo curaTodo = new CuraTodo(1);

        Confuso confuso = new Confuso();
        Paralizado paralizado = new Paralizado();
        pokemon.setEstado(paralizado);
        pokemon.setEstado(confuso);

        //Act & Assert
        assertEquals(List.of(paralizado, confuso), pokemon.getEstados());
        Boolean aplicado = curaTodo.aplicarItem(pokemon);
        assertEquals(List.of(), pokemon.getEstados());
        assertFalse(aplicado);
    }

    @Test
    public void testEstadosPermanetesEnvenenado() {
        //Arrange
        List<Habilidad> habilidades = List.of(mock(Habilidad.class));
        Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,200,0,0.0,100.0,habilidades);

        Envenenado envenenado = new Envenenado();
        pokemon.setEstado(envenenado);

        //Act & Assert
        Double porcentajeDeDanio = pokemon.getVidaMaxima() * 0.05;
        for (int i = 1;i <= 20; i++ ) {
            List<Boolean> resultadoEnvenenado = pokemon.aplicarEstados();
            assertEquals(List.of(false), resultadoEnvenenado);
            double vidaDespuesDeEnvanamiento = pokemon.getVidaMaxima() - porcentajeDeDanio * i;
            assertTrue(vidaDespuesDeEnvanamiento == pokemon.getVidaActual());
        }
        List<Boolean> resultado = pokemon.aplicarEstados();
        assertEquals(List.of(), resultado);
        assertEquals(List.of(), pokemon.getEstados());
        assertTrue(pokemon.estaMuerto());
    }

    @Test
    public void testEstadosPermanetesParalizado() {
        //Arrange
        Random random = mock(Random.class);
        when(random.nextDouble()).thenReturn(1.0);

        List<Habilidad> habilidades = List.of(mock(Habilidad.class));
        Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,200,0,0.0,100.0,habilidades);

        Paralizado paralizado = new Paralizado();
        paralizado.setRandom(random);
        pokemon.setEstado(paralizado);

        //Act & Assert
        for (int i = 0; i < 5000; i++ ) {
            List<Boolean> resultado = pokemon.aplicarEstados();
            assertEquals(List.of(false), resultado);
        }
        assertEquals(List.of(paralizado), pokemon.getEstados());
    }
}
