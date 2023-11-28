package org.fiuba.algoritmos3.controller;

import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.model.items.Hiperpocion;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.items.ItemRestauradorDeVida;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MochilaController {

    @FXML
    public Label labelItem1;
    @FXML
    public ScrollPane contenedorItems;
    @FXML
    public VBox itemsContainer;
    @FXML
    public VBox contenedorPrincipal;
    @FXML
    public HBox fondoMochila;
    @FXML
    public Label descripcionLabel;
    @FXML
    public ImageView imagenItem;

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

        int altura = 50;
        for (Integer i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            mostrarHileraItem(item, i);
            altura += 50;
        }
        itemsContainer.setPrefHeight(altura);

        Scene scene =  new Scene(contenedorPrincipal);
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarHileraItem(Item item, Integer id){
        HBox hbox = new HBox();
        hbox.setId(id.toString());
        hbox.getStyleClass().add("hileraItem");
        VBox.setMargin(hbox, new Insets(0, 0, 0, 20));

        hbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                hoverItem(mouseEvent, Integer.parseInt(hbox.getId()));
            }
        });
        hbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickItem(mouseEvent, item);
            }
        });


        Label labelNombreItem = new Label(item.getNombre());
        labelNombreItem.setPrefSize(230, 50);
        labelNombreItem.setLayoutX(10);
        labelNombreItem.setAlignment(Pos.CENTER);

        Pane pane = new Pane();
        pane.setPrefSize(80,50);
        Label labelCantidad = new Label("x" + item.getCantidad().toString());
        labelCantidad.setAlignment(Pos.CENTER);
        labelCantidad.setLayoutY(6);
        labelCantidad.setPrefSize(73, 37);

        pane.getChildren().add(labelCantidad);
        hbox.getChildren().addAll(labelNombreItem, pane);


        itemsContainer.getChildren().addAll(hbox);
    }

    public void hoverItem(MouseEvent mouseEvent, Integer id){
        Item item = items.get(id);
        descripcionLabel.setText(item.getDescripcion());

        String nombreClaseItem = item.getClass().toString().replace("class org.fiuba.algoritmos3.model.items.", "");

        Image itemImage = new Image(getClass().getResource("/org/fiuba/algoritmos3/items/" + nombreClaseItem +".png").toString());
        this.imagenItem.setImage(itemImage);
    }

    public void clickItem(MouseEvent mouseEvent, Item item) {
        Stage stage = (Stage) contenedorPrincipal.getScene().getWindow();

        Alert.AlertType tipo = Alert.AlertType.CONFIRMATION;
        Alert alerta = new Alert(tipo, "");

        alerta.initModality(Modality.APPLICATION_MODAL);
        alerta.initOwner(stage);

        alerta.getDialogPane().setContentText("Desea usar este ítem?");
        alerta.getDialogPane().setHeaderText("Confirmar Uso de Ítem");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.get() == ButtonType.OK) {
            System.out.println("Se seleccionó el item " + item.getNombre());
        }
        else  if (resultado.get() == ButtonType.CANCEL) {
            System.out.println("No se seleccionó el item");
        }
    }

}
