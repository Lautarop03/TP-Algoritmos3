package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.model.clima.TormentaDeRayos;
import org.fiuba.algoritmos3.model.items.*;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.Tipo;
import org.fiuba.algoritmos3.model.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.model.pokemon.estados.Envenenado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.*;

import java.util.ArrayList;
import java.util.List;

public class CargarPokemons {

    public List<Habilidad> asignarHabilidades(){
        Habilidad trueno = new HabilidadDeDano("Trueno",8,Tipo.Electrico, 70);
        Habilidad envenenar = new HabilidadDeEstado("Envenenar",6,Tipo.Veneno, new Envenenado());
        Habilidad debuff = new HabilidadDeEstadisticaAtaque("Debuffear", 4, Tipo.Normal, -10);
        Habilidad dormido = new HabilidadDeEstado("Dormido",3,Tipo.Electrico,new Dormido());
        Habilidad TormentaDeRayos = new HabilidadDeClima("TormentaDeRayos", 4, Tipo.Electrico, new TormentaDeRayos());
        return List.of(trueno,envenenar,debuff,TormentaDeRayos,dormido);
    }

    public ArrayList<Pokemon> asignarPokemonesJugador1() {

        Pokemon pikachu = new Pokemon("Pikachu",50, Tipo.Electrico, "asd", 35,35,90,40.0,55.0, asignarHabilidades());
        Pokemon charizard = new Pokemon("Charizard",50, Tipo.Fuego, "asd", 78,78,100,78.0,84.0, asignarHabilidades());
        Pokemon venusaur = new Pokemon("Venusaur",50, Tipo.Planta, "asd", 80,80,80,83.0,82.0, asignarHabilidades());
        Pokemon blastoise = new Pokemon("Blastoise",50, Tipo.Agua, "asd", 79,79,78,100.0,83.0, asignarHabilidades());
        Pokemon pidgeot = new Pokemon("Pidgeot",50, Tipo.Volador, "asd", 83,83,101,75.0,80.0, asignarHabilidades());
        Pokemon nidoqueen = new Pokemon("Nidoqueen",50, Tipo.Veneno, "asd", 90,90,76,87.0,92.0, asignarHabilidades());

        ArrayList<Pokemon> pokemones = new ArrayList<>();
        pokemones.add(pikachu);
        pokemones.add(charizard);
        pokemones.add(venusaur);
        pokemones.add(blastoise);
        pokemones.add(pidgeot);
        pokemones.add(nidoqueen);
        return pokemones;
    }
    public ArrayList<Pokemon> asignarPokemonesJugador2() {

        Pokemon poliwrath = new Pokemon("Poliwrath",50, Tipo.Agua, "asd", 90,90,70,95.0,95.0, asignarHabilidades());
        Pokemon alakazam = new Pokemon("Alakazam",50, Tipo.Psiquico, "asd", 55,55,120,45.0,50.0, asignarHabilidades());
        Pokemon electrode = new Pokemon("Electrode",50, Tipo.Electrico, "asd", 60,60,140,70.0,50.0, asignarHabilidades());
        Pokemon rayquaza = new Pokemon("Rayquaza",50, Tipo.Dragon, "asd", 105,105,95,90.0,150.0, asignarHabilidades());
        Pokemon sceptile = new Pokemon("Sceptile",50, Tipo.Planta, "asd", 70,70,120,65.0,85.0, asignarHabilidades());
        Pokemon lanturn = new Pokemon("Lanturn",50, Tipo.Agua, "asd", 125,125,67,58.0,58.0, asignarHabilidades());

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
        Pocion pocion = new Pocion(1);
        MegaPocion megaPocion = new MegaPocion(1);
        Hiperpocion hiperPocion = new Hiperpocion(1);
        PocionMolestaAlumnos posicionMolestaAlumnos = new PocionMolestaAlumnos(1);
        Revivir revivir = new Revivir(1);
        CuraTodo curaTodo = new CuraTodo(1);
        ItemModificadorDefensa modificadorDefensa = new ItemModificadorDefensa(1);
        ItemModificadorAtaque modificadorAtaque = new ItemModificadorAtaque(1);

        List<Item> items = List.of(modificadorAtaque,modificadorDefensa, pocion, revivir, curaTodo, megaPocion, hiperPocion, posicionMolestaAlumnos);

        return items;
    }
}

