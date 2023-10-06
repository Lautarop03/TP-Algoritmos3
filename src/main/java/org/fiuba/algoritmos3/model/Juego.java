package org.fiuba.algoritmos3.model;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.views.ViewControlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


public class Juego {
    final int volverAlMenu = -1;
    private final AdministradorDeTurno administradorDeTurno;
    private final Inputs inputs;
    private final List<Jugador> jugadores;
    private final ViewControlador viewControlador;
    protected Queue<Habilidad> colaDeAtaques;


    public Juego(List<Jugador> jugadores) throws IOException {
        this.inputs = new Inputs();
        this.viewControlador = new ViewControlador();
        this.jugadores = jugadores;
        this.administradorDeTurno = new AdministradorDeTurno(jugadores);
        this.colaDeAtaques = new LinkedList<>();
    }

    public void cambiarTurno() {
        administradorDeTurno.pasarTurno();
    }
    public Jugador getJugadorActual() {
        return administradorDeTurno.getJugadorActual();
    }
    public Jugador getOponente() {return administradorDeTurno.getOponente();}

    public boolean terminado() {
        for (int i = 0; i<jugadores.size(); i++) {
            List<Pokemon> pokemones = jugadores.get(i).getPokemones();
            if (pokemones.isEmpty()) {
                viewControlador.mostrarGanador(jugadores.get((i+1)%2));
                return true;
            }
            int contador = 1;
            for (Pokemon pokemon : jugadores.get(i).getPokemones()) {
                if (!pokemon.estaMuerto()) {
                    break;
                }
                if (contador == jugadores.get(i).getPokemones().size()){
                    viewControlador.mostrarGanador(jugadores.get((i+1)%2));
                    return true;
                }
                contador++;
            }
        }
        return false;
    }

    public void comprobarPokemonActualEstaVivo(){
        Pokemon pokemon = getJugadorActual().getPokemonActual();
        ArrayList<Pokemon> pokemones = getJugadorActual().getPokemones();
        if (!pokemon.estaVivo()){
            viewControlador.mostrarPokemonMuerto(pokemon);
            while(true){
                int numeroPokemon = inputs.pedirPokemonMuerto(pokemones);
                boolean realizado = getJugadorActual().intercambiarPokemon(pokemones.get(numeroPokemon));
                if (realizado) {
                    viewControlador.mostrarCambioPokemon(getJugadorActual().getPokemonActual());
                    break;
                }
                viewControlador.errorIntercambiarPokemonSinVida();
            }
        }
    }
    public boolean aplicarEstado() {
        Pokemon pokemon = getJugadorActual().getPokemonActual();
        boolean aplicado = false;
        Estado estado = pokemon.getEstado();
        if (estado != null){
            aplicado = pokemon.aplicarEstado();
            viewControlador.mostrarEfectoEstado(estado, pokemon, aplicado);
            if (aplicado && !this.colaDeAtaques.isEmpty()){
                this.colaDeAtaques.remove();
            }
        }
        return aplicado;
    }
    public boolean rendirse(){
        Jugador jugador = getJugadorActual();
        jugador.rendirse();
        return true;
    }
    public boolean verCampo() {
        viewControlador.mostrarCampo(this.jugadores);
        return false;
    }

    public boolean usarItem() {
        Jugador jugadorActual = getJugadorActual();
        List<Item> items = jugadorActual.getItems();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        while(true){
            int numeroItem = inputs.pedirItem(items);
            if (numeroItem == volverAlMenu){
                return false;
            }
            viewControlador.opcionVolverAMenu();
            int numeroPokemon = inputs.pedirPokemon(pokemones);
            if (numeroPokemon == volverAlMenu){
                return false;
            }
            Item item = items.get(numeroItem);
            if (item.aplicarItem(jugadorActual.getPokemones().get(numeroPokemon))) {
                viewControlador.errorUsoItem(item);
            } else {
                viewControlador.mostrarUsoItem(jugadorActual, item, pokemones.get(numeroPokemon));
                return true;
            }
        }
    }


    public boolean cambiarPokemon(){
        Jugador jugadorActual = getJugadorActual();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        while (true) {
            viewControlador.opcionVolverAMenu();
            int numeroPokemon = inputs.pedirPokemon(pokemones);
            if (numeroPokemon == volverAlMenu) {
                return false;
            }
            if (jugadorActual.getPokemonActual() == pokemones.get(numeroPokemon)){
                viewControlador.errorPokemonActual();
                continue;
            }
            boolean realizado = jugadorActual.intercambiarPokemon(pokemones.get(numeroPokemon));
            if (realizado) {
                viewControlador.mostrarCambioPokemon(jugadorActual.getPokemonActual());
                return true;
            }
            viewControlador.errorIntercambiarPokemonSinVida();
        }
    }

    public boolean atacar() {
        Jugador jugadorActual = getJugadorActual();
        Pokemon pokemonActual = jugadorActual.getPokemonActual();
        while(true){
            int numeroHabilidad = inputs.pedirHabilidad(pokemonActual.getHabilidades());
            if (numeroHabilidad == volverAlMenu) {
                return false;
            }
            Habilidad habilidad = pokemonActual.getHabilidades().get(numeroHabilidad);
            if (habilidad.getCantidadDeUsos() == 0){
                System.out.println("Habilidad sin usos, elegir otra");
            } else {
                this.colaDeAtaques.add(habilidad);
                return true;
            }
        }
    }


    public void realizarAtaque(){
        Jugador jugadorActual = getJugadorActual();
        Pokemon pokemonActual = jugadorActual.getPokemonActual();
        Pokemon pokemonEnemigo = getOponente().getPokemonActual();
        if (!colaDeAtaques.isEmpty()){
            Habilidad habilidad = colaDeAtaques.poll();
            if (habilidad.usarHabilidad(pokemonActual, pokemonEnemigo)){
                viewControlador.errorHabilidadEstado();
            } else {
            viewControlador.mostrarAccion(habilidad,pokemonActual,pokemonEnemigo);
            }
        }
    }
}
