package integration.model.Juego;

import org.fiuba.algoritmos3.model.AdministradorDeJuego;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.PaqueteDeRespuesta;
import org.fiuba.algoritmos3.model.clima.Lluvia;
import org.fiuba.algoritmos3.model.items.*;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.model.pokemon.estados.Envenenado;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EndToEndTest {
    @Test
    public void testRealizarAtaque() throws IOException {
        //Arrange
        Habilidad h1 = new HabilidadDeDano("",2, Tipo.Agua,100);
        Habilidad h2 = new HabilidadDeEstado("",3,Tipo.Fuego,new Dormido());
        Habilidad h3 = new HabilidadDeClima("",2, Tipo.Tierra,new Lluvia());
        Habilidad h4 = new HabilidadDeEstadisticaDefensa("",3,Tipo.Lucha,10);
        Habilidad h5 = new HabilidadDeDano("",2, Tipo.Agua,150);
        Habilidad h6 = new HabilidadDeEstado("",3,Tipo.Fuego,new Envenenado());
        Habilidad h7 = new HabilidadDeClima("",2, Tipo.Tierra,new Lluvia());
        Habilidad h8 = new HabilidadDeEstadisticaDefensa("",3,Tipo.Lucha,10);

        Pokemon p1 = new Pokemon("",13, Tipo.Agua,"",123,123,10, 30.0, 54.0, List.of(h1,h2));
        Pokemon p2 = new Pokemon("",16, Tipo.Fuego,"",150,150,10, 30.0, 340.0,List.of(h3,h4));
        Pokemon p3 = new Pokemon("",17, Tipo.Tierra,"",120,120,10, 20.0, 430.0, List.of(h5,h6));
        Pokemon p4 = new Pokemon("",8, Tipo.Electrico,"",160,160,10, 50.0, 54.0,List.of(h7,h8));

        Item I1 = new CuraTodo(1);
        Item I2 = new Revivir(2);
        Item I3 = new ItemModificadorAtaque(3);
        Item I4 = new PocionMolestaAlumnos(2);

        List<Item> items1 = List.of(I1,I2);
        List<Item> items2 = List.of(I3,I4);

        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(p1);
        pokemons.add(p2);
        ArrayList<Pokemon> pokemons2 = new ArrayList<Pokemon>();
        pokemons2.add(p3);
        pokemons2.add(p4);

        Jugador j1 = new Jugador("",pokemons,items1);
        Jugador j2 = new Jugador("",pokemons2,items2);

        Juego juego = new Juego(List.of(j1,j2));

        //Mock private attribute
        AdministradorDeJuego administradorDeJuego = mock(AdministradorDeJuego.class);
        juego.setAdministradorDeJuego(administradorDeJuego);

        //Arranca j1, Ataca con "Dormir"
        juego.atacar(new PaqueteDeRespuesta<>(true,h2));
        juego.realizarAtaque();

        //Assert
        Pokemon EnemigoActual = j2.getPokemonActual();
        Estado estado = EnemigoActual.getEstados().get(0);
        assertEquals(estado.getClass(),Dormido.class);

        //Turno de j2
        juego.cambiarTurno();

        // Ataca j2, Con habilidadDeDano
        juego.atacar(new PaqueteDeRespuesta<>(true,h5));
        juego.realizarAtaque();


        //Assert P1 muerto
        assertTrue(j1.getPokemonActual().estaMuerto());

        //Turno de j1
        juego.cambiarTurno();

        when(administradorDeJuego.pedirPokemon(pokemons)).thenReturn(new PaqueteDeRespuesta<>(true,1));
        juego.cambiarPokemon(1);// cambio pokemon p1 por el p2

        when(administradorDeJuego.pedirItem(items1)).thenReturn(new PaqueteDeRespuesta<>(true,1)); // Pocion revivir
        when(administradorDeJuego.pedirPokemon(pokemons)).thenReturn(new PaqueteDeRespuesta<>(true,1)); // Pokemon muerto
        List<Item> items = juego.getJugadorActual().getItems();
        Item item = items.get(1);
        juego.usarItem(item,1); // Revivo al pokemon p1

        //Assert
        assertTrue(p1.estaVivo());

        //Turno de j2
        juego.cambiarTurno();

        juego.atacar(new PaqueteDeRespuesta<>(true,h6)); // p3 ataca a p2 con Envenenar
        juego.realizarAtaque();

        //Assert
        Estado estadop2 = p2.getEstados().get(0);
        assertEquals(estadop2.getClass(), Envenenado.class);

        //Turno de j1
        juego.cambiarTurno();

        //Se aplica el estado Envenenado
        Integer vidaPrevia = juego.getJugadorActual().getPokemonActual().getVidaActual();
        juego.aplicarEstados();
        Integer vidaAfter = juego.getJugadorActual().getPokemonActual().getVidaActual();
        //Assert
        assertTrue(vidaPrevia > vidaAfter);

        juego.atacar(new PaqueteDeRespuesta<>(true,h3));
        juego.realizarAtaque(); // Ataco con p2, ataque de clima

        //Assert
        assertEquals(juego.getClima().getClass(),Lluvia.class);

        //Turno de j2
        juego.cambiarTurno();

        juego.atacar(new PaqueteDeRespuesta<>(true,h5));
        juego.realizarAtaque();

        //Assert
        assertTrue(p2.estaMuerto());

        //Turno de j1
        juego.cambiarTurno();

        juego.cambiarPokemon(1);// cambio pokemon p2 por el p1

        //Assert
        Pokemon Actual = juego.getJugadorActual().getPokemonActual();
        assertEquals(p1,Actual);

        //Turno de j2
        juego.cambiarTurno();

        juego.atacar(new PaqueteDeRespuesta<>(true,h5));
        juego.realizarAtaque();

        //Assert
        assertTrue(p1.estaMuerto());

        //Assert
        assertTrue(juego.terminado());
    }

}