package org.fiuba.algoritmos3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.MainFX;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class JuegoController {
    @FXML
    private Label nombre_actual_pk1;

    @FXML
    private ImageView img_pk1;

    @FXML
    private ProgressBar barra_vida_pk1;

    @FXML
    private Label vida_actual_max_pk1;

    @FXML
    private Label nivel_actual_pk1;

    @FXML
    private Label nombre_actual_pk2;

    @FXML
    private ImageView img_pk2;

    @FXML
    private ProgressBar barra_vida_pk2;

    @FXML
    private Label vida_actual_max_pk2;

    @FXML
    private Label nivel_actual_pk2;

    private Juego juego;

    public MainFX mainFX;
    public Stage stage;

    //TODO: terminar de definir los atributos

    public void setJuego(Juego juego) {
        this.juego = juego;
        List<Jugador> jugadores = juego.getJugadores();
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);
        Pokemon pk1 = jugador1.getPokemonActual();
        Pokemon pk2 = jugador2.getPokemonActual();
        this.nombre_actual_pk1.setText(pk1.getNombre());
        this.nombre_actual_pk2.setText(pk2.getNombre());
        this.vida_actual_max_pk1.setText(pk1.getVidaActual()+"/"+ pk1.getVidaMaxima());
        this.vida_actual_max_pk2.setText(pk2.getVidaActual()+"/" + pk2.getVidaMaxima());
        this.barra_vida_pk1.setProgress(porcentajeVidaPokemon(pk1));
        this.barra_vida_pk2.setProgress(porcentajeVidaPokemon(pk2));
        this.nivel_actual_pk1.setText("Lv:" + pk1.getNivel());
        this.nivel_actual_pk2.setText("Lv:" + pk2.getNivel());
        Image pk1Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonBack/" + pk1.getNombre() +"_back.png").toString());
        this.img_pk1.setImage(pk1Image);
        Image pk2Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonFront/" + pk2.getNombre() +"_front.png").toString());
        this.img_pk2.setImage(pk2Image);
        // TODO: aca seteo todos los datos de la pantalla
    }

    public double porcentajeVidaPokemon(Pokemon pokemon){
        double porcentaje = (double)pokemon.getVidaActual()/(double)pokemon.getVidaMaxima();
        return porcentaje;
    }

    public void handleAtaqueBtn(MouseEvent mouseEvent) {
        Image pk1Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonBack/" + juego.getOponente().getPokemones().get(3).getNombre() +"_back.png").toString());
        this.img_pk1.setImage(pk1Image);
    }

    public void handleMochilaBtn(MouseEvent mouseEvent) {
    }

    public void handlePokemonBtn(MouseEvent mouseEvent) {
    }

    public void handleHuirBtn(MouseEvent mouseEvent) {
    }

    public void setMainFX(MainFX mainFX) {
        this.mainFX = mainFX;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void cambiarAEscenaMochila(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/fiuba/algoritmos3/plantillas/mochila.fxml"));
        Stage stage = (Stage)((Node) evento.getSource()).getScene().getWindow();
        Scene scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //TODO: una funcion setItems-Mochila-etc.. por cada escena que tengamos
}
