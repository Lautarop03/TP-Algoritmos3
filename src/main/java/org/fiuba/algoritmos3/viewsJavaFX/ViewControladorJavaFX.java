package org.fiuba.algoritmos3.viewsJavaFX;

import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.clima.Clima;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.fiuba.algoritmos3.viewsJavaFX.estadoViewJavaFX.EstadoViewJavaFX;
import org.fiuba.algoritmos3.viewsJavaFX.estadoViewJavaFX.FactoryEstadoViewJavaFX;
import org.fiuba.algoritmos3.viewsJavaFX.habilidadViewJavaFX.FactoryHabilidadViewJavaFX;
import org.fiuba.algoritmos3.viewsJavaFX.habilidadViewJavaFX.HabilidadViewJavaFX;

import java.util.List;

public class ViewControladorJavaFX {
    private PokemonViewJavaFX pokemonView;
    private FactoryHabilidadViewJavaFX habilidadFactory;
    private FactoryEstadoViewJavaFX estadoFactory;
    private ItemViewJavaFX itemView;
    private ClimaViewJavaFX climaView;

    public ViewControladorJavaFX() {
        this.pokemonView = new PokemonViewJavaFX();
        this.estadoFactory = new FactoryEstadoViewJavaFX();
        this.habilidadFactory = new FactoryHabilidadViewJavaFX();
        this.itemView = new ItemViewJavaFX();
        this.climaView = new ClimaViewJavaFX();
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
        HabilidadViewJavaFX habilidadView = habilidadFactory.createHabilidadView(habilidad);
        habilidadView.mostrarHabilidad(habilidad);
    }

    public void mostrarAccion(Habilidad habilidad,Pokemon pokemonActual, Pokemon pokemonEnemigo){
        HabilidadViewJavaFX habilidadView = habilidadFactory.createHabilidadView(habilidad);
        habilidadView.mostrarAccion(habilidad,pokemonActual,pokemonEnemigo);
    }

    public void opcionVolverAMenu(){
        System.out.println("0. Volver al menu de acciones");
    }

    public void mostrarEfectoEstado(Estado estado, Pokemon pokemon, Boolean aplicado){
        EstadoViewJavaFX estadoView = estadoFactory.createEstadoView(estado);
        estadoView.mostrarEstado(pokemon,estado,aplicado);
    }

    public void mostrarPokemonMuerto(Pokemon pokemon){
        System.out.println(pokemon.getNombre() + " la quedo");
    }

    public void mostrarCampo(List<Jugador> jugadores, Clima clima) {
        if (clima != null) {
            climaView.mostrarClima(clima);
        }
        for (Jugador jugador : jugadores) {
            System.out.println("Pokemon de: " + jugador.getNombre());
            Pokemon pokemon = jugador.getPokemonActual();
            pokemonView.mostrarPokemon(pokemon);
        }
    }

    public void mostrarGanador(Jugador jugador){
        System.out.println("El ganador es: " + jugador.getNombre());
    }

    public void errorHabilidadEstado() {
        System.out.println("No se puede aplicar el estado, el pokemon ya tiene uno de la misma clase");
    }
    public void errorHabilidadSinUsos() {
        System.out.println("Habilidad sin usos, elegir otra");
    }
}
