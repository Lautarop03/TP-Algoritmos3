package org.fiuba.algoritmos3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;


public class JuegoController {
    //TODO: Despues ver como hacer que funcione sin el public
    @FXML
    public Label nombre_actual_pk1;

    @FXML
    public ImageView img_pk1;

    @FXML
    public Label nombre_actual_pk2;

    @FXML
    public ImageView img_pk2;

    private Juego juego;

    //TODO: terminar de definir los atributos

    public void setJuego(Juego juego) {
        this.juego = juego;
        Jugador jugador1 = juego.getJugadorActual();
        Jugador jugador2 = juego.getOponente();
        this.nombre_actual_pk1.setText(jugador1.getPokemonActual().getNombre());
        this.nombre_actual_pk2.setText(jugador2.getPokemonActual().getNombre());
        Image pk1Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonBack/" + juego.getJugadorActual().getPokemonActual().getNombre() +"_back.png").toString());
        this.img_pk1.setImage(pk1Image);
        Image pk2Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonFront/" + juego.getOponente().getPokemonActual().getNombre() +"_front.png").toString());
        this.img_pk2.setImage(pk2Image);

        // TODO: aca seteo todos los datos de la pantalla
    }

    //TODO: una funcion setItems-Mochila-etc.. por cada escena que tengamos
}
