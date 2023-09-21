package org.fiuba.algoritmos3.pokemon;

import org.fiuba.algoritmos3.pokemon.Tipo;
import org.fiuba.algoritmos3.habilidades.Habilidad;
import org.fiuba.algoritmos3.pokemon.estados.Estado;


import java.util.List;

public class Pokemon {
    private String nombre;
    private Integer nivel;
    private Tipo tipo;
    private String historia;
    private Integer vidaMaxima;
    private Integer vidaActual;
    private Integer velocidad;
    private Integer defensa;
    private Integer ataque;
    private Estado estado;
    private List<Habilidad> habilidades;

    public String getNombre() {
        return nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getHistoria() {
        return historia;
    }

    public Integer getVidaMaxima() {
        return vidaMaxima;
    }

    public Integer getVidaActual() {
        return vidaActual;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public Integer getDefensa() {
        return defensa;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public Estado getEstado() {
        return estado;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }
}
