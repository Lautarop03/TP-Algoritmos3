package unit.model.estados;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Confuso;
import org.fiuba.algoritmos3.model.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.model.pokemon.estados.Envenenado;
import org.fiuba.algoritmos3.model.pokemon.estados.Paralizado;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;


public class ConfusoTest {

    private Pokemon pokemon = spy(new Pokemon("",0, Tipo.Electrico, "", 100,100,0,0.0,0.0,null));
    private Confuso confuso = new Confuso();

    @Test
    public void testAgregarEstadoConfusoSinEstadosPrevios(){

        boolean agregado = pokemon.setEstado(confuso);
        assertTrue(agregado);
    }
    @Test
    public void testAgregarEstadoConfusoConEstadosSinConfuso(){
        //Arrange
        Paralizado paralizado = new Paralizado();
        Envenenado envenenado = new Envenenado();
        Dormido dormido = new Dormido();
        pokemon.setEstado(paralizado);
        pokemon.setEstado(envenenado);
        pokemon.setEstado(dormido);

        //Act
        boolean agregado = pokemon.setEstado(confuso);

        //Assert
        assertTrue(agregado);
    }
    @Test
    public void testAgregarEstadoConfusoConEstadosConConfuso(){
        //Arrange
        Paralizado paralizado = new Paralizado();
        Envenenado envenenado = new Envenenado();
        Confuso confuso2 = new Confuso();
        pokemon.setEstado(paralizado);
        pokemon.setEstado(envenenado);
        pokemon.setEstado(confuso2);

        //Act
        boolean agregado = pokemon.setEstado(confuso);

        //Assert
        assertFalse(agregado);
    }
}
