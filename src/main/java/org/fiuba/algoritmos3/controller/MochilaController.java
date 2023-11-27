package org.fiuba.algoritmos3.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.model.items.Hiperpocion;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.items.ItemRestauradorDeVida;

import java.io.IOException;
import java.util.List;

public class MochilaController {

    @FXML
    public Label labelItem1;

    @FXML
    public VBox itemsContainer;
    @FXML
    public VBox contenedorPrincipal;

    private List<Item> items;

    public void mochilaController(){
    }

    public void setItems(List<Item> items, Stage stage) throws IOException {
        this.items = items;

        HBox hbox = new HBox();
        Button boton = new Button("Objeto");
        boton.setPrefSize(236, 50);
        Pane pane = new Pane();
        Label label = new Label("Cantidad");

        pane.getChildren().add(label);
        hbox.getChildren().addAll(boton, pane);

        itemsContainer.getChildren().addAll(hbox);

        Scene scene =  new Scene(contenedorPrincipal);
        stage.setScene(scene);
        stage.show();
    }

}
