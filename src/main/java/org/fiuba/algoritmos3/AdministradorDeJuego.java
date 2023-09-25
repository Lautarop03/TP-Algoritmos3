package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.pokemon.Pokemon;
import org.fiuba.algoritmos3.pokemon.Tipo;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;

import java.util.List;

public class AdministradorDeJuego {
    public List<Pokemon> asignarPokemones() {
        Habilidad patada = new Habilidad("Patada",10,Tipo.Lucha);
        Habilidad trueno = new Habilidad("Trueno",8,Tipo.Electrico);
        Habilidad fuego = new Habilidad("Fuego",6,Tipo.Fuego);
        Habilidad agua = new Habilidad("Agua", 4, Tipo.Agua);
        List<Habilidad> habilidades = List.of(patada,trueno,fuego,agua);

        Pokemon pikachu = new Pokemon("Pikachu",15, Tipo.Electrico, "asd", 500,500,20,20,20,habilidades);
        Pokemon charmander = new Pokemon("Charmander",20, Tipo.Fuego, "asd", 600,600,25,10,15,habilidades);
        Pokemon bulbasur = new Pokemon("Bulbasur",17, Tipo.Planta, "asd", 1000,1000,10,25,5,habilidades);
        Pokemon squirtle = new Pokemon("Squirtle",20, Tipo.Agua, "asd", 400,400,30,15,28,habilidades);
        Pokemon pidgey = new Pokemon("Pidgey",15, Tipo.Normal, "asd", 500,500,20,10,25,habilidades);
        Pokemon nidoran = new Pokemon("Nidoran",30, Tipo.Veneno, "asd", 1200,1200,39,22,32,habilidades);

        List<Pokemon> pokemones = List.of(pikachu,charmander,bulbasur,squirtle,pidgey,nidoran);
        return pokemones;
    }

}
