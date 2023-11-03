package unit.model.pokemon;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.model.pokemon.estados.Envenenado;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PokemonTest {

    private List<Habilidad> habilidades = List.of(mock(Habilidad.class));
    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0,habilidades);

    @Test
    public void testPokemonGetters() {
        //Arange
        String nombre = "Carlos";
        Integer nivel = 8;
        Tipo tipo = Tipo.Planta;
        String historia = "Es Carlos.";
        Integer vidaMaxima = 80;
        Integer vidaActual = 40;
        Integer velocidad = 100;
        Double defensa = 50.0;
        Double ataque = 60.0;
        List<Habilidad> habilidades = List.of(mock(Habilidad.class));

        //Act
        pokemon = new Pokemon(nombre,nivel,tipo,historia,vidaMaxima,vidaActual,velocidad,defensa,ataque,habilidades);

        //Assert
        assertEquals(nombre, pokemon.getNombre());
        assertEquals(nivel, pokemon.getNivel());
        assertEquals(tipo, pokemon.getTipo());
        assertEquals(vidaMaxima, pokemon.getVidaMaxima());
        assertEquals(vidaActual, pokemon.getVidaActual());
        assertEquals(velocidad, pokemon.getVelocidad());
        assertEquals(defensa, pokemon.getDefensa());
        assertEquals(ataque, pokemon.getAtaque());
        assertEquals(habilidades, pokemon.getHabilidades());
    }

    @Test
    public void testPokemonConVidaVaciaEstaMuertoYNoEstaVivo() {
        //Arrange & Act
        pokemon.setVidaActual(0);

        //Assert
        assertTrue(pokemon.estaMuerto());
        assertFalse(pokemon.estaVivo());
    }

    @Test
    public void testPokemonConVidaNoEstaMuertoYEstaVivo() {
        //Arrange & Act
        pokemon.setVidaActual(100);

        //Assert
        assertFalse(pokemon.estaMuerto());
        assertTrue(pokemon.estaVivo());
    }

    @Test
    public void testPokemonSumarVida() {
        //Arrange
        Integer vidaASumar = 50;
        Integer vidaResultado = 150;

        //Act
        pokemon.sumarVida(vidaASumar);

        //Assert
        assertEquals(vidaResultado, pokemon.getVidaActual());
    }

    @Test
    public void testPokemonSumarVidaConVidaLlena() {
        //Arrange
        Integer vidaMaxima = pokemon.getVidaMaxima();
        pokemon.setVidaActual(vidaMaxima);
        Integer vidaASumar = 50;

        //Act
        pokemon.sumarVida(vidaASumar);

        //Assert
        assertSame(vidaMaxima, pokemon.getVidaActual());
    }

    @Test
    public void testPokemonSumarVidaConVidaVacia() {
        //Arrange
        pokemon.setVidaActual(0);
        Integer vidaASumar = 50;
        Integer vidaResultado = 50;

        //Act
        pokemon.sumarVida(vidaASumar);

        //Assert
        assertSame(vidaResultado, pokemon.getVidaActual());
    }

    @Test
    public void testPokemonBajarVida() {
        //Arrange
        Integer vidaABajar = 50;
        Integer vidaResultado = 50;

        //Act
        pokemon.bajarVida(vidaABajar);

        //Assert
        assertSame(vidaResultado, pokemon.getVidaActual());
    }

    @Test
    public void testPokemonBajarVidaConVidaLlena() {
        //Arrange
        pokemon.setVidaActual(pokemon.getVidaMaxima());
        Integer vidaABajar = 50;
        Integer vidaResultado = 150;

        //Act
        pokemon.bajarVida(vidaABajar);

        //Assert
        assertEquals(vidaResultado, pokemon.getVidaActual());
    }

    @Test
    public void testPokemonBajarVidaConVidaVacia() {
        //Arrange
        pokemon.setVidaActual(0);
        Integer vidaABajar = 50;
        Integer vidaResultado = 0;

        //Act
        pokemon.bajarVida(vidaABajar);

        //Assert
        assertSame(vidaResultado, pokemon.getVidaActual());
    }

    @Test
    public void testPokemonSetEstado() {
        //Arrange
        pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0, habilidades);
        Envenenado envenenado = mock(Envenenado.class);

        //Act
        pokemon.setEstado(envenenado);

        //Arrange
        assertEquals(List.of(envenenado), pokemon.getEstados());
    }

    @Test
    public void testPokemonQuitarEstado() {
        //Arrange
        pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0, habilidades);
        Envenenado envenenado = mock(Envenenado.class);
        Dormido dormido = mock(Dormido.class);
        pokemon.setEstado(envenenado);
        pokemon.setEstado(dormido);

        //Act
        pokemon.quitarEstado(envenenado);

        //Arrange
        assertEquals(List.of(dormido), pokemon.getEstados());
    }

    @Test
    public void testPokemonQuitarEstados() {
        //Arrange
        pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,100,0,0.0,100.0, habilidades);
        Envenenado envenenado = mock(Envenenado.class);
        Dormido dormido = mock(Dormido.class);
        pokemon.setEstado(envenenado);
        pokemon.setEstado(dormido);

        //Act
        pokemon.quitarEstados();

        //Arrange
        assertEquals(List.of(), pokemon.getEstados());
    }
}
