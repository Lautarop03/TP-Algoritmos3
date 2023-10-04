package org.fiuba.algoritmos3.views;

import org.fiuba.algoritmos3.Jugador;
import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.pokemon.estados.Estado;
import java.util.List;

public class ViewControlador {
    private PokemonView pokemonView;
    private FactoryHabilidadView habilidadFactory;
    private FactoryEstadoView estadoFactory;
    private ItemView itemView;

    public ViewControlador() {
        this.pokemonView = new PokemonView();
        this.estadoFactory = new FactoryEstadoView();
        this.habilidadFactory = new FactoryHabilidadView();
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

    public void errorIntercambiarPokemonSinVida(){
        pokemonView.mostrarErrorIntercambiarSinVida();
    }

    public void  errorPokemonActual(){ pokemonView.mostrarErrorIntercambiarMismo(); }

    public void mostrarCambioPokemon(Pokemon pokemon){
        pokemonView.mostrarCambioPokemon(pokemon);
    }

    public void mostrarPokemon(Pokemon pokemon) {
        pokemonView.mostrarPokemon(pokemon);
    }

    public void mostrarHabilidad(Habilidad habilidad) {
        HabilidadView habilidadView = habilidadFactory.createHabilidadView(habilidad);
        habilidadView.mostrarHabilidad(habilidad);
    }

    public void mostrarAccion(Habilidad habilidad,Pokemon pokemonActual, Pokemon pokemonEnemigo){
        HabilidadView habilidadView = habilidadFactory.createHabilidadView(habilidad);
        habilidadView.mostrarAccion(habilidad,pokemonActual,pokemonEnemigo);
    }

    public void opcionVolverAMenu(){
        System.out.println("0. Volver al menu de acciones");
    }

    public void mostrarEfectoEstado(Estado estado, Pokemon pokemon, Boolean aplicado){
        EstadoView estadoView = estadoFactory.createEstadoView(estado);
        estadoView.mostrarEstado(pokemon,estado,aplicado);

    }

    public void mostrarPokemonMuerto(Pokemon pokemon){
        System.out.println(pokemon.getNombre() + " la quedo");
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
