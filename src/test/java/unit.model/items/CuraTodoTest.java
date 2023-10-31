package unit.model.items;

import org.fiuba.algoritmos3.model.items.CuraTodo;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.model.pokemon.estados.Envenenado;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CuraTodoTest {

    private Pokemon pokemon = mock(Pokemon.class);
    private CuraTodo curaTodo = new CuraTodo(1);

    @Test
    public void testCuraTodoConUnEstado(){
        //Arrange
//        ArrayList<Estado> l = new ArrayList<Estado>();
//        l.add(new Envenenado());
//        when(pokemon.getEstado()).thenReturn(l);
//
//        //Act
//        Boolean resultado  = curaTodo.aplicarItem(pokemon);
//
//        //Assert
//        assertEquals(pokemon.getEstado().isEmpty());
    }

    @Test
    public void testCuraTodoConMuchosEstado(){
        //Arrange
//        ArrayList<Estado> l = new ArrayList<Estado>();
//        l.add(new Envenenado());
//        l.add(new Dormido());
//        when(pokemon.getEstado()).thenReturn(l);
//
//        //Act
//        Boolean resultado  = curaTodo.aplicarItem(pokemon);
//
//        //Assert
//        assertEquals(pokemon.getEstado().isEmpty());
    }

    @Test
    public void testCuraTodoSinEstado(){
        //Arrange
        when(pokemon.getEstado()).thenReturn(null);
        //Act
        Boolean resultado = curaTodo.aplicarItem(pokemon);

        //Assert
        assertEquals(resultado, true);
    }

}
