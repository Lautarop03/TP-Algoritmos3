package org.fiuba.algoritmos3;
import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;
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
        this.colaDeAtaques = new LinkedList<Habilidad>();
    }

    public boolean terminado() {
        for (int i = 0; i<jugadores.size(); i++) {
            List<Pokemon> pokemones = jugadores.get(i).getPokemones();
            if (pokemones.isEmpty()) {
                viewControlador.mostrarGanador(jugadores.get((i+1)%2));
                return true;
            }
            Integer contador = 1; //ACA HICE CAMBIOSS MATEX
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

    public boolean comprobarPokemonActualEstaVivo(){
        Pokemon pokemon = getJugadorActual().getPokemonActual();
        if (!pokemon.estaVivo()){
            viewControlador.mostrarPokemonMuerto(pokemon);
            return false;
        }
        return true;
    }


    public boolean aplicarEstado() {// TODO : Aplicar efectos de un pokemon
        Pokemon pokemon = getJugadorActual().getPokemonActual();//ACA HICE CAMBIOSS MATEX
        boolean aplicado = false;
        if (pokemon.getEstado() != null){
            aplicado = pokemon.aplicarEstado();
            if (aplicado){
                this.colaDeAtaques.remove();
                viewControlador.mostrarEfectoEstado();
            }
        }
        return aplicado;
    }
    public void cambiarTurno() {
        administradorDeTurno.pasarTurno();
    }
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public Jugador getJugadorActual() {
        return administradorDeTurno.getJugadorActual();
    }
    public Jugador getOponente() {return administradorDeTurno.getOponente();}

    public boolean rendirse(){
        Jugador jugador = getJugadorActual();
        jugador.rendirse();
        return true;
    }
    public boolean verCampo() {
        viewControlador.mostrarCampo(this.jugadores);  // TODO: MOSTRAR EL ESTADO DEL POKEMON(si tiene)
        return false;
    }

    public boolean usarItem() {
        Jugador jugadorActual = getJugadorActual();
        List<Item> items = jugadorActual.getItems();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        while(true){
            int numeroItem = inputs.pedirItem(items);
            if (numeroItem == volverAlMenu){ // El usuario vuelve atrás
                return false;
            }
            int numeroPokemon = inputs.pedirPokemon(pokemones);
            if (numeroPokemon == volverAlMenu){ // El usuario vuelve atrás
                return false;
            }
            Item item = items.get(numeroItem);
            if (!item.aplicarItem(jugadorActual.getPokemones().get(numeroPokemon))) {
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
            int numeroPokemon = inputs.pedirPokemonIntercambio(pokemones);
            if (numeroPokemon == volverAlMenu+1) {
                return false;
            }
            boolean realizado = jugadorActual.intercambiarPokemon(pokemones.get(numeroPokemon));
            if (!realizado) {
                viewControlador.errorIntercambiarPokemon();
            } else {
                viewControlador.mostrarCambioPokemon(jugadorActual.getPokemonActual());
                return true;
            }
        }
    }

    public boolean atacar() {
        Jugador jugadorActual = getJugadorActual();
        Pokemon pokemonActual = jugadorActual.getPokemonActual();
        Pokemon pokemonEnemigo = getOponente().getPokemonActual();//ACA HICE CAMBIOSS MATEX
        while(true){
            int numeroHabilidad = inputs.pedirHabilidad(pokemonActual.getHabilidades());
            if (numeroHabilidad == volverAlMenu) {
                return false;
            }
            Habilidad habilidad = pokemonActual.getHabilidades().get(numeroHabilidad);
            if (habilidad.getCantidadDeUsos() == 0){ //ver como comprobar de manera decente (no como hice yo) que la habilidad tenga usos restantes
                System.out.println("Habilidad sin usos, elegir otra");
            } else { // TODO: Aplicar el estado correspondiente
                this.colaDeAtaques.add(habilidad);
                return true;
            }
        }
    }
    public void realizarAtaque(){//ACA HICE CAMBIOSS MATEX
        Jugador jugadorActual = getJugadorActual();
        Pokemon pokemonActual = jugadorActual.getPokemonActual();
        Pokemon pokemonEnemigo = getOponente().getPokemonActual();
        if (!colaDeAtaques.isEmpty()){
            Habilidad habilidad = colaDeAtaques.poll();
            habilidad.usarHabilidad(pokemonActual,pokemonEnemigo);
            viewControlador.mostrarAccion(habilidad,pokemonActual,pokemonEnemigo);
        }
    }
}
