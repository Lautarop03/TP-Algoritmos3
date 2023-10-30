package unit.model.items;

import org.fiuba.algoritmos3.model.items.MegaPocion;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;

public class MegaPocionTest {

    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 100,100,0,0.0,0.0,null);
    private MegaPocion megapocion = new MegaPocion(1);
    private ItemsRestauradoresDeVidaTest itemTest = new ItemsRestauradoresDeVidaTest(megapocion, pokemon);

    @Test
    public void TestAplicarPocionConVidaBaja() {
        Integer vidaActual = 10;
        Integer vidaResultado = 60;

        itemTest.TestAplicarPocionConVidaBaja(vidaActual, vidaResultado);
    }

    @Test
    public void TestAplicarPocionConVidaAlta(){
        Integer vidaActual = 90;

        itemTest.TestAplicarPocionConVidaAlta(vidaActual);
    }

    @Test
    public void TestAplicarPocionConVidaMaxima(){
        itemTest.TestAplicarPocionConVidaMaxima();
    }

    @Test
    public void TestAplicarPocionConVidaNula(){
        itemTest.TestAplicarPocionConVidaNula();
    }
}
