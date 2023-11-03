package integration.model.Juego;

import org.fiuba.algoritmos3.model.AdministradorDeJuego;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.PaqueteDeRespuesta;
import org.fiuba.algoritmos3.model.clima.Lluvia;
import org.fiuba.algoritmos3.model.clima.TormentaDeRayos;
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
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EndToEndTest2 {

    private double calcularDano(HabilidadDeDano habilidadDeDano, Pokemon pokemonActual, Pokemon pokemonEnemigo, Random random) {
        double danoFinal;

        danoFinal = 2 * pokemonActual.getNivel() * habilidadDeDano.getPotencia() * habilidadDeDano.getProbabilidadCritico();
        double AYD = (pokemonActual.getAtaque()/pokemonEnemigo.getDefensa());
        danoFinal = ((danoFinal * AYD/5) + 2)/50;
        danoFinal = danoFinal * habilidadDeDano.getSTAB(pokemonActual) * habilidadDeDano.getArrayEfectividad()[pokemonEnemigo.getTipo().getIndice()];
        danoFinal = danoFinal * (random.nextDouble()* 38 + 217)/255;
        return danoFinal;
    }
    @Test
    public void testJugarjuego() throws IOException{

        Envenenado envenenado = new Envenenado();
        Dormido dormido = new Dormido();

        HabilidadDeDano habilidadDeDano1 = new HabilidadDeDano("", 2, Tipo.Agua, 100);
        HabilidadDeEstado habilidadDeEstado1 = new HabilidadDeEstado("", 3, Tipo.Fuego, dormido);
        HabilidadDeClima habilidadDeClima1 = new HabilidadDeClima("", 2, Tipo.Tierra, new TormentaDeRayos());
        HabilidadDeEstadisticaDefensa habilidadDeEstadisticaDefensa1 = new HabilidadDeEstadisticaDefensa("", 3, Tipo.Lucha, 10);

        HabilidadDeDano habilidadDeDano2 = new HabilidadDeDano("", 2, Tipo.Agua, 150);
        HabilidadDeEstado habilidadDeEstado2 = new HabilidadDeEstado("", 3, Tipo.Fuego, envenenado);
        HabilidadDeClima habilidadDeClima2 = new HabilidadDeClima("", 2, Tipo.Tierra, new Lluvia());
        HabilidadDeEstadisticaDefensa habilidadDeEstadisticaDefensa2 = new HabilidadDeEstadisticaDefensa("", 3, Tipo.Lucha, 10);

        Random random = mock(Random.class);
        when(random.nextDouble()).thenReturn(1.0);
        habilidadDeDano1.setRandom(random);
        habilidadDeDano2.setRandom(random);


        Pokemon p1 = new Pokemon("Vaporeon", 13, Tipo.Agua, "", 200, 200, 10, 30.0, 150.0, List.of( habilidadDeDano1,habilidadDeEstado1));
        Pokemon p2 = new Pokemon("Flareon", 16, Tipo.Fuego, "", 250, 250, 10, 30.0, 300.0, List.of(habilidadDeClima1, habilidadDeEstadisticaDefensa1));
        Pokemon p3 = new Pokemon("Eevee", 17, Tipo.Normal, "", 150, 150, 10, 20.0, 400.0, List.of(habilidadDeDano2, habilidadDeEstado2));
        Pokemon p4 = new Pokemon("Jolteon", 8, Tipo.Electrico, "", 300, 300, 10, 50.0, 100.0, List.of(habilidadDeClima2, habilidadDeEstadisticaDefensa2));

        CuraTodo item1 = new CuraTodo(1);
        PocionMolestaAlumnos item2 = new PocionMolestaAlumnos(2);

        MegaPocion item3 = new MegaPocion(1);
        Hiperpocion item4 = new Hiperpocion(2);

        List<Item> items1 = List.of(item1,item2);
        List<Item> items2 = List.of(item3,item4);

        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(p1);
        pokemons.add(p2);
        ArrayList<Pokemon> pokemons2 = new ArrayList<Pokemon>();
        pokemons2.add(p3);
        pokemons2.add(p4);

        Jugador j1 = new Jugador("Brock",pokemons,items1);
        Jugador j2 = new Jugador("Misty",pokemons2,items2);

        Juego juego = new Juego(List.of(j1,j2));

        AdministradorDeJuego administradorDeJuego = mock(AdministradorDeJuego.class);
        juego.setAdministradorDeJuego(administradorDeJuego);

        // Assert Hiperpoción con cantidad límite 1
        assertEquals(1, (int) item4.getCantidad());

        //- - - - - - - - - - Turno de j1 (p1) - - - - - - - - - -

        when(administradorDeJuego.pedirHabilidad(p1)).thenReturn(new PaqueteDeRespuesta<>(true,habilidadDeDano1));

        //Atacamos con habilidad de daño
        Integer vidaAntesDeAtaque = j2.getPokemonActual().getVidaActual();
        juego.atacar();
        juego.realizarAtaque();
        double danio = calcularDano(habilidadDeDano1, p1, p3, random);

        //Assert de daño al pokemon del j2
        Integer vidaDespuesDeAtaque = vidaAntesDeAtaque - (int)danio;
        assertEquals(j2.getPokemonActual().getVidaActual(),vidaDespuesDeAtaque);

        //- - - - - - - - - - Turno del j2 (p3) - - - - - - - - - -
        juego.cambiarTurno();

        //Usamos habiladad de estado en el j1
        when(administradorDeJuego.pedirHabilidad(p3)).thenReturn(new PaqueteDeRespuesta<>(true, habilidadDeEstado2));

        juego.atacar();
        juego.realizarAtaque();

        //Assert de estado envenenado a j1
        assertTrue(j1.getPokemonActual().getEstados().get(0) instanceof Envenenado);

        //- - - - - - - - - - Turno de j1 (p1) - - - - - - - - - -
        juego.cambiarTurno();

        //Usamos Habilidad de clima en el j1
        when(administradorDeJuego.pedirHabilidad(p1)).thenReturn(new PaqueteDeRespuesta<>(true, habilidadDeClima1));

        Integer vidaAntesDeEnvenenmiento = j1.getPokemonActual().getVidaActual();
        juego.atacar();
        juego.realizarAtaque();
        juego.aplicarEstados();

        Integer vidaResultado = (int)(vidaAntesDeEnvenenmiento - p1.getVidaMaxima() * 0.05);

        //Assert Clima y Envenenado
        assertEquals(juego.getClima().getClass(), TormentaDeRayos.class);
        assertEquals(vidaResultado, j1.getPokemonActual().getVidaActual());

        //- - - - - - - - - - Turno de j2 (p3) - - - - - - - - - -
        juego.cambiarTurno();
        Integer vidaAntesDeDanioClimatico = j2.getPokemonActual().getVidaActual();
        juego.aplicarClima();

        Integer vidaResultado2 = vidaAntesDeDanioClimatico - (int)(j2.getPokemonActual().getVidaMaxima() * 0.03);

        //Assert Clima
        assertEquals(juego.getClima().getClass(), TormentaDeRayos.class);
        assertEquals(vidaResultado2, j2.getPokemonActual().getVidaActual());

        when(administradorDeJuego.pedirPokemon(j2.getPokemones())).thenReturn(new PaqueteDeRespuesta<>(true, 0));
        when(administradorDeJuego.pedirItem(items2)).thenReturn(new PaqueteDeRespuesta<>(true,1));
        Boolean seUsoElItem = juego.usarItem();

        //Assert uso Item
        Integer vidaResultado3 = vidaResultado2 + item4.getcantidadDeCura();
        assertTrue(seUsoElItem);
        assertEquals(vidaResultado3, j2.getPokemonActual().getVidaActual());

        //- - - - - - - - - - Turno de j1 (p1) - - - - - - - - - -
        juego.cambiarTurno();
        vidaAntesDeDanioClimatico = j1.getPokemonActual().getVidaActual();
        juego.aplicarClima();

        vidaResultado = vidaAntesDeDanioClimatico - (int)(j1.getPokemonActual().getVidaMaxima() * 0.03);

        //Assert Clima
        assertEquals(juego.getClima().getClass(), TormentaDeRayos.class);
        assertEquals(vidaResultado, j1.getPokemonActual().getVidaActual());

        when(administradorDeJuego.pedirItem(items1)).thenReturn(new PaqueteDeRespuesta<>(true, 0));
        when(administradorDeJuego.pedirPokemon(j1.getPokemones())).thenReturn(new PaqueteDeRespuesta<>(true, 0));

        Boolean seUsoElItem2 = juego.usarItem();

        //Assert uso Item
        assertTrue(seUsoElItem2);
        assertEquals(List.of(),j1.getPokemonActual().getEstados());

        //- - - - - - - - - - Turno de j2 (p3) - - - - - - - - - -
        juego.cambiarTurno();
        juego.rendirse();

        //Assert terminar juego
        assertEquals(List.of(),j2.getPokemones());
        assertTrue(juego.terminado());
    }
}
