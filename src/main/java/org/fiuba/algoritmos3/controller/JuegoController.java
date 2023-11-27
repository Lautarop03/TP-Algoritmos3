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


public class JuegoController {
/*    @FXML
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
    private Label nivel_actual_pk2;*/

    private Juego juego;

    public MainFX mainFX;

    public Stage stage;
    public BattleMainController battleController;
    public Scene battleMain;
    public Scene mochila;
//    private HBox fondoBattleMain;

    public Scene seleccionarPokemon;

    //TODO: terminar de definir los atributos



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
//        List<Jugador> jugadores = juego.getJugadores();
//        Jugador jugador1 = jugadores.get(0);
//        Jugador jugador2 = jugadores.get(1);
//        Pokemon pk1 = jugador1.getPokemonActual();
//        Pokemon pk2 = jugador2.getPokemonActual();
//        this.nombre_actual_pk1.setText(pk1.getNombre());
//        this.nombre_actual_pk2.setText(pk2.getNombre());
//        this.vida_actual_max_pk1.setText(pk1.getVidaActual()+"/"+ pk1.getVidaMaxima());
//        this.vida_actual_max_pk2.setText(pk2.getVidaActual()+"/" + pk2.getVidaMaxima());
//        this.barra_vida_pk1.setProgress(porcentajeVidaPokemon(pk1));
//        this.barra_vida_pk2.setProgress(porcentajeVidaPokemon(pk2));
//        this.nivel_actual_pk1.setText("Lv:" + pk1.getNivel());
//        this.nivel_actual_pk2.setText("Lv:" + pk2.getNivel());
//        Image pk1Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonBack/" + pk1.getNombre() +"_back.png").toString());
//        this.img_pk1.setImage(pk1Image);
//        Image pk2Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonFront/" + pk2.getNombre() +"_front.png").toString());
//        this.img_pk2.setImage(pk2Image);
        battleController.setJuegoController(this);
        // TODO: aca seteo todos los datos de la pantalla
    }

    public double porcentajeVidaPokemon(Pokemon pokemon){
        double porcentaje = (double)pokemon.getVidaActual()/(double)pokemon.getVidaMaxima();
        return porcentaje;
    }

    public void handleAtaqueBtn(MouseEvent mouseEvent) {
/*        Image pk1Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonBack/" + juego.getOponente().getPokemones().get(3).getNombre() +"_back.png").toString());
        this.img_pk1.setImage(pk1Image);*/
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

    public void cambiarAEscenaMochila(MouseEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/fiuba/algoritmos3/plantillas/mochila.fxml"));

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
}