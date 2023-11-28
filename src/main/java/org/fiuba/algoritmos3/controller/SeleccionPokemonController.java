package org.fiuba.algoritmos3.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class SeleccionPokemonController {

        @FXML
        private ProgressBar barra_vida_actual;


        @FXML
        private ImageView img_actual;



        @FXML
        private Label nivel_actual;

        @FXML
        private Label nombre_actual;



        @FXML
        private Label vida_actual;


        public JuegoController juegoController;
        private ArrayList<Pokemon> pokemones;
        private Pokemon pokemonActual;

        public VBox contenedorPrincipal;

        public HBox seleccionPokemon;

        public VBox pokemonConteiner;
        public Label descripcionPokemon;

        @FXML
        void handleMochilaBtn(MouseEvent evento) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/battleMain.fxml"));
                Parent root = loader.load();

                BattleMainController controller = loader.getController();
                controller.setJuego(SingletonJuego.getInstancia().getJuego());

                Stage stage = (Stage)((Node) evento.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
        }
        public void setJuegoController(JuegoController juegoController) {
            this.juegoController = juegoController;
        }
        public void setPokemones(ArrayList<Pokemon> pokemones, Stage stage, Pokemon pokemonActual) {
                this.pokemones = pokemones;
                this.pokemonActual = pokemonActual;
                for (Integer i = 0; i <pokemones.size(); i++) {
                        if (pokemones.get(i) != pokemonActual) {
                                Pokemon pokemon = pokemones.get(i);
                                mostrarPokemones(pokemon, i);
                        }
                }
                pokemonConteiner.setPrefHeight(350);

                mostrarPokemonActual();
                Scene scene =  new Scene(contenedorPrincipal);
                stage.setScene(scene);
                stage.show();
        }


        private void mostrarPokemones(Pokemon pokemon, Integer id ) {
                VBox vbox = new VBox(1);
                vbox.setPadding(new Insets(1));
                vbox.getChildren().add(crearHbox(pokemon,id));
                this.pokemonConteiner.getChildren().add(vbox);

        }

        public HBox crearHbox(Pokemon pokemon,Integer id){
                Pane paneIzquierdo = new Pane();

                ImageView imagePokemon = new ImageView(getClass().getResource("/org/fiuba/algoritmos3/background/mochila.png").toString());
                imagePokemon.setFitWidth(70);
                imagePokemon.setPreserveRatio(true);
                imagePokemon.setLayoutX(-10);
                imagePokemon.setTranslateY(-10);


                Label labelNombre = new Label(pokemon.getNombre());
                labelNombre.setLayoutX(80);
                labelNombre.setStyle("-fx-font-size: 15px;");

                Label labelNivel = new Label("Nv: " + pokemon.getNivel());
                labelNivel.setTranslateY(15);
                labelNivel.setLayoutX(80);

                paneIzquierdo.getChildren().addAll(imagePokemon, labelNombre, labelNivel);

//________________________________
                Pane paneDerecho = new Pane();

                ImageView imageView = new ImageView(getClass().getResource("/org/fiuba/algoritmos3/background/ps.png").toString());
                imageView.setFitWidth(25);
                imageView.setPreserveRatio(true);
                imageView.setLayoutX(35);

                Label labelVida = new Label(pokemon.getVidaActual() +" / "+ pokemon.getVidaMaxima() );
                labelVida.setLayoutX(120);
                labelVida.setLayoutY(15);

                ProgressBar progressBar = new ProgressBar(porcentajeVidaPokemon(pokemon));
                progressBar.setLayoutX(60);

                paneDerecho.getChildren().addAll(imageView, progressBar, labelVida);


                HBox hbox = new HBox(10);
                hbox.getChildren().addAll(paneIzquierdo, paneDerecho);
                hbox.setPadding(new Insets(10));
                hbox.setStyle("-fx-background-color: #00A8BF; -fx-background-radius: 2;" +
                        "-fx-border-color: black; -fx-border-width: 1;");

                hbox.setId(id.toString());
                hbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                                hoverPokemon(mouseEvent, Integer.parseInt(hbox.getId()));
                        }
                });
                hbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                                clickPokemon(mouseEvent, pokemon);
                        }
                });

                return hbox;
        }

        private void mostrarPokemonActual(){
                this.nombre_actual.setText(pokemonActual.getNombre());
                this.nivel_actual.setText("Nv: " + pokemonActual.getNivel());
                this.vida_actual.setText(pokemonActual.getVidaActual()+"/"+ pokemonActual.getVidaMaxima());
                this.barra_vida_actual.setProgress(porcentajeVidaPokemon(pokemonActual));
                Image image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonBack/" + pokemonActual.getNombre() +"_back.png").toString());
                this.img_actual.setImage(image);
        }

        public double porcentajeVidaPokemon(Pokemon pokemon){
                double porcentaje = (double)pokemon.getVidaActual()/(double)pokemon.getVidaMaxima();
                return porcentaje;
        }

        public void hoverPokemon(MouseEvent mouseEvent, Integer id){
                Pokemon pokemon = pokemones.get(id);
                descripcionPokemon.setText(" Vas a seleccionar a "+ pokemon.getNombre());
                descripcionPokemon.setStyle(" -fx-font-family: 'Arial'; -fx-font-size: 25; " +
                        "-fx-border-color: black; -fx-border-radius: 2; -fx-border-width: 5");

        }

        public void clickPokemon(MouseEvent mouseEvent, Pokemon pokemon){

                Stage stage = (Stage) contenedorPrincipal.getScene().getWindow();

                Alert.AlertType tipo = Alert.AlertType.CONFIRMATION;
                Alert alerta = new Alert(tipo, "");

                alerta.initModality(Modality.APPLICATION_MODAL);
                alerta.initOwner(stage);

                alerta.getDialogPane().setHeaderText("Confirmar Intercambio");
                alerta.getDialogPane().setContentText("Desea intercambar al " + this.pokemonActual.getNombre() +" por "+ pokemon.getNombre() );

                Optional<ButtonType> resultado = alerta.showAndWait();
                if (resultado.get() == ButtonType.OK) {
                        System.out.println("Se seleccionó al Pokemon " + pokemon.getNombre());
                }
                else  if (resultado.get() == ButtonType.CANCEL) {
                        System.out.println("No se selecciono ningun Pokemon");
                }
        }

}