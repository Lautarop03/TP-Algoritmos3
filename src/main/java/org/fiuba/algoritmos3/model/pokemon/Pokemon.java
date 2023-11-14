package org.fiuba.algoritmos3.model.pokemon;

import com.google.gson.annotations.JsonAdapter;
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
    private List<Habilidad> habilidades;

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

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Nivel: ").append(nivel).append("\n");
        sb.append("Tipo: ").append(tipo).append("\n");
        sb.append("Historia: ").append(historia).append("\n");
        sb.append("Vida Máxima: ").append(vidaMaxima).append("\n");
        sb.append("Vida Actual: ").append(vidaActual).append("\n");
        sb.append("Velocidad: ").append(velocidad).append("\n");
        sb.append("Defensa: ").append(defensa).append("\n");
        sb.append("Ataque: ").append(ataque).append("\n");

        sb.append("Estados: ");
        if (estados == null || estados.isEmpty()) {
            sb.append("Ninguno");
        } else {
            for (Estado estado : estados) {
                sb.append(estado).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());  // Elimina la coma y el espacio al final
        }
        sb.append("\n");

        sb.append("Habilidades: ");
        if (habilidades == null || habilidades.isEmpty()) {
            sb.append("Ninguna");
        } else {
            for (Habilidad habilidad : habilidades) {
                sb.append(habilidad).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());  // Elimina la coma y el espacio al final
        }
        sb.append("\n");

        return sb.toString();
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
    public List<Boolean> aplicarEstados() {
        List<Boolean> aplicados = new ArrayList<>();
        boolean aplicado;
        Integer iterador = 0;
        while(this.estaVivo() && iterador < estados.size()){
            aplicado = false;
            Estado estadoActual = estados.get(iterador);
            if (estadoActual.aplicarEfecto(this)) {
                aplicado = true;
            }
            aplicados.add(aplicado);
            iterador += 1;
        }
        return aplicados;
    }

    public void bajarVida(Integer vidaQuitada){
        int vidaNueva = this.vidaActual - vidaQuitada;
        if (vidaNueva <= 0) {
            this.vidaActual = 0;
            this.quitarEstados();
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
        this.estados.clear();
    }
    public void quitarEstado(Estado estado) {
        estados.remove(estado);
    }

    public boolean setEstado(Estado estado) {
        for (Estado estadoActual : estados) {
            if (estadoActual.getClass() == estado.getClass()) {
                return false;
            }
        }
        estados.add(estado);
        return true;
    }

    public boolean estaVivo() {
        return this.vidaActual > 0;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

}
