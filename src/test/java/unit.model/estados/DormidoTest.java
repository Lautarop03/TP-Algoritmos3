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


public class DormidoTest {

    private Pokemon pokemon = spy(new Pokemon("",0, Tipo.Electrico, "", 100,100,0,0.0,0.0,null));
    private Dormido dormido = new Dormido();

    @Test
    public void testAgregarEstadoDormidoSinEstadosPrevios(){

        boolean agregado = pokemon.setEstado(dormido);
        assertTrue(agregado);
    }
    @Test
    public void testAgregarEstadoDormidoConEstadosSinDormido(){
        //Arrange
        Paralizado paralizado = new Paralizado();
        Envenenado envenenado = new Envenenado();
        Confuso confuso = new Confuso();
        pokemon.setEstado(paralizado);
        pokemon.setEstado(envenenado);
        pokemon.setEstado(confuso);

        //Act
        boolean agregado = pokemon.setEstado(dormido);

        //Assert
        assertTrue(agregado);
    }
    @Test
    public void testAgregarEstadoDormidoConEstadosConDormido(){
        //Arrange
        Paralizado paralizado = new Paralizado();
        Envenenado envenenado = new Envenenado();
        Dormido dormido2 = new Dormido();
        pokemon.setEstado(paralizado);
        pokemon.setEstado(envenenado);
        pokemon.setEstado(dormido2);

        //Act
        boolean agregado = pokemon.setEstado(dormido);

        //Assert
        assertFalse(agregado);
    }
}
