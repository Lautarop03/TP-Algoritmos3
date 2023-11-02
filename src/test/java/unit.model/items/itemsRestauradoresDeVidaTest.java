package unit.model.items;

import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class itemsRestauradoresDeVidaTest {

    private Pokemon pokemon;
    private Item item;

    public itemsRestauradoresDeVidaTest(Item itemRestauradorDeVida, Pokemon pokemon) {
        this.pokemon = spy(pokemon);
        this.item = itemRestauradorDeVida;
    }

    @Test
    public void testAplicarItemConVidaBaja(Integer vidaActual, Integer vidaFinal) {
        //Arrange
        pokemon.setVidaActual(vidaActual);

        //Act
        Boolean fueAplicado = item.aplicarItem(pokemon);

        //Assert
        assertEquals(vidaFinal, pokemon.getVidaActual());
        assertFalse(fueAplicado);
    }

    @Test
    public void testAplicarItemConVidaAlta(Integer vidaActual) {
        //Arrange
        pokemon.setVidaActual(vidaActual);

        //Act
        Boolean fueAplicado = item.aplicarItem(pokemon);

        //Assert
        assertEquals(pokemon.getVidaMaxima(), pokemon.getVidaActual());
        assertFalse(fueAplicado);
    }

    @Test
    public void testAplicarItemConVidaMaxima() {
        //Arrange
        when(pokemon.estaMuerto()).thenReturn(false);
        when(pokemon.tieneVidaLlena()).thenReturn(true);

        //Act
        Boolean fueAplicado = item.aplicarItem(pokemon);

        //Assert
        assertEquals(pokemon.getVidaMaxima(),pokemon.getVidaActual());
        assertTrue(fueAplicado);
    }

    @Test
    public void testAplicarItemConVidaNula() {
        //Arrange
        when(pokemon.estaMuerto()).thenReturn(true);
        when(pokemon.tieneVidaLlena()).thenReturn(false);
        pokemon.setVidaActual(0);

        //Act
        Boolean fueAplicado = item.aplicarItem(pokemon);

        //Assert
        assertEquals((Integer)0,pokemon.getVidaActual());
        assertTrue(fueAplicado);
    }

    @Test
    public void testItemCantidadDespuesDeUsoConVidaMaxima() {
        //Arrange
        Integer cantInicial = item.getCantidad();

        //Act
        item.aplicarItem(pokemon);

        //Assert
        assertSame(item.getCantidad(), cantInicial);
    }

    @Test
    public void testItemCantidadDespuesDeUsoSinVidaMaxima() {
        //Arrange
        Integer mitadVida = pokemon.getVidaMaxima()/2;
        when(pokemon.getVidaActual()).thenReturn(mitadVida);
        when(pokemon.tieneVidaLlena()).thenReturn(false);
        Integer cantInicial = item.getCantidad();

        //Act
        item.aplicarItem(pokemon);

        //Assert
        assertEquals((int) item.getCantidad(), cantInicial - 1);
    }

    @Test
    public void testItemCantidadDespuesDeUsoConVidaNula() {
        //Arrange
        Integer resultado = item.getCantidad();
        when(pokemon.estaMuerto()).thenReturn(true);

        //Act
        item.aplicarItem(pokemon);

        //Assert
        assertSame(item.getCantidad(), item.getCantidad());
    }
}

