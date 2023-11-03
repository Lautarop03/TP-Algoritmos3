package unit.model.clima;

import org.fiuba.algoritmos3.model.clima.*;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClimaTest {

    @Test
    public void ClimaAplicaBeneficiosTest() {
        //Arrange
        Clima clima = new Soleado(); // beneficia fuego
        Pokemon pikachu = new Pokemon("Pikachu",50, Tipo.Electrico, "asd", 35,35,90,40.0,55.0, null);
        Double DanoPrevioPikachu = pikachu.getAtaque();
        Pokemon charizard = new Pokemon("Charizard",50, Tipo.Fuego, "asd", 78,78,100,78.0,84.0, null);
        Double DanoPrevioCharizard = charizard.getAtaque();;

        //Act
        clima.potenciarBeneficiados(pikachu,charizard);

        Double DanoActualPikachu = pikachu.getAtaque();
        Double DanoActualCharizard = charizard.getAtaque();
        //Assert
        assertTrue(DanoActualCharizard > DanoPrevioCharizard);
        assertEquals(DanoPrevioPikachu,DanoActualPikachu);
    }

    @Test
    public void ClimaAplicaQuitaBeneficiosTest() {
        //Arrange
        Clima clima = new Niebla(); // beneficia fuego
        Pokemon fantasmol = new Pokemon("Fantasmmmma",50, Tipo.Fantasma, "asd", 35,35,90,40.0,55.0, null);
        Double DanoPrevioFantasma = fantasmol.getAtaque();
        Pokemon charizard = new Pokemon("Charizard",50, Tipo.Fuego, "asd", 78,78,100,78.0,84.0, null);
        Double DanoPrevioCharizard = charizard.getAtaque();;

        //Act
        clima.quitarBeneficios(fantasmol,charizard); // Solo saca a los beneficiados

        Double DanoActualFantasma = fantasmol.getAtaque();
        Double DanoActualCharizard = charizard.getAtaque();
        //Assert
        assertEquals(DanoActualCharizard, DanoPrevioCharizard);
        assertTrue(DanoPrevioFantasma > DanoActualFantasma);
    }

    @Test
    public void ClimaAplicarBeneficiadosTest() {
        //Arrange
        Clima clima = new Lluvia(); // beneficia fuego
        Pokemon delfin = new Pokemon("delfin",50, Tipo.Agua, "asd", 40,35,90,40.0,84.0, null);
        Pokemon charizard = new Pokemon("Charizard",50, Tipo.Fuego, "asd", 78,78,100,78.0,84.0, null);
        Double charizardPrevio = charizard.getAtaque();
        Double DelfinPrevio = delfin.getAtaque();



        //Act
        clima.aplicarClima(delfin,charizard); //Se benefician


        Double charizardActual = charizard.getAtaque();
        Double DelfinActual = delfin.getAtaque();
        //Assert
        assertTrue(DelfinPrevio < DelfinActual);
        assertEquals(charizardActual,charizardPrevio);
    }
}
