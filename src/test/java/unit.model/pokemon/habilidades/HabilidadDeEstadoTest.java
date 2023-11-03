package unit.model.pokemon.habilidades;

import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.*;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeEstado;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HabilidadDeEstadoTest {
    private Pokemon pokemonEnemigo = new Pokemon("Charizard",20, Tipo.Fuego, "asd", 78,78,100,78.0,84.0, null);
    private Pokemon pokemon = new Pokemon("Pikachu",15, Tipo.Electrico, "asd", 35,35,90,40.0,55.0, null);
    private HabilidadDeEstado habilidadDormido = new HabilidadDeEstado("",1,Tipo.Agua,new Dormido());
    private HabilidadDeEstado habilidadConfuso = new HabilidadDeEstado("",1,Tipo.Agua,new Confuso());
    private HabilidadDeEstado habilidadEnvenenado = new HabilidadDeEstado("",1,Tipo.Agua,new Envenenado());
    private HabilidadDeEstado habilidadParalizado = new HabilidadDeEstado("",1,Tipo.Agua,new Paralizado());

    @Test
    public void testUsarHabilidadDeEstadoAplicarEfectoDormido(){
        //Act
        habilidadDormido.usarHabilidad(pokemon,pokemonEnemigo);
        List<Estado> estadoPokemon = pokemonEnemigo.getEstados();

        //Assert
        assertEquals(estadoPokemon.get(0).getClass(),Dormido.class);
    }
    @Test
    public void testUsarHabilidadDeEstadoAplicarEfectoEnvenenado(){
        //Act
        habilidadEnvenenado.usarHabilidad(pokemon,pokemonEnemigo);
        List<Estado> estadoPokemon = pokemonEnemigo.getEstados();

        //Assert
        assertEquals(estadoPokemon.get(0).getClass(),Envenenado.class);
    }
    @Test
    public void testUsarHabilidadDeEstadoAplicarEfectoParalizado(){
        //Act
        habilidadParalizado.usarHabilidad(pokemon,pokemonEnemigo);
        List<Estado> estadoPokemon = pokemonEnemigo.getEstados();

        //Assert
        assertEquals(estadoPokemon.get(0).getClass(),Paralizado.class);
    }
    @Test
    public void testUsarHabilidadDeEstadoAplicarEfectoConfuso(){
        //Act
        habilidadConfuso.usarHabilidad(pokemon,pokemonEnemigo);
        List<Estado> estadoPokemon = pokemonEnemigo.getEstados();

        //Assert
        assertEquals(estadoPokemon.get(0).getClass(),Confuso.class);
    }
    @Test
    public void testUsarHabilidadDeEstadoAplicaVariosEstados(){
        //Act
        habilidadDormido.usarHabilidad(pokemon,pokemonEnemigo);
        habilidadConfuso.usarHabilidad(pokemon,pokemonEnemigo);
        habilidadParalizado.usarHabilidad(pokemon,pokemonEnemigo);
        habilidadEnvenenado.usarHabilidad(pokemon,pokemonEnemigo);

        //Assert
        List<Estado> estadosPokemon = pokemonEnemigo.getEstados();
        assertEquals(estadosPokemon.get(0).getClass(),Dormido.class);
        assertEquals(estadosPokemon.get(1).getClass(),Confuso.class);
        assertEquals(estadosPokemon.get(2).getClass(),Paralizado.class);
        assertEquals(estadosPokemon.get(3).getClass(),Envenenado.class);
    }

}
