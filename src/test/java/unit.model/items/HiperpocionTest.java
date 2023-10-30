package unit.model.items;

import org.fiuba.algoritmos3.model.items.Hiperpocion;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;

public class HiperpocionTest {

    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 200,200,0,0.0,0.0,null);
    private Hiperpocion hiperpocion = new Hiperpocion(1);
    private ItemsRestauradoresDeVidaTest itemTest = new ItemsRestauradoresDeVidaTest(hiperpocion, pokemon);

    @Test
    public void TestAplicarPocionConVidaBaja() {
        Integer vidaResultado = 110;
        Integer vidaActual = 10;

        itemTest.TestAplicarPocionConVidaBaja(vidaActual, vidaResultado);
    }

    @Test
    public void TestAplicarPocionConVidaAlta() {
        Integer vidaActual = 150;

        itemTest.TestAplicarPocionConVidaAlta(vidaActual);
    }

    @Test
    public void TestAplicarPocionConVidaMaxima() {
        itemTest.TestAplicarPocionConVidaMaxima();
    }

    @Test
    public void TestAplicarPocionConVidaNula() {
        itemTest.TestAplicarPocionConVidaNula();
    }
}
