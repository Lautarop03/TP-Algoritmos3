package org.fiuba.algoritmos3.model;

import org.fiuba.algoritmos3.model.items.*;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.model.pokemon.estados.Envenenado;
import org.fiuba.algoritmos3.model.pokemon.estados.Paralizado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeDano;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeEstadisticaAtaque;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeEstado;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeJuego {

    public List<Habilidad> asginarHabilidades(){
        Habilidad patada = new HabilidadDeDano("Patada",10,Tipo.Lucha, 80);
        Habilidad trueno = new HabilidadDeDano("Trueno",8,Tipo.Electrico, 70);
        Habilidad fuego = new HabilidadDeEstado("Paralizar",6,Tipo.Fuego, new Paralizado());
        Habilidad agua = new HabilidadDeEstado("Envenenar", 4, Tipo.Agua,new Envenenado());
        Habilidad buff = new HabilidadDeEstadisticaAtaque("Buffear", 4, Tipo.Normal, 10);
        Habilidad dormite = new HabilidadDeEstado("Dormite", 4, Tipo.Agua, new Dormido());
        return List.of(patada,trueno,fuego,agua,buff,dormite);
    }

    public ArrayList<Pokemon> asignarPokemones() {

        Pokemon pikachu = new Pokemon("Pikachu",15, Tipo.Electrico, "asd", 35,35,90,40.0,55.0,asginarHabilidades());
        Pokemon charizard = new Pokemon("Charizard",20, Tipo.Fuego, "asd", 78,78,100,78.0,84.0,asginarHabilidades());
        Pokemon venusaur = new Pokemon("Venusaur",17, Tipo.Planta, "asd", 80,80,80,83.0,82.0,asginarHabilidades());
        Pokemon blastoise = new Pokemon("Blastoise",20, Tipo.Agua, "asd", 79,79,78,100.0,83.0,asginarHabilidades());
        Pokemon pidgeot = new Pokemon("Pidgeot",15, Tipo.Volador, "asd", 83,83,101,75.0,80.0,asginarHabilidades());
        Pokemon nidoqueen = new Pokemon("Nidoqueen",30, Tipo.Veneno, "asd", 90,90,76,87.0,92.0,asginarHabilidades());

        ArrayList<Pokemon> pokemones = new ArrayList<>();
        pokemones.add(pikachu);
        pokemones.add(charizard);
        pokemones.add(venusaur);
        pokemones.add(blastoise);
        pokemones.add(pidgeot);
        pokemones.add(nidoqueen);
        return pokemones;
    }
    public ArrayList<Pokemon> asignarPokemones2() {

        Pokemon poliwrath = new Pokemon("Poliwrath",15, Tipo.Agua, "asd", 90,90,70,95.0,95.0,asginarHabilidades());
        Pokemon alakazam = new Pokemon("Alakazam",20, Tipo.Psiquico, "asd", 55,55,120,45.0,50.0,asginarHabilidades());
        Pokemon electrode = new Pokemon("Electrode",17, Tipo.Electrico, "asd", 60,60,140,70.0,50.0,asginarHabilidades());
        Pokemon rayquaza = new Pokemon("Rayquaza",20, Tipo.Dragon, "asd", 105,105,95,90.0,150.0,asginarHabilidades());
        Pokemon sceptile = new Pokemon("Sceptile",15, Tipo.Planta, "asd", 70,70,120,65.0,85.0,asginarHabilidades());
        Pokemon lanturn = new Pokemon("Lanturn",30, Tipo.Agua, "asd", 125,125,67,58.0,58.0,asginarHabilidades());

        ArrayList<Pokemon> pokemones = new ArrayList<>();
        pokemones.add(poliwrath);
        pokemones.add(alakazam);
        pokemones.add(electrode);
        pokemones.add(rayquaza);
        pokemones.add(sceptile);
        pokemones.add(lanturn);
        return pokemones;
    }

    public List<Item> asignarItems(){
        Pocion pocion = new Pocion(5);
        MegaPocion megaPocion = new MegaPocion(5);
        Hiperpocion hiperPocion = new Hiperpocion(5);
        Revivir revivir = new Revivir(8);
        CuraTodo curaTodo = new CuraTodo(6);
        ItemModificadorDefensa modificadorDefensa = new ItemModificadorDefensa(10);
        ItemModificadorAtaque modificadorAtaque = new ItemModificadorAtaque(10);

        List<Item> items = List.of(modificadorAtaque,modificadorDefensa, pocion, revivir, curaTodo, megaPocion, hiperPocion);

        return items;
    }
}

