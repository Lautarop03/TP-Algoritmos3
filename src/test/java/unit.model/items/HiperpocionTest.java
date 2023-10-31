package unit.model.items;

import org.fiuba.algoritmos3.model.items.Hiperpocion;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HiperpocionTest {

    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,200,0,0.0,0.0,null);
    private Hiperpocion hiperpocion = new Hiperpocion(1);
    private itemsRestauradoresDeVidaTest itemTest = new itemsRestauradoresDeVidaTest(hiperpocion, pokemon);


    @Test
    public void testAplicarHiperpocionConVidaBaja() {
        Integer vidaResultado = 110;
        Integer vidaActual = 10;

        itemTest.testAplicarItemConVidaBaja(vidaActual, vidaResultado);
    }

    @Test
    public void testAplicarHiperpocionConVidaAlta() {
        Integer vidaActual = 150;

        itemTest.testAplicarItemConVidaAlta(vidaActual);
    }

    @Test
    public void testAplicarHiperpocionnConVidaMaxima() {
        itemTest.testAplicarItemConVidaMaxima();
    }

    @Test
    public void testAplicarHiperpocionConVidaNula() {
        itemTest.testAplicarItemConVidaNula();
    }

    @Test
    public void testHiperpocionCantidadAlCrearse(){
        //Arrange
        Hiperpocion hiperpocion = new Hiperpocion(5);

        //Act
        Integer resultado = hiperpocion.getCantidad();

        //Assert
        assertEquals(1, (int) resultado);
    }

    @Test
    public void testHiperpocionCantidadDespuesDeUsoConVidaMaxima(){itemTest.testItemCantidadDespuesDeUsoSinVidaMaxima();}

    @Test
    public void testHiperpocionCantidadDespuesDeUsoSinVidaMaxima(){itemTest.testItemCantidadDespuesDeUsoSinVidaMaxima();}
    @Test
    public void testHiperpocionCantidadDespuesDeUsoConVidaNula(){itemTest.testItemCantidadDespuesDeUsoConVidaNula();}
}
