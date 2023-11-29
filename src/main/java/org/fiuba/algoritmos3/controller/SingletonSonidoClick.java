package org.fiuba.algoritmos3.controller;


import javax.sound.sampled.Clip;
import java.io.IOException;

public class SingletonSonidoClick {
    private static SingletonSonidoClick instancia = null;
    private Clip clipSonidoClick;
    private SingletonSonidoClick() {}
    public static SingletonSonidoClick getInstancia() throws IOException {
        if (instancia == null) {
            instancia = new SingletonSonidoClick();
        }
        return instancia;
    }

    public void setClip(Clip clip){
        this.clipSonidoClick = clip;

    }

    public Clip getClip() {
        return clipSonidoClick;
    }
}
