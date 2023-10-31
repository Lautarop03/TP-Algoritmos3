package unit.model.items;

import org.fiuba.algoritmos3.model.items.Pocion;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;

public class PocionTest {

    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 100,100,0,0.0,0.0,null);
    private Pocion pocion = new Pocion(1);
    private itemsRestauradoresDeVidaTest itemTest = new itemsRestauradoresDeVidaTest(pocion, pokemon);

    @Test
    public void testAplicarPocionConVidaBaja() {
        Integer vidaActual = 10;
        Integer vidaResultado = 30;

        itemTest.testAplicarItemConVidaBaja(vidaActual, vidaResultado);
    }

    @Test
    public void testAplicarPocionConVidaAlta(){
        Integer vidaActual = 90;

        itemTest.testAplicarItemConVidaAlta(vidaActual);
    }

    @Test
    public void testAplicarPocionConVidaMaxima(){
        itemTest.testAplicarItemConVidaMaxima();
    }

    @Test
    public void testAplicarPocionConVidaNula(){
        itemTest.testAplicarItemConVidaNula();
    }

    @Test
    public void testPocionCantidadDespuesDeUsoConVidaMaxima(){
        itemTest.testItemCantidadDespuesDeUsoConVidaMaxima();
    }

    @Test
    public void testPocionCantidadDespuesDeUsoSinVidaMaxima(){
        itemTest.testItemCantidadDespuesDeUsoSinVidaMaxima();

    }
    @Test
    public void testPocionCantidadDespuesDeUsoConVidaNula(){
        itemTest.testItemCantidadDespuesDeUsoConVidaNula();
    }
}
