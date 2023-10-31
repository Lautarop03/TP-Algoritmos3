package unit.model.items;

import org.fiuba.algoritmos3.model.items.MegaPocion;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;

public class MegaPocionTest {

    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 100,100,0,0.0,0.0,null);
    private MegaPocion megapocion = new MegaPocion(1);
    private itemsRestauradoresDeVidaTest itemTest = new itemsRestauradoresDeVidaTest(megapocion, pokemon);

    @Test
    public void testAplicarMegaPocionConVidaBaja() {
        Integer vidaActual = 10;
        Integer vidaResultado = 60;

        itemTest.testAplicarItemConVidaBaja(vidaActual, vidaResultado);
    }

    @Test
    public void testAplicarMegaPocionConVidaAlta(){
        Integer vidaActual = 90;

        itemTest.testAplicarItemConVidaAlta(vidaActual);
    }

    @Test
    public void testAplicarMegaPocionConVidaMaxima(){
        itemTest.testAplicarItemConVidaMaxima();
    }

    @Test
    public void testAplicarMegaPocionConVidaNula(){
        itemTest.testAplicarItemConVidaNula();
    }

    @Test
    public void testMegaPocionCantidadDespuesDeUsoConVidaMaxima(){
        itemTest.testItemCantidadDespuesDeUsoConVidaMaxima();
    }

    @Test
    public void testMegaPocionCantidadDespuesDeUsoSinVidaMaxima(){
        itemTest.testItemCantidadDespuesDeUsoSinVidaMaxima();

    }
    @Test
    public void testMegaPocionCantidadDespuesDeUsoConVidaNula(){
        itemTest.testItemCantidadDespuesDeUsoConVidaNula();
    }

}
