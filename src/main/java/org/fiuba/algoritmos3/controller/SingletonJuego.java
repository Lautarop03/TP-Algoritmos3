package org.fiuba.algoritmos3.controller;

import org.fiuba.algoritmos3.model.Juego;

import java.io.IOException;

public class SingletonJuego {
    private static SingletonJuego instancia = null;
    private Juego juego;
    private SingletonJuego() {}
    public static SingletonJuego getInstancia() throws IOException {
        if (instancia == null) {
            instancia = new SingletonJuego();
        }
        return instancia;
    }
    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    public Juego getJuego() {
        return juego;
    }
}
