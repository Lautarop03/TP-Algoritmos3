package unit.model.items;

import org.fiuba.algoritmos3.model.items.ItemModificadorDefensa;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ItemDeDefensaTest {

    private ItemModificadorDefensa itemModificadorDefensa = new ItemModificadorDefensa(1);
    private Pokemon pokemon = spy(new Pokemon("",0, Tipo.Electrico, "", 100,100,0,0.0,0.0,null));

    @Test
    public void testModificarDefensaPokemonVivo() {
        //Arrange
        pokemon.setDefensa(100.0);
        double nuevaDefensa = 110.0;

        //Act
        Boolean resultado = itemModificadorDefensa.aplicarItem(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertTrue(nuevaDefensa == pokemon.getDefensa());
    }

    @Test
    public void testModificarDefensaPokemonMuerto() {
        //Arrange
        pokemon.setDefensa(100.0);
        double nuevaDefensa = 110.0;
        pokemon.setVidaActual(0);

        //Act
        Boolean resultado = itemModificadorDefensa.aplicarItem(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertTrue(nuevaDefensa == pokemon.getDefensa());
    }

    @Test
    public void testItemDeDefensaCantidadDespuesDeUso() {
        //Arrange
        pokemon.setDefensa(100.0);

        //Act
        Boolean resultado = itemModificadorDefensa.aplicarItem(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertTrue(itemModificadorDefensa.getCantidad() == 0);
    }
}
