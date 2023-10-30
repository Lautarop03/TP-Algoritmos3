package unit.model.items;

import org.fiuba.algoritmos3.model.items.PocionMolestaAlumnos;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;

public class PocionMolestaAlumnosTest {

    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 120,120,0,0.0,0.0,null);
    private PocionMolestaAlumnos pocionMolestaAlumnos = new PocionMolestaAlumnos(1);
    private ItemsRestauradoresDeVidaTest itemTest = new ItemsRestauradoresDeVidaTest(pocionMolestaAlumnos, pokemon);

    @Test
    public void TestAplicarPocionConVidaBaja() {
        Integer vidaActual = 10;
        Integer vidaResultado = 50;

        itemTest.TestAplicarPocionConVidaBaja(vidaActual, vidaResultado);
    }

    @Test
    public void TestAplicarPocionConVidaAlta(){
        Integer vidaActual = 100;

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
