package unit.model.items;

import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ItemsRestauradoresDeVidaTest {

    private Pokemon pokemon;
    private Item item;

    public ItemsRestauradoresDeVidaTest(Item itemRestauradorDeVida, Pokemon pokemon) {
        this.pokemon = spy(pokemon);
        this.item = itemRestauradorDeVida;
    }

    @Test
    public void TestAplicarPocionConVidaBaja(Integer vidaActual, Integer vidaFinal) {
        //Arrange
        pokemon.setVidaActual(vidaActual);

        //Act
        Boolean fueAplicado = item.aplicarItem(pokemon);

        //Assert
        assertEquals(vidaFinal, pokemon.getVidaActual());
        assertEquals(false, fueAplicado);
    }

    @Test
    public void TestAplicarPocionConVidaAlta(Integer vidaActual) {
        //Arrange
        pokemon.setVidaActual(vidaActual);

        //Act
        Boolean fueAplicado = item.aplicarItem(pokemon);

        //Assert
        assertEquals(pokemon.getVidaMaxima(), pokemon.getVidaActual());
        assertEquals(false, fueAplicado);
    }

    @Test
    public void TestAplicarPocionConVidaMaxima() {
        //Arrange
        when(pokemon.estaMuerto()).thenReturn(false);
        when(pokemon.tieneVidaLlena()).thenReturn(true);

        //Act
        Boolean fueAplicado = item.aplicarItem(pokemon);

        //Assert
        assertEquals(pokemon.getVidaMaxima(),pokemon.getVidaActual());
        assertEquals(true, fueAplicado);
    }

    @Test
    public void TestAplicarPocionConVidaNula() {
        //Arrange
        when(pokemon.estaMuerto()).thenReturn(true);
        when(pokemon.tieneVidaLlena()).thenReturn(false);
        pokemon.setVidaActual(0);

        //Act
        Boolean fueAplicado = item.aplicarItem(pokemon);

        //Assert
        assertEquals((Integer)0,pokemon.getVidaActual());
        assertEquals(true, fueAplicado);
    }
}
