package unit.model.items;

import org.fiuba.algoritmos3.model.items.ItemModificadorAtaque;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ItemDeAtaqueTest {

    private ItemModificadorAtaque itemModificadorAtaque = new ItemModificadorAtaque(1);
    private Pokemon pokemon = spy(new Pokemon("",0, Tipo.Electrico, "", 100,100,0,0.0,0.0,null));

    @Test
    public void testModificarAtaquePokemonVivo() {
        //Arrange
        pokemon.setAtaque(100.0);
        double nuevoAtaque = 110.0;

        //Act
        Boolean resultado = itemModificadorAtaque.aplicarItem(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertTrue(nuevoAtaque == pokemon.getAtaque());
    }

    @Test
    public void testModificarAtaquePokemonMuerto() {
        //Arrange
        pokemon.setAtaque(100.0);
        double nuevoAtaque = 110.0;
        pokemon.setVidaActual(0);

        //Act
        Boolean resultado = itemModificadorAtaque.aplicarItem(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertTrue(nuevoAtaque == pokemon.getAtaque());
    }

    @Test
    public void testItemDeAtaqueCantidadDespuesDeUso() {
        //Arrange
        pokemon.setAtaque(100.0);

        //Act
        Boolean resultado = itemModificadorAtaque.aplicarItem(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertTrue(itemModificadorAtaque.getCantidad() == 0);
    }
}
