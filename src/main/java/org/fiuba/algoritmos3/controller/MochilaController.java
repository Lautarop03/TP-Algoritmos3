package org.fiuba.algoritmos3.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.model.items.Hiperpocion;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.items.ItemRestauradorDeVida;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class MochilaController {

    @FXML
    public Label labelItem1;

    @FXML
    public VBox itemsContainer;
    @FXML
    public VBox contenedorPrincipal;
    @FXML
    public HBox fondoMochila;

    private List<Item> items;

    public void mochilaController(){
    }

    public void setItems(List<Item> items, Stage stage) throws IOException {
        this.items = items;

        Image image = new Image(getClass().getResource("/org/fiuba/algoritmos3/background/mochila.png").toString());
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
        fondoMochila.setBackground(bg);

        for (Item item : items) {
            mostrarHileraItem(item);
        }

        Scene scene =  new Scene(contenedorPrincipal);
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarHileraItem(Item item){
        HBox hbox = new HBox();

        Button boton = new Button(item.getNombre());
        boton.setPrefSize(236, 50);

        Pane pane = new Pane();
        pane.setPrefSize(117,50);
        Label label = new Label("x" + item.getCantidad().toString());
        label.setAlignment(Pos.CENTER);
        label.setLayoutY(6);
        label.setPrefSize(73, 37);

        pane.getChildren().add(label);
        hbox.getChildren().addAll(boton, pane);

        itemsContainer.getChildren().addAll(hbox);
    }

}
