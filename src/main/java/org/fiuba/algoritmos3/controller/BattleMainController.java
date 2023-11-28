package org.fiuba.algoritmos3.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.PaqueteDeRespuesta;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BattleMainController {

    @FXML
    private HBox fondoBattleMain;
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

    @FXML
    private Label habilidadLabel0;
    @FXML
    private Label habilidadLabel1;
    @FXML
    private Label habilidadLabel2;
    @FXML
    private Label habilidadLabel3;
    @FXML
    private Label tipoLabel;
    @FXML
    private Label usosRestantesLabel;
    @FXML
    private Label consola;
    @FXML
    private GridPane botonesContainer;
    @FXML
    private GridPane habilidadesContainer;
    @FXML
    private GridPane descripcionHabilidadesContainer;


    public Scene battleMainScene;

    private Juego juego;

    private JuegoController juegoController;

    private List<Habilidad> habilidades;
    private List<Label> labelsHabilidades;

    public Scene setJuego(Juego juego) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/battleMain.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root, 600, 450);


        Image image = new Image(getClass().getResource("/org/fiuba/algoritmos3/background/battlebgroute.jpg").toString());
        BackgroundImage bgImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true)
        );
        BackgroundFill bgf = new BackgroundFill(
                Color.WHITE,
                new CornerRadii(0),
                new Insets(0));
        Background bg = new Background(Collections.singletonList(bgf), Collections.singletonList(bgImage));
        fondoBattleMain.setBackground(bg);



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
        this.nivel_actual_pk1.setText("Nv:" + pk1.getNivel());
        this.nivel_actual_pk2.setText("Nv:" + pk2.getNivel());
        Image pk1Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonBack/" + pk1.getNombre() +"_back.png").toString());
        this.img_pk1.setImage(pk1Image);
        Image pk2Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonFront/" + pk2.getNombre() +"_front.png").toString());
        this.img_pk2.setImage(pk2Image);
        this.habilidades = juego.getJugadorActual().getPokemonActual().getHabilidades();
        this.labelsHabilidades = List.of(habilidadLabel0, habilidadLabel1, habilidadLabel2, habilidadLabel3);
        return scene;
        // TODO: aca seteo todos los datos de la pantalla
    }



    public double porcentajeVidaPokemon(Pokemon pokemon){
        double porcentaje = (double)pokemon.getVidaActual()/(double)pokemon.getVidaMaxima();
        return porcentaje;
    }

    public Scene getBattleMainScene() {
        return battleMainScene;
    }

    public void handleAtaqueBtn(MouseEvent mouseEvent) {
//        juegoController.cambiarAEscenaAtacar(mouseEvent);
        consola.setVisible(false);
        botonesContainer.setVisible(false);
        habilidadesContainer.setVisible(true);
        descripcionHabilidadesContainer.setVisible(true);

        for (int i = 0; i < habilidades.size(); i++) {
            Label label = labelsHabilidades.get(i);
            Habilidad habilidad = habilidades.get(i);
            label.setText(habilidad.getNombre());
        }
    }

    @FXML
    public void handleHabilidadLabelClick(MouseEvent event) throws IOException {
        Label source = (Label) event.getSource();
        String labelId = source.getId();

        int numeroHabilidad = Integer.parseInt(labelId.substring(labelId.length() - 1));
        Habilidad habilidad = juego.getJugadorActual().getPokemonActual().getHabilidades().get(numeroHabilidad);
        juego.atacar(new PaqueteDeRespuesta<>(true,habilidad));
        juego.realizarAtaque();
        setJuego(juego);
        consola.setVisible(true);
        botonesContainer.setVisible(true);
        habilidadesContainer.setVisible(false);
        descripcionHabilidadesContainer.setVisible(false);
    }
    public void hoverHabilidad(MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        Integer idHabilidad = Integer.parseInt(label.getId().replace("habilidadLabel", ""));

        Habilidad habilidad = habilidades.get(idHabilidad);

        tipoLabel.setText("Tipo: " + habilidad.getTipo().toString());
        usosRestantesLabel.setText("Usos restantes: " + habilidad.getCantidadDeUsos().toString());
    }

    public void handleMochilaBtn(MouseEvent mouseEvent) throws IOException {
        juegoController.cambiarAEscenaMochila(mouseEvent);

    }

    public void handlePokemonBtn(MouseEvent mouseEvent) throws IOException{
        juegoController.cambiarAEscenaSeleccionPokemon(mouseEvent);
    }

    public void handleHuirBtn(MouseEvent mouseEvent) {
        juegoController.cambiarAEscenaHuir(mouseEvent);
    }



    public void setJuegoController(JuegoController juegoController) {
        this.juegoController = juegoController;
    }
}
