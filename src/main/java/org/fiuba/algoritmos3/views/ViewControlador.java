package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.Jugador;
import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;
import java.util.List;

public class ViewControlador {
    private PokemonView pokemonView;
    private HabilidadView habilidadView;
    private ItemView itemView;

    public ViewControlador() {
        this.pokemonView = new PokemonView();
        this.habilidadView = new HabilidadView();
        this.itemView = new ItemView();
    }

    public void mostrarItem(Item item) {
        itemView.mostrarItem(item);
    }

    public void mostrarUsoItem(Jugador jugador, Item item, Pokemon pokemon){
        itemView.mostrarUsoItem(jugador, item, pokemon);
    }

    public void errorUsoItem (Item item) {
        itemView.mostrarErrorUsoItem(item);
    }

    public void errorIntercambiarPokemon(){
        pokemonView.mostrarErrorIntercambiar();
    }

    public void mostrarCambioPokemon(Pokemon pokemon){
        pokemonView.mostrarCambioPokemon(pokemon);
    }

    public void mostrarPokemon(Pokemon pokemon) {
        pokemonView.mostrarPokemon(pokemon);
    }

    public void mostrarHabilidad(Habilidad habilidad) {
        habilidadView.mostrarHabilidad(habilidad);
    }

    public void mostrarAccion(Habilidad habilidad,Pokemon pokemonActual, Pokemon pokemonEnemigo){
        habilidadView.mostrarAccion(habilidad,pokemonActual,pokemonEnemigo);
    }

    public void mostrarCampo(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            System.out.println("Pokemon de: " + jugador.getNombre());
            Pokemon pokemon = jugador.getPokemonActual();
            pokemonView.mostrarPokemon(pokemon);
        }
    }

    public void mostrarGanador(Jugador jugador){
        System.out.println("El ganador es: " + jugador.getNombre());
    }
}
