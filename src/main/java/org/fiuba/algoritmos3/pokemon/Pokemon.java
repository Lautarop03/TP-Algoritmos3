package org.fiuba.algoritmos3.pokemon;

import org.fiuba.algoritmos3.pokemon.estados.Estado;
import org.fiuba.algoritmos3.pokemon.habilidades.Habilidad;

import java.util.Collections;
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
    private List<Estado> estados;
    private List<Habilidad> habilidades;

    public Pokemon(String nombre, Integer nivel, Tipo tipo, String historia, Integer vidaMaxima, Integer vidaActual, Integer velocidad, Integer defensa, Integer ataque, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.historia = historia;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaActual;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.estados = Collections.emptyList();
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Integer getVidaMaxima() {
        return vidaMaxima;
    }

    public Integer getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(Integer vidaActual) {
        this.vidaActual = vidaActual;
    }

    public void sumarVida(Integer vidaAgregada) {
        Integer vidaNueva = this.vidaActual + vidaAgregada;
        if (vidaNueva > this.vidaMaxima) {
            vidaNueva = this.vidaMaxima;
        }
        this.setVidaActual(vidaNueva);
    }
    public void aplicarEstado() {
        for (Estado estado : this.estados) {
            estado.aplicarEfecto(this);
        }
    }

    public void bajarVida(Integer vidaQuitada){
        Integer vidaNueva = this.vidaActual - vidaQuitada;
        if (vidaNueva < 0) {
            this.vidaActual = 0;
        } else {
            this.setVidaActual(vidaNueva);
        }
    }

    public boolean estaMuerto(){
        return (this.vidaActual == 0);
    }


    public Boolean tieneVidaLlena() {
        return (this.vidaActual == this.vidaMaxima);
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public Integer getDefensa() {
        return defensa;
    }

    public void setDefensa(Integer defensa) {
        this.defensa = defensa;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void quitarEstados(){
        this.estados.clear();
    }

    public boolean setEstado(Estado estado) {
        if (!this.estados.contains(estado)) { //si no funciona: 'getClass()' o 'instanceof'
            this.estados.add(estado);
            return true;
        } else {
            return false;
        }
    }

    public boolean estaVivo() {
        return this.vidaActual > 0;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }
}
