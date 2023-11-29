package org.fiuba.algoritmos3.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SeleccionPokemonController extends Controller {

        @FXML
        private ProgressBar barra_vida_actual;
        @FXML
        private  Pane contenedorPokemonActual;
        @FXML
        private ImageView img_actual;
        @FXML
        private Label nivel_actual;
        @FXML
        private Label nombre_actual;
        @FXML
        private Label vida_actual;
        @FXML private Label estadoActual0;
        @FXML private Label estadoActual1;
        @FXML private Label estadoActual2;
        @FXML private Label estadoActual3;
        @FXML private Button salirSeleccionPokemon;
        private ArrayList<Pokemon> pokemones;
        private Pokemon pokemonActual;
        public VBox contenedorPrincipal;
        public HBox seleccionPokemon;
        public HBox contenedorConfirmacion;
        public VBox pokemonConteiner;
        public Label descripcionPokemon;
        private Controller controller;
        private Stage stage;
        private Pokemon pokemon;
        private String accion;
        private List<Label> estadosActuales;
        private Jugador jugadorActual;


        public void setPokemones(ArrayList<Pokemon> pokemones, Stage stage, Pokemon pokemonActual) {
                this.pokemones = pokemones;
                this.pokemonActual = pokemonActual;
                this.contenedorConfirmacion.setVisible(false);
                this.estadosActuales = List.of(estadoActual0, estadoActual1, estadoActual2, estadoActual3);
                if (pokemonActual.estaMuerto()){this.salirSeleccionPokemon.setVisible(false);}
                for (Integer i = 0; i <pokemones.size(); i++) {
                        if (pokemones.get(i) != pokemonActual && (pokemones.get(i).estaVivo() || accion == "mochila")) {
                                Pokemon pokemon = pokemones.get(i);
                                mostrarPokemones(pokemon, i);
                        }
                }
                pokemonConteiner.setPrefHeight(350);

                mostrarPokemonActual();

                if (stage.getScene() == null) {
                        Scene scene = new Scene(contenedorPrincipal);
                        stage.setScene(scene);
                        stage.show();
                }
                mostrarEstados(pokemonActual.getEstados(),estadosActuales);
        }

        public void setJugadorActual(Jugador jugadorActual) {
                this.jugadorActual = jugadorActual;
        }

        public void mostrarEstados(List<Estado> estados, List<Label> labelsEstados){
                for (int i = 0; i < labelsEstados.size(); i++) {
                        Label label = labelsEstados.get(i);
                        if (i < estados.size()) {
                                String nombreEstado = estados.get(i).getNombre();
                                label.setVisible(true);
                                label.getStyleClass().clear();
                                label.getStyleClass().addAll(nombreEstado, "Estado");
                                label.setText(nombreEstado.substring(0,3).toUpperCase());
                        } else {
                                label.setVisible(false);
                        }
                }
        }


        private void mostrarPokemones(Pokemon pokemon, Integer id ) {
                VBox vbox = new VBox(1);
                vbox.setPadding(new Insets(1));
                vbox.getChildren().add(crearHbox(pokemon,id));
                this.pokemonConteiner.getChildren().add(vbox);
        }

        public HBox crearHbox(Pokemon pokemon,Integer id){
                Pane paneIzquierdo = new Pane();
                paneIzquierdo.setMaxWidth(150);
                paneIzquierdo.setMinWidth(150);

                String ruta = "/org/fiuba/algoritmos3/pokemonMiniSprite/"+pokemon.getNombre()+"_mini.gif";
                ImageView imagePokemon = new ImageView(getClass().getResource(ruta).toString());
                imagePokemon.setFitWidth(65);
                imagePokemon.setPreserveRatio(true);
                imagePokemon.setLayoutX(-10);
                imagePokemon.setTranslateY(-22.5);

                Label labelNombre = new Label(pokemon.getNombre());
                labelNombre.setLayoutX(80);
                labelNombre.setStyle("-fx-font-size: 25px; -fx-font-family: \"Pokemon Emerald\";");

                Label labelNivel = new Label("Nv: " + pokemon.getNivel());
                labelNivel.setStyle("-fx-font-size: 20px;-fx-font-family: \"Pokemon Emerald\";");
                labelNivel.setTranslateY(18);
                labelNivel.setLayoutX(80);

                Label labelEstado = new Label();
                String estadosResumen="";
                if(!pokemon.getEstados().isEmpty()){
                        for (int i = 0; i < (pokemon.getEstados()).size();i++){
                                List<Estado> estados = pokemon.getEstados();
                                estadosResumen += estados.get(i).getNombre()+" ";
                        }
                }
                labelEstado.setText(estadosResumen);
                labelEstado.setLayoutX(80);
                labelEstado.setTranslateY(26);
                paneIzquierdo.getChildren().addAll(imagePokemon, labelNombre, labelNivel,labelEstado);


                Pane paneDerecho = new Pane();

/*                ImageView imageView = new ImageView(getClass().getResource("/org/fiuba/algoritmos3/background/ps.png").toString());
                imageView.setFitWidth(25);
                imageView.setPreserveRatio(true);
                imageView.setLayoutX(35);*/
                Label label = new Label();
                label.setText("PS");
                label.setStyle("-fx-text-fill: #deff08; -fx-font-size: 18");
                label.setLayoutX(38);
                label.setLayoutY(-8);

                Label labelVida = new Label(pokemon.getVidaActual() +" / "+ pokemon.getVidaMaxima() );
                labelVida.setStyle("-fx-font-size: 20px;-fx-font-family: \"Pokemon Emerald\";");
                labelVida.setLayoutX(120);
                labelVida.setLayoutY(20);

                ProgressBar progressBar = new ProgressBar(porcentajeVidaPokemon(pokemon));
                progressBar.setStyle(cambiarColorBarra(pokemon));
                progressBar.setLayoutX(60);
                progressBar.setMaxWidth(100);
                progressBar.setMaxHeight(11);

                paneDerecho.getChildren().addAll(label, progressBar, labelVida);

                
                HBox hbox = new HBox(10);
                hbox.getChildren().addAll(paneIzquierdo, paneDerecho);
                hbox.setPadding(new Insets(10));
                hbox.setStyle("-fx-background-color: #00A8BF; -fx-background-radius: 2;" +
                        "-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 2");

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

        public String cambiarColorBarra(Pokemon pokemon) {
                double rojo = 255;
                double verde = 255;
                double porcentaje = porcentajeVidaPokemon(pokemon);
                double porcentajeAMultiplicar = (-Math.abs(2 * porcentaje - 1)) + 1;

                if (porcentaje > 0.5) {
                        rojo = rojo * porcentajeAMultiplicar;
                } else if (porcentaje < 0.5){
                        verde = verde *porcentajeAMultiplicar;
                }
                return "-fx-accent:  rgb(" + rojo + "," + verde + ",0)";
        }

        private void mostrarPokemonActual(){
                this.nombre_actual.setText(pokemonActual.getNombre());
                nombre_actual.setStyle("-fx-font-size: 30px");
                this.nivel_actual.setText("Nv: " + pokemonActual.getNivel());
                nivel_actual.setStyle("-fx-font-size: 20px");
                this.vida_actual.setText(pokemonActual.getVidaActual()+"/"+ pokemonActual.getVidaMaxima());
                vida_actual.setStyle("-fx-font-size: 20px");
                mostrarEstados(pokemonActual.getEstados(),estadosActuales);
                this.barra_vida_actual.setProgress(porcentajeVidaPokemon(pokemonActual));
                this.barra_vida_actual.setStyle(cambiarColorBarra(pokemonActual));
                String ruta = "/org/fiuba/algoritmos3/pokemonMiniSprite/"+pokemonActual.getNombre()+"_mini.gif";
                Image image = new Image(getClass().getResource(ruta).toString());
                this.img_actual.setImage(image);

                if (this.accion == "mochila") {
                        this.contenedorPokemonActual.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {hoverPokemon(mouseEvent, 0);
                        }
                });

                        this.contenedorPokemonActual.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) { clickPokemon(mouseEvent, pokemonActual);
                                }
                        });
                }
        }

        public double porcentajeVidaPokemon(Pokemon pokemon){
                double porcentaje = (double)pokemon.getVidaActual()/(double)pokemon.getVidaMaxima();
                return porcentaje;
        }

        public void hoverPokemon(MouseEvent mouseEvent, Integer id){
                if (id == 0){
                        descripcionPokemon.setText("Es tu pokemon actual "+ pokemonActual.getNombre()+"!!");
                }else {
                        Pokemon pokemon = pokemones.get(id);
                        descripcionPokemon.setText(" Vas a seleccionar a " + pokemon.getNombre());
                        descripcionPokemon.setStyle("-fx-font-size: 30px;-fx-font-family: \"Pokemon Emerald\";");
                }
        }

        public void clickPokemon(MouseEvent mouseEvent, Pokemon pokemon){
                Stage stage = (Stage) contenedorPrincipal.getScene().getWindow();
                this.contenedorConfirmacion.setVisible(true);
                this.pokemonConteiner.setDisable(true);
                this.pokemon = pokemon;
                if (this.accion == "mochila") {
                        descripcionPokemon.setText("¿Desea aplicar el Item en " + pokemon.getNombre() + "?");
                }else {
                        descripcionPokemon.setText("¿Intercambiar " + pokemonActual.getNombre() + " por " + pokemon.getNombre() + "?");
                }
        }

        public void confirmarBtn() throws IOException {
                this.contenedorConfirmacion.setVisible(false);
                if (Objects.equals(accion, "main")) {
                        cambiarPokemon(pokemon);
                        handleConfirmarBtn(null);
                        if (pokemonActual.estaVivo()) {
                                controller.cambiarEscena = true;
                        }
                }
                this.controller.show();
                this.stage.close();
        }
        public void cancelarBtn(){
                this.pokemon = null;
                this.pokemonConteiner.setDisable(false);
                this.contenedorConfirmacion.setVisible(false);
        }

        public void cambiarPokemon(Pokemon pokemon) {
                jugadorActual.intercambiarPokemon(pokemon);
        }
        
        public Pokemon getPokemonSeleccionado() {
                return this.pokemon;
        }

        public void init(List<Pokemon> pokemones, Stage stage, Controller controller) {
                this.controller = controller;
                if (controller.getClass().equals(BattleMainController.class)){
                        this.accion = "main";
                } else if  (controller.getClass().equals(MochilaController.class)) {
                        this.accion = "mochila";
                }
                setPokemones((ArrayList<Pokemon>) pokemones,stage,pokemones.get(0));
                this.stage = stage;
        }
        @FXML
        void handleConfirmarBtn(MouseEvent evento) throws IOException {
                controller.show();
                this.stage.close();
        }
}