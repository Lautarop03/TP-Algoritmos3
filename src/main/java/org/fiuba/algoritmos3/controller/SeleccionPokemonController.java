package org.fiuba.algoritmos3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SeleccionPokemonController {

        @FXML
        private ProgressBar barra_vida_actual;

        @FXML
        private ProgressBar barra_vida_pk1;

        @FXML
        private ProgressBar barra_vida_pk2;

        @FXML
        private ProgressBar barra_vida_pk3;

        @FXML
        private ProgressBar barra_vida_pk4;

        @FXML
        private ProgressBar barra_vida_pk5;

        @FXML
        private ImageView img_actual;

        @FXML
        private ImageView img_pk1;

        @FXML
        private ImageView img_pk2;

        @FXML
        private ImageView img_pk3;

        @FXML
        private ImageView img_pk4;

        @FXML
        private Label nivel_actual;

        @FXML
        private Label nivel_pk1;

        @FXML
        private Label nivel_pk2;

        @FXML
        private Label nivel_pk3;

        @FXML
        private Label nivel_pk4;

        @FXML
        private Label nivel_pk5;

        @FXML
        private Label nombre_actual;

        @FXML
        private Label nombre_pk1;

        @FXML
        private Label nombre_pk2;

        @FXML
        private Label nombre_pk3;

        @FXML
        private Label nombre_pk4;

        @FXML
        private Label nombre_pk5;

        @FXML
        private Button salir_items;

        @FXML
        private Label texto_items;

        @FXML
        private Label vida_actual_actual;

        @FXML
        private Label vida_actual_pk1;

        @FXML
        private Label vida_actual_pk2;

        @FXML
        private Label vida_actual_pk3;

        @FXML
        private Label vida_actual_pk4;

        @FXML
        private Label vida_actual_pk5;

        @FXML
        private Label vida_max_actual;

        @FXML
        private Label vida_max_pk1;

        @FXML
        private Label vida_max_pk2;

        @FXML
        private Label vida_max_pk3;

        @FXML
        private Label vida_max_pk4;

        @FXML
        private Label vida_max_pk5;

        public JuegoController juegoController;


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


    }