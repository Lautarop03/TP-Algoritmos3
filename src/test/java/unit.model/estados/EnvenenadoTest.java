package unit.model.estados;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;


public class EnvenenadoTest {
//spy
    private Pokemon pokemon = (new Pokemon("",0, Tipo.Electrico, "", 100,100,0,0.0,0.0,null));
    private Envenenado envenenado = new Envenenado();

    @Test
    public void testAgregarEstadoEnvenenadoSinEstadosPrevios(){

        boolean agregado = pokemon.setEstado(envenenado);
        assertTrue(agregado);
    }
    @Test
    public void testAgregarEstadoEnvenenadoConEstadosSinEnvenenado(){
        //Arrange
        Paralizado paralizado = new Paralizado();
        Dormido dormido = new Dormido();
        Confuso confuso = new Confuso();
        pokemon.setEstado(paralizado);
        pokemon.setEstado(dormido);
        pokemon.setEstado(confuso);

        //Act
        boolean agregado = pokemon.setEstado(envenenado);

        //Assert
        assertTrue(agregado);
    }
    @Test
    public void testAgregarEstadoEnvenenadoConEstadosConEnvenenado(){
        //Arrange
        Paralizado paralizado = new Paralizado();
        Envenenado envenenado = new Envenenado();
        Envenenado envenenado2 = new Envenenado();
        pokemon.setEstado(paralizado);
        pokemon.setEstado(envenenado);
        pokemon.setEstado(envenenado2);

        //Act
        boolean agregado = pokemon.setEstado(envenenado);

        //Assert
        assertFalse(agregado);
    }

    @Test
    public void testAplicarEnvenenadoConVidaMaxima(){
        //Arrange
        pokemon.setEstado(envenenado);
        Integer vida = pokemon.getVidaActual();
        Integer vidaMaxima = pokemon.getVidaMaxima();

        //Act
        pokemon.aplicarEstados();
        Integer nuevaVida = (int)(vida - vidaMaxima * 0.05);

        //Assert
        assertEquals(nuevaVida, pokemon.getVidaActual());
    }

    @Test
    public void testAplicarEnvenenadoPokemonCasiMuerto(){
        pokemon.setVidaActual(3);
        pokemon.setEstado(envenenado);
        Integer nuevaVida = 0;

        pokemon.aplicarEstados();

        assertEquals(nuevaVida, pokemon.getVidaActual());
    }

    @Test
    public void testAplicarEnvenenadoMultiplesVeces(){
        pokemon.setEstado(envenenado);
        Integer nuevaVida = 75;

        for(int i = 1; i<=5; i++){
            pokemon.aplicarEstados();
        }

        assertEquals(nuevaVida, pokemon.getVidaActual());
    }

    @Test
    public void testDevolucionAplicarEnvenenadoPokemonCasiMuerto(){
        pokemon.setVidaActual(5);
        pokemon.setEstado(envenenado);

        boolean aplicado = pokemon.aplicarEstados().get(0);

        assertFalse(aplicado);
    }

    @Test
    public void testEstadoEnPokemonMuerto(){
        pokemon.setEstado(envenenado);
        pokemon.bajarVida(pokemon.getVidaMaxima());

        List<Estado> estado = pokemon.getEstados();

        assertTrue(estado.isEmpty());
    }
}
