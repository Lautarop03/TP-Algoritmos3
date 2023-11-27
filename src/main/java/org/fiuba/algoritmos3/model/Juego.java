package org.fiuba.algoritmos3.model;
import org.fiuba.algoritmos3.Inputs;
import org.fiuba.algoritmos3.model.clima.*;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeClima;
import org.fiuba.algoritmos3.views.ViewControlador;

import java.io.IOException;
import java.util.*;


public class Juego {
    private final AdministradorDeTurno administradorDeTurno;
    private final List<Jugador> jugadores;
    protected Queue<Habilidad> colaDeAtaques;
    private Clima clima;
    private AdministradorDeJuego administradorDeJuego;


    public Juego(List<Jugador> jugadores) throws IOException {
        this.jugadores = jugadores;
        this.administradorDeTurno = new AdministradorDeTurno(jugadores);
        this.colaDeAtaques = new LinkedList<>();
        this.administradorDeJuego = new AdministradorDeJuego(new Inputs(), new ViewControlador());
        this.clima = sorteoClima();
    }

    public Clima sorteoClima(){
        Random random = new Random();
        double numeroAleatorio2 = random.nextDouble();
        double climaBase = 0.66;

        if(numeroAleatorio2 > climaBase){
            return null;
        }

        Huracan huracan = new Huracan();
        Lluvia lluvia = new Lluvia();
        Niebla niebla = new Niebla();
        Soleado soleado = new Soleado();
        TormentaDeRayos tormentaDeRayos = new TormentaDeRayos();
        TormentaDeArena tormentaDeArena = new TormentaDeArena();
        List<Clima> climas = List.of(huracan,lluvia,niebla,soleado,tormentaDeRayos,tormentaDeArena);
        int largoLista = climas.size();
        int numeroAleatorio = (int)(Math.random()*(largoLista - 1));
        return climas.get(numeroAleatorio);
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
                administradorDeJuego.mostrarGanador(jugadores.get((i+1)%2)); //TODO: MODELO ACOPLADO A LA VISTA
                (jugadores.get((i+1)%2)).setGanador(true);
                return true;
            }
            int contador = 1;
            for (Pokemon pokemon : jugadores.get(i).getPokemones()) {
                if (pokemon.estaVivo()) {
                    break;
                }
                if (contador == jugadores.get(i).getPokemones().size()){
                    administradorDeJuego.mostrarGanador(jugadores.get((i+1)%2));  //TODO: MODELO ACOPLADO A LA VISTA
                    (jugadores.get((i+1)%2)).setGanador(true);
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
            administradorDeJuego.mostrarPokemonMuerto(pokemon);  //TODO: MODELO ACOPLADO A LA VISTA
            while(true){
                int numeroPokemon = administradorDeJuego.pedirCambioPokemonMuerto(pokemones);  //TODO: MODELO ACOPLADO A LA VISTA
                boolean realizado = getJugadorActual().intercambiarPokemon(pokemones.get(numeroPokemon));
                if (realizado) {
                    administradorDeJuego.mostrarCambioPokemon(getJugadorActual().getPokemonActual());  //TODO: MODELO ACOPLADO A LA VISTA
                    break;
                }
                administradorDeJuego.errorIntercambiarPokemonSinVida();
            }
        }
    }

    public boolean aplicarEstados() {
        Pokemon pokemon = getJugadorActual().getPokemonActual();
        List<Boolean> booleanEstados;
        List<Estado> estados = new ArrayList<>(pokemon.getEstados());
        boolean aplicado = false;
        if (!estados.isEmpty()){
            booleanEstados = pokemon.aplicarEstados();
            administradorDeJuego.mostrarEstadosAplicados(booleanEstados, estados,pokemon);  //TODO: MODELO ACOPLADO A LA VISTA
            if (booleanEstados.contains(true) && !this.colaDeAtaques.isEmpty()){
                this.colaDeAtaques.remove();
                aplicado = true;
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
        administradorDeJuego.mostrarCampo(this.jugadores,this.clima);  //TODO: MODELO ACOPLADO A LA VISTA
        return false;
    }

    public boolean usarItem() {
        Jugador jugadorActual = getJugadorActual();
        List<Item> items = jugadorActual.getItems();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        while(true){
            PaqueteDeRespuesta<Integer> paqueteItem = administradorDeJuego.pedirItem(items);  //TODO: MODELO ACOPLADO A LA VISTA
            if (!paqueteItem.getError()) {
                return false;
            }
            PaqueteDeRespuesta<Integer> paquetePokemon = administradorDeJuego.pedirPokemon(pokemones);  //TODO: MODELO ACOPLADO A LA VISTA
            if (!paquetePokemon.getError()) {
                return false;
            }
            Item item = items.get(paqueteItem.getGenerico());
            if (item.aplicarItem(jugadorActual.getPokemones().get(paquetePokemon.getGenerico()))) {
                administradorDeJuego.errorUsoItem(item);  //TODO: MODELO ACOPLADO A LA VISTA
            } else {
                  administradorDeJuego.mostrarUsoItem(jugadorActual, item, pokemones.get((int) paquetePokemon.getGenerico()));  //TODO: MODELO ACOPLADO A LA VISTA
                return true;
            }
        }
    }


    public boolean cambiarPokemon(){
        Jugador jugadorActual = getJugadorActual();
        ArrayList<Pokemon> pokemones = jugadorActual.getPokemones();
        while (true) {
            PaqueteDeRespuesta<Integer> paquetePokemon = administradorDeJuego.pedirPokemon(pokemones);  //TODO: MODELO ACOPLADO A LA VISTA
            if (!paquetePokemon.getError()) {
                return false;
            }
            if (jugadorActual.getPokemonActual() == pokemones.get(paquetePokemon.getGenerico())){
                administradorDeJuego.errorPokemonActual();  //TODO: MODELO ACOPLADO A LA VISTA
                continue;
            }
            boolean realizado = jugadorActual.intercambiarPokemon(pokemones.get(paquetePokemon.getGenerico()));
            if (realizado) {
                administradorDeJuego.mostrarCambioPokemon(jugadorActual.getPokemonActual());  //TODO: MODELO ACOPLADO A LA VISTA
                return true;
            }
            administradorDeJuego.errorIntercambiarPokemonSinVida();  //TODO: MODELO ACOPLADO A LA VISTA
        }
    }

    public boolean atacar() {
        Jugador jugadorActual = getJugadorActual();
        Pokemon pokemonActual = jugadorActual.getPokemonActual();
        PaqueteDeRespuesta<Habilidad> paqueteHabilidad = administradorDeJuego.pedirHabilidad(pokemonActual);  //TODO: MODELO ACOPLADO A LA VISTA
        if(!paqueteHabilidad.getError()){
            return false;
        }
        Habilidad habilidad = paqueteHabilidad.getGenerico();
        this.colaDeAtaques.add(habilidad);
        return true;
    }

    public void realizarAtaque(){
        Jugador jugadorActual = getJugadorActual();
        Pokemon pokemonActual = jugadorActual.getPokemonActual();
        Pokemon pokemonEnemigo = getOponente().getPokemonActual();
        if (!colaDeAtaques.isEmpty()){
            Habilidad habilidad = colaDeAtaques.poll();
            if (habilidad.usarHabilidad(pokemonActual, pokemonEnemigo)){
                administradorDeJuego.errorHabilidadEstado();  //TODO: MODELO ACOPLADO A LA VISTA
            } else {
                if(habilidad instanceof HabilidadDeClima){
                    setClima(((HabilidadDeClima) habilidad).getClima());
                }
                administradorDeJuego.mostrarAccion(habilidad,pokemonActual,pokemonEnemigo);  //TODO: MODELO ACOPLADO A LA VISTA
            }
        }
    }

    public void aplicarClima(){
        if (clima != null) {
            Pokemon pokemonActual = getJugadorActual().getPokemonActual();
            Pokemon pokemonEnemigo = getOponente().getPokemonActual();
            if (!clima.aplicarClima(pokemonActual,pokemonEnemigo)){
                setClima(null);
            }
        }
    }

    public void setClima(Clima climaNuevo) {
        if (clima != null){
            Pokemon pokemonActual = getJugadorActual().getPokemonActual();
            Pokemon pokemonEnemigo = getOponente().getPokemonActual();
            clima.quitarBeneficios(pokemonActual,pokemonEnemigo);
        }
        this.clima = climaNuevo;
    }

    public void setAdministradorDeJuego(AdministradorDeJuego administradorDeJuego) {
        this.administradorDeJuego = administradorDeJuego;
    }

    public Clima getClima() {
        return clima;
    }

    public List<Jugador> getJugadores(){
        return jugadores;
    }
}
