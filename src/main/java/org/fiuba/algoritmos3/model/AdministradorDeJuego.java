package org.fiuba.algoritmos3.model;

import org.fiuba.algoritmos3.Inputs;
import org.fiuba.algoritmos3.model.clima.Clima;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.views.ViewControlador;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeJuego {
    final int volverAlMenu = -1;
    private final Inputs inputs;
    private final ViewControlador viewControlador;

    public AdministradorDeJuego(Inputs inputs, ViewControlador viewControlador) {
        this.inputs = inputs;
        this.viewControlador = viewControlador;

    }

    public PaqueteDeRespuesta<Habilidad> pedirHabilidad(Pokemon pokemonActual){
        while(true){
            int numeroHabilidad = inputs.pedirHabilidad(pokemonActual.getHabilidades());
            if (numeroHabilidad == volverAlMenu) {
                return new PaqueteDeRespuesta<>(false,null);
            }
            Habilidad habilidad = pokemonActual.getHabilidades().get(numeroHabilidad);
            if (habilidad.getCantidadDeUsos() == 0){
                viewControlador.errorHabilidadSinUsos();
            } else {
                return new PaqueteDeRespuesta<>(true, habilidad);
            }
        }
    }
    public PaqueteDeRespuesta<Integer> pedirItem(List<Item> items) {
        int numeroItem = inputs.pedirItem(items);
        if (numeroItem == volverAlMenu) {
            return new PaqueteDeRespuesta<>(false,null);
        }
        return new PaqueteDeRespuesta<>(true,numeroItem);
    }

    public PaqueteDeRespuesta<Integer> pedirPokemon(List<Pokemon> pokemones) {
        viewControlador.opcionVolverAMenu();
        int numeroPokemon = inputs.pedirPokemon(pokemones);
        if (numeroPokemon == volverAlMenu) {
            return new PaqueteDeRespuesta<>(false,null);
        }
        return new PaqueteDeRespuesta<>(true,numeroPokemon);
    }

    public void mostrarEstadosAplicados(List<Boolean> booleanEstados, List<Estado> estados, Pokemon pokemon){
        int contador = 0;
        for(Boolean booleanEstado : booleanEstados) {
            Estado estadoActual = estados.get(contador);
            viewControlador.mostrarEfectoEstado(estadoActual, pokemon, booleanEstado);
            contador += 1;
        }

    }
    public void mostrarCampo(List<Jugador> jugadores, Clima clima) {
        viewControlador.mostrarCampo(jugadores,clima);
    }

    public int pedirCambioPokemonMuerto(ArrayList<Pokemon> pokemones) {
        return inputs.pedirPokemonMuerto(pokemones);
    }

    public void mostrarPokemonMuerto(Pokemon pokemon) {
        viewControlador.mostrarPokemonMuerto(pokemon);
    }
    public void errorIntercambiarPokemonSinVida() {
        viewControlador.errorIntercambiarPokemonSinVida();
    }

    public void mostrarCambioPokemon(Pokemon pokemon){
        viewControlador.mostrarCambioPokemon(pokemon);
    }

    public  void mostrarAccion(Habilidad habilidad, Pokemon pokemonActual, Pokemon pokemonEnemigo){
        viewControlador.mostrarAccion(habilidad,pokemonActual,pokemonEnemigo);
    }

    public  void errorHabilidadEstado(){
        viewControlador.errorHabilidadEstado();
    }


    public void errorUsoItem(Item item) {
        viewControlador.errorUsoItem(item);
    }
    public  void errorPokemonActual(){
        viewControlador.errorPokemonActual();
    }

    public void mostrarUsoItem(Jugador jugadorActual, Item item, Pokemon pokemon) {
        viewControlador.mostrarUsoItem(jugadorActual, item, pokemon);
    }

    public void mostrarGanador(Jugador jugador){
        viewControlador.mostrarGanador(jugador);
    }

}

