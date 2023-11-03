package unit.model.Juego;

import org.fiuba.algoritmos3.model.AdministradorDeJuego;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.PaqueteDeRespuesta;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeDano;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntegracionJuegoTest {
    @Test
    public void testRealizarAtaque() throws IOException {
        //Arrange
        Habilidad h1 = new HabilidadDeDano("",1,Tipo.Agua,100);
        Habilidad h2 = new HabilidadDeDano("",1,Tipo.Agua,100);
        Pokemon p1 = new Pokemon("",10, Tipo.Agua,"",100,100,10, 100.0, 100.0,List.of(h1));
        Pokemon p2 = new Pokemon("",10, Tipo.Agua,"",100,100,10, 100.0, 100.0,List.of(h2));
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(p1);
        ArrayList<Pokemon> pokemons2 = new ArrayList<Pokemon>();
        pokemons2.add(p2);
        Jugador j1 = new Jugador("",pokemons,null);
        Jugador j2 = new Jugador("",pokemons2,null);
        Juego juego = new Juego(List.of(j1,j2));

        //Mock private attribute
        AdministradorDeJuego administradorDeJuego = mock(AdministradorDeJuego.class);
        juego.setAdministradorDeJuego(administradorDeJuego);

        when(administradorDeJuego.pedirHabilidad(p1)).thenReturn(new PaqueteDeRespuesta<>(true,h1));

        Pokemon actual = j1.getPokemonActual();
        Pokemon enemigo = j2.getPokemonActual();

        juego.atacar();
        juego.realizarAtaque();


        //Assert
        assertTrue(actual.getVidaActual() > enemigo.getVidaActual());
    }
    @Test
    public void testIntercambiarPokemons() throws IOException {
        //Arrange
        Habilidad h1 = new HabilidadDeDano("h1",1,Tipo.Agua,100);
        Habilidad h2 = new HabilidadDeDano("h2",1,Tipo.Agua,100);
        Pokemon p1 = new Pokemon("p1",10, Tipo.Agua,"",100,100,10, 100.0, 100.0,List.of(h1));
        Pokemon p2 = new Pokemon("p2",10, Tipo.Agua,"",100,100,10, 100.0, 100.0,List.of(h2));
        Pokemon p3 = new Pokemon("p3",10, Tipo.Agua,"",100,100,10, 100.0, 100.0,List.of(h1));
        Pokemon p4 = new Pokemon("p4",10, Tipo.Agua,"",100,100,10, 100.0, 100.0,List.of(h2));
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(p1);
        pokemons.add(p2);
        ArrayList<Pokemon> pokemons2 = new ArrayList<Pokemon>();
        pokemons2.add(p3);
        pokemons2.add(p4);
        Jugador j1 = new Jugador("",pokemons,null);
        Jugador j2 = new Jugador("",pokemons2,null);
        Juego juego = new Juego(List.of(j1,j2));

        //Mock private attribute
        AdministradorDeJuego administradorDeJuego = mock(AdministradorDeJuego.class);
        juego.setAdministradorDeJuego(administradorDeJuego);

        when(administradorDeJuego.pedirPokemon(pokemons)).thenReturn(new PaqueteDeRespuesta<>(true,1));
        when(administradorDeJuego.pedirPokemon(pokemons2)).thenReturn(new PaqueteDeRespuesta<>(true,1));

        Pokemon PokActual = j1.getPokemonActual();
        Pokemon PokActualenemigo = j2.getPokemonActual();

        juego.cambiarPokemon();
        juego.cambiarTurno();
        juego.cambiarPokemon();

        Pokemon PokActualNuevo = j1.getPokemonActual();
        Pokemon PokEnemigoNuevo = j2.getPokemonActual();

        //Assert
        assertNotEquals(PokActual,PokActualNuevo);
        assertNotEquals(PokActualenemigo,PokEnemigoNuevo);
        assertEquals(PokActualNuevo.getNombre(),"p2");
        assertEquals(PokEnemigoNuevo.getNombre(),"p4");
    }
}
