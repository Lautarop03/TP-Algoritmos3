package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.items.*;
import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.Tipo;
import org.fiuba.algoritmos3.pokemon.estados.Dormido;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeDano;
import org.fiuba.algoritmos3.pokemon.habilidades.HabilidadDeEstado;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeJuego {
    public ArrayList<Pokemon> asignarPokemones() {
        Habilidad patada = new HabilidadDeDano("Patada",10,Tipo.Lucha, 80);
        Habilidad trueno = new HabilidadDeDano("Trueno",8,Tipo.Electrico, 70);
        Habilidad fuego = new HabilidadDeDano("Fuego",6,Tipo.Fuego, 100);
        Habilidad agua = new HabilidadDeDano("Agua", 4, Tipo.Agua, 50);
        Habilidad dormite = new HabilidadDeEstado("Dormite", 4, Tipo.Agua, new Dormido(5));


        List<Habilidad> habilidades = List.of(patada,trueno,fuego,agua, dormite);

        Pokemon pikachu = new Pokemon("Pikachu",15, Tipo.Electrico, "asd", 500,500,20,20,20,habilidades);
        Pokemon charmander = new Pokemon("Charmander",20, Tipo.Fuego, "asd", 600,0,25,10,15,habilidades);
        Pokemon bulbasur = new Pokemon("Bulbasur",17, Tipo.Planta, "asd", 1000,1000,10,25,5,habilidades);
        Pokemon squirtle = new Pokemon("Squirtle",20, Tipo.Agua, "asd", 400,400,30,15,28,habilidades);
        Pokemon pidgey = new Pokemon("Pidgey",15, Tipo.Normal, "asd", 500,500,20,10,25,habilidades);
        Pokemon nidoran = new Pokemon("Nidoran",30, Tipo.Veneno, "asd", 1200,1200,39,22,32,habilidades);

        ArrayList<Pokemon> pokemones = new ArrayList<>();
        pokemones.add(pikachu);
        pokemones.add(charmander);
        pokemones.add(bulbasur);
        pokemones.add(squirtle);
        pokemones.add(pidgey);
        pokemones.add(nidoran);
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
