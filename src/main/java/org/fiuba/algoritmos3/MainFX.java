package org.fiuba.algoritmos3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.controller.JuegoController;
import org.fiuba.algoritmos3.controller.SingletonJuego;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.persistencia.JsonLectura;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        JsonLectura jsonLectura = new JsonLectura();
        List<Jugador> jugadores = jsonLectura.inicializarPartida();
        Juego juego = new Juego(jugadores);
        SingletonJuego.getInstancia().setJuego(juego);
        JuegoController juegoController = new JuegoController();
        stage.setResizable(false);
        stage.setTitle("Pokemon");
        stage.getIcons().add(new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonFront/Pikachu_front.png").toString()));
        juegoController.setStage(stage);
        juegoController.setJuego(juego);
    }
}