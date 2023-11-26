package org.fiuba.algoritmos3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.controller.JuegoController;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.persistencia.JsonLectura;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        JsonLectura jsonLectura = new JsonLectura();
        List<Jugador> jugadores = jsonLectura.inicializarPartida();
        Juego juego = new Juego(jugadores);
        JuegoController juegoController = new JuegoController();
        juegoController.setStage(stage);
        juegoController.setJuego(juego);
        /*
        Scene scene = new Scene(root, 600, 450);

        stage.setScene(scene);
        stage.show();

        HBox pelea = (HBox) scene.lookup("#batalla");

        Image image = new Image(getClass().getResource("background/battlebgroute.jpg").toString());
        BackgroundImage bgImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        root.getHeight(), root.getWidth(), true, true, true, true)
        );

        Background bg = new Background(bgImage);
        pelea.setBackground(bg);*/

    }
}