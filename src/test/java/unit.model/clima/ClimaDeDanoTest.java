package unit.model.clima;

import org.fiuba.algoritmos3.model.clima.Clima;
import org.fiuba.algoritmos3.model.clima.TormentaDeArena;
import org.fiuba.algoritmos3.model.clima.TormentaDeRayos;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import static org.junit.Assert.*;
import org.junit.Test;

public class ClimaDeDanoTest {

    @Test
    public void ClimaAplicaDanoTest() {
        //Arrange
        Clima clima = new TormentaDeRayos(); // beneficia electrico, daña a los otros
        Pokemon pikachu = new Pokemon("Pikachu",50, Tipo.Electrico, "asd", 35,35,90,40.0,55.0, null);
        Pokemon charizard = new Pokemon("Charizard",50, Tipo.Fuego, "asd", 78,78,100,78.0,84.0, null);

        //Act
        clima.aplicarClima(pikachu,charizard);

        //Assert
        assertTrue(charizard.getVidaMaxima() > charizard.getVidaActual());
        assertEquals(pikachu.getVidaMaxima(),pikachu.getVidaActual());
    }

    @Test
    public void ClimaAplicaBeneficiosTest() {
        //Arrange
        Clima clima = new TormentaDeArena(); // beneficia tierra y roca, daña a los otros
        Pokemon pikachu = new Pokemon("Pikachu",50, Tipo.Electrico, "asd", 35,35,90,40.0,55.0, null);
        Pokemon lombriz = new Pokemon("ComeTierra",50, Tipo.Tierra, "asd", 78,78,100,78.0,84.0, null);
        Double DanoPrevio = lombriz.getAtaque();

        //Act
        clima.aplicarClima(pikachu,lombriz);

        //Assert
        assertTrue(pikachu.getVidaMaxima() > pikachu.getVidaActual());
        assertEquals(lombriz.getVidaMaxima(),lombriz.getVidaActual());

        Double DanoActual = lombriz.getAtaque();
        Double DanoNuevo = (DanoPrevio+(DanoPrevio*0.01));
        assertEquals(DanoActual,DanoNuevo);//Dano nuevo == Dano previo + 10%
    }


}
