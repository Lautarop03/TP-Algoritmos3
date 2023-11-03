package unit.model.pokemon.estados;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Confuso;
import org.fiuba.algoritmos3.model.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.model.pokemon.estados.Envenenado;
import org.fiuba.algoritmos3.model.pokemon.estados.Paralizado;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;


public class ParalizadoTest {

    private Pokemon pokemon = spy(new Pokemon("",0, Tipo.Electrico, "", 100,100,0,0.0,0.0,null));
    private Paralizado paralizado = new Paralizado();

    @Test
    public void testaAgregarEstadoParalizadoSinEstadosPrevios(){

        boolean aplicado = pokemon.setEstado(paralizado);
        assertTrue(aplicado);
    }
    @Test
    public void testAgregarEstadoParalizadoConEstadosSinParalizado(){
        //Arrange
        Dormido dormido = new Dormido();
        Envenenado envenenado = new Envenenado();
        Confuso confuso = new Confuso();
        pokemon.setEstado(dormido);
        pokemon.setEstado(envenenado);
        pokemon.setEstado(confuso);

        //Act
        boolean aplicado = pokemon.setEstado(paralizado);

        //Assert
        assertTrue(aplicado);
    }
    @Test
    public void testAgregarEstadoParalizadoConEstadosConParalizado(){
        //Arrange
        Dormido dormido = new Dormido();
        Envenenado envenenado = new Envenenado();
        Paralizado paralizado2 = new Paralizado();
        pokemon.setEstado(dormido);
        pokemon.setEstado(envenenado);
        pokemon.setEstado(paralizado2);

        //Act
        boolean aplicado = pokemon.setEstado(paralizado);

        //Assert
        assertFalse(aplicado);
    }
}
