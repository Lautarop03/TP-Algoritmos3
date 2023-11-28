package org.fiuba.algoritmos3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.MainFX;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.io.IOException;
import java.util.Objects;


public class JuegoController {
    private Juego juego;

    public MainFX mainFX;

    public Stage stage;
    public BattleMainController battleController;
    private SeleccionPokemonController seleccionPokemonController;
    private MochilaController mochilaController;
    public Scene battleMain;
    public Scene mochila;
//    private HBox fondoBattleMain;

    public Scene seleccionarPokemon;





    public void setJuego(Juego juego) throws IOException {
        this.juego = juego;
        battleController = new BattleMainController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/battleMain.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root, 600, 450);
        stage.setScene(scene);
        stage.show();

        BattleMainController battleController = loader.getController();
        battleMain = battleController.setJuego(juego);
        battleController.setJuegoController(this);
    }

    public double porcentajeVidaPokemon(Pokemon pokemon){
        double porcentaje = (double)pokemon.getVidaActual()/(double)pokemon.getVidaMaxima();
        return porcentaje;
    }

    public void handleAtaqueBtn(MouseEvent mouseEvent) {
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
    public Juego getJuego() {
        return juego;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void cambiarAEscenaMochila(MouseEvent evento) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/fiuba/algoritmos3/plantillas/mochila.fxml")));

        Stage stage = (Stage)((Node) evento.getSource()).getScene().getWindow();
        Scene scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/mochila.fxml"));
        VBox root2 = loader.load();
        MochilaController mochilaController = loader.getController();
        mochilaController.setItems(juego.getJugadorActual().getItems(), stage);
    }

    public void cambiarAEscenaSeleccionPokemon(MouseEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/fiuba/algoritmos3/plantillas/seleccionPokemon.fxml"));
        Stage stage = (Stage)((Node) evento.getSource()).getScene().getWindow();
        Scene scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void cambiarAEscenaHuir(MouseEvent mouseEvent) {
    }

    public void cambiarAEscenaAtacar(MouseEvent mouseEvent) {
    }

    public Scene getBattleMain() {
        return battleMain;
    }
}