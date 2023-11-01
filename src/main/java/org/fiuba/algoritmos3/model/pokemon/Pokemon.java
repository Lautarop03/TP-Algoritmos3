package org.fiuba.algoritmos3.model.pokemon;

import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String nombre;
    private Integer nivel;
    private Tipo tipo;
    private String historia;
    private Integer vidaMaxima;
    private Integer vidaActual;
    private Integer velocidad;
    private Double defensa;
    private Double ataque;
    private List<Estado> estados;
    private final List<Habilidad> habilidades;

    public Pokemon(String nombre, Integer nivel, Tipo tipo, String historia, Integer vidaMaxima, Integer vidaActual, Integer velocidad, Double defensa, Double ataque, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.historia = historia;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaActual;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.estados = new ArrayList<Estado>();
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
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
    public boolean aplicarEstados() {
        boolean aplicado = false;
        for (Estado estadoActual : estados) {
            if (estadoActual.aplicarEfecto(this)) {
                aplicado = true;
            }
        }
        return aplicado;
    }

    public void bajarVida(Integer vidaQuitada){
        int vidaNueva = this.vidaActual - vidaQuitada;
        if (vidaNueva < 0) {
            this.vidaActual = 0;
        } else {
            this.setVidaActual(vidaNueva);
        }
    }

    public boolean estaMuerto(){
        return (this.vidaActual == 0);
    }

    public boolean tieneVidaLlena() {
        return (this.vidaActual == this.vidaMaxima);
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public Double getDefensa() {
        return defensa;
    }

    public void setDefensa(Double defensa) {
        this.defensa = defensa;
    }

    public Double getAtaque() {
        return ataque;
    }

    public void setAtaque(Double ataque) {
        this.ataque = ataque;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void quitarEstados(){
        this.estados = null;
    }
    public void quitarEstado(Estado estado) {
        estados.remove(estado);
    }

    public boolean setEstado(Estado estado) {
        if (!estados.contains(estado)) {
            estados.add(estado);
            return true;
        }
        return false;
    }

    public boolean estaVivo() {
        return this.vidaActual > 0;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

}
