package unit.model.items;

import org.fiuba.algoritmos3.model.items.CuraTodo;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CuraTodoTest {

    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,200,0,0.0,100.0,null);
    private CuraTodo curaTodo = new CuraTodo(1);

    @Test
    public void testCuraTodoConUnEstado(){
        //Arrange
        Envenenado envenenado = new Envenenado();
        pokemon.setEstado(envenenado);
        List<Estado> vacio = new ArrayList<Estado>();

        //Act
        Boolean resultado  = curaTodo.aplicarItem(pokemon);

        //Assert
        assertEquals(pokemon.getEstados(),vacio);
        assertFalse(resultado);
    }

    @Test
    public void testCuraTodoConMuchosEstado(){
        //Arrange
        Envenenado envenenado = new Envenenado();
        Dormido dormindo = new Dormido();
        Paralizado paralizado = new Paralizado();
        Confuso confuso = new Confuso();
        pokemon.setEstado(envenenado);
        pokemon.setEstado(dormindo);
        pokemon.setEstado(paralizado);
        pokemon.setEstado(confuso);
        List<Estado> vacio = new ArrayList<Estado>();

        //Act
        Boolean resultado  = curaTodo.aplicarItem(pokemon);

        //Assert
        assertEquals(pokemon.getEstados(),vacio);
        assertFalse(resultado);

    }

    @Test
    public void testCuraTodoSinEstado(){

        //Act
        Boolean resultado = curaTodo.aplicarItem(pokemon);

        //Assert
        assertEquals(resultado, true);
    }

    @Test
    public void testCuraTodoCantidadDespuesDeUsoConEtado(){
        //Arrange
        Dormido dormindo = new Dormido();
        pokemon.setEstado(dormindo);
        Integer cantidadInicial = curaTodo.getCantidad();

        //Act
        curaTodo.aplicarItem(pokemon);
        System.out.println(curaTodo.getCantidad());

        //Assert
        assertEquals((int)curaTodo.getCantidad(),cantidadInicial-1);
    }

    @Test
    public void testCuraTodoSinEstadoCantidadDespuesDeUsoSinEstado(){

        //Act
        Boolean resultado = curaTodo.aplicarItem(pokemon);

        //Assert
        assertEquals(curaTodo.getCantidad(),curaTodo.getCantidad());

    }
}
