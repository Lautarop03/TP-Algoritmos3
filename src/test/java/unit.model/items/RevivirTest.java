package unit.model.items;

import org.fiuba.algoritmos3.model.items.Revivir;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class RevivirTest {
    private Revivir revivir = new Revivir(1);
    private Pokemon pokemon = mock(Pokemon.class);


    @BeforeEach
    void inicializacion(){
        this.revivir = new Revivir(1);
        this.pokemon = mock(Pokemon.class);
    }

    @Test
    public void testRevivirPokemonYaVivo() {
        //Arrange
        when(pokemon.estaVivo()).thenReturn(true);

        //Act
        Boolean resultado = revivir.aplicarItem(pokemon);

        //Assert
        assertEquals(resultado, true);
    }

    @Test
    public void testRevivirPokemonMuerto() {
        //Arrange
        pokemon = spy(new Pokemon("",0, Tipo.Electrico, "", 100,0,0,0.0,0.0,null));
        Integer vidaFinal = 50;
        when(pokemon.estaVivo()).thenReturn(false);

        //Act
        Boolean resultado = revivir.aplicarItem(pokemon);

        //Assert
        assertEquals(resultado, false);
        assertEquals(vidaFinal, pokemon.getVidaActual());
    }
}
