package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.items.*;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.Tipo;
import org.fiuba.algoritmos3.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeDano;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeEstadisticaAtaque;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeEstado;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeJuego {

    public List<Habilidad> asginarHabilidades(){
        Habilidad patada = new HabilidadDeDano("Patada",10,Tipo.Lucha, 80);
        Habilidad trueno = new HabilidadDeDano("Trueno",8,Tipo.Electrico, 70);
        Habilidad fuego = new HabilidadDeDano("Fuego",6,Tipo.Fuego, 100);
        Habilidad agua = new HabilidadDeDano("Agua", 4, Tipo.Agua, 50);
        Habilidad buff = new HabilidadDeEstadisticaAtaque("Buffear", 4, Tipo.Normal, 10);
        Habilidad dormite = new HabilidadDeEstado("Dormite", 4, Tipo.Agua, new Dormido());
        return List.of(patada,trueno,fuego,agua,buff,dormite);
    }

    public ArrayList<Pokemon> asignarPokemones() {

        Pokemon pikachu = new Pokemon("Pikachu",15, Tipo.Electrico, "asd", 500,500,20,20,20,asginarHabilidades());
        Pokemon charmander = new Pokemon("Charmander",20, Tipo.Fuego, "asd", 600,0,25,10,15,asginarHabilidades());
        Pokemon bulbasur = new Pokemon("Bulbasur",17, Tipo.Planta, "asd", 1000,1000,10,25,5,asginarHabilidades());
        Pokemon squirtle = new Pokemon("Squirtle",20, Tipo.Agua, "asd", 400,400,30,15,28,asginarHabilidades());
        Pokemon pidgey = new Pokemon("Pidgey",15, Tipo.Normal, "asd", 500,500,20,10,25,asginarHabilidades());
        Pokemon nidoran = new Pokemon("Nidoran",30, Tipo.Veneno, "asd", 1200,1200,39,22,32,asginarHabilidades());

        ArrayList<Pokemon> pokemones = new ArrayList<>();
        pokemones.add(pikachu);
        pokemones.add(charmander);
        pokemones.add(bulbasur);
        pokemones.add(squirtle);
        pokemones.add(pidgey);
        pokemones.add(nidoran);
        return pokemones;
    }
    public ArrayList<Pokemon> asignarPokemones2() {

        Pokemon togekiss = new Pokemon("togekiss",15, Tipo.Electrico, "asd", 500,500,20,20,20,asginarHabilidades());
        Pokemon golem = new Pokemon("golem",20, Tipo.Fuego, "asd", 600,0,25,10,15,asginarHabilidades());
        Pokemon voltorb = new Pokemon("voltorb",17, Tipo.Planta, "asd", 1000,1000,10,25,5,asginarHabilidades());
        Pokemon rayquaza = new Pokemon("rayquaza",20, Tipo.Agua, "asd", 400,400,30,15,28,asginarHabilidades());
        Pokemon sceptile = new Pokemon("sceptile",15, Tipo.Normal, "asd", 500,500,20,10,25,asginarHabilidades());
        Pokemon lanturn = new Pokemon("lanturn",30, Tipo.Veneno, "asd", 1200,1200,39,22,32,asginarHabilidades());

        ArrayList<Pokemon> pokemones = new ArrayList<>();
        pokemones.add(togekiss);
        pokemones.add(golem);
        pokemones.add(voltorb);
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

