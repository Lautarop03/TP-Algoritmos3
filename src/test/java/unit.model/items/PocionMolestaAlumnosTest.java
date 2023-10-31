package unit.model.items;

import org.fiuba.algoritmos3.model.items.PocionMolestaAlumnos;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;

public class PocionMolestaAlumnosTest {

    private Pokemon pokemon = new Pokemon("",0, Tipo.Electrico, "", 120,120,0,0.0,0.0,null);
    private PocionMolestaAlumnos pocionMolestaAlumnos = new PocionMolestaAlumnos(1);
    private itemsRestauradoresDeVidaTest itemTest = new itemsRestauradoresDeVidaTest(pocionMolestaAlumnos, pokemon);

    @Test
    public void testAplicarPocionMolestaAlumnosConVidaBaja() {
        Integer vidaActual = 10;
        Integer vidaResultado = 50;

        itemTest.testAplicarItemConVidaBaja(vidaActual, vidaResultado);
    }

    @Test
    public void testAplicarPocionMolestaAlumnosConVidaAlta(){
        Integer vidaActual = 100;

        itemTest.testAplicarItemConVidaAlta(vidaActual);
    }

    @Test
    public void testAplicarPocionMolestaAlumnosConVidaMaxima(){
        itemTest.testAplicarItemConVidaMaxima();
    }

    @Test
    public void testAplicarPocionMolestaAlumnosConVidaNula(){
        itemTest.testAplicarItemConVidaNula();
    }

    @Test
    public void testPocionMolestaAlumnosCantidadDespuesDeUsoConVidaMaxima(){
        itemTest.testItemCantidadDespuesDeUsoConVidaMaxima();
    }

    @Test
    public void testPocionMolestaAlumnosCantidadDespuesDeUsoSinVidaMaxima(){
        itemTest.testItemCantidadDespuesDeUsoSinVidaMaxima();

    }
    @Test
    public void testPocionMolestaAlumnosCantidadDespuesDeUsoConVidaNula(){
        itemTest.testItemCantidadDespuesDeUsoConVidaNula();
    }
}
