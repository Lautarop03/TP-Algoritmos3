package unit.model.pokemon.estados;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;



public class ConfusoTest {

    private Pokemon pokemon = (new Pokemon("",0, Tipo.Electrico, "", 100,100,0,0.0,0.0,null));
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

    @Test
    public void testAplicarEstadoConfusoSeCuraAutomaticamenteCon3Turnos() {
        pokemon.setEstado(confuso);

        //Luego de 3 veces aplicado el estado, se va automaticamente
        pokemon.aplicarEstados();
        pokemon.aplicarEstados();
        pokemon.aplicarEstados();


        List<Estado> estados = pokemon.getEstados();

        assertEquals(estados,new ArrayList<Estado>());
    }


}
