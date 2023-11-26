package org.fiuba.algoritmos3.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import org.fiuba.algoritmos3.model.items.Item;

import java.io.IOException;
import java.util.List;

public class mochilaController {

    @FXML
    public Label labelItem1;

    @FXML
    public VBox itemsContainer;

    private List<Item> items;

    public void mochilaController(){
    }

    public void setItems(List<Item> items) throws IOException {
        this.items = items;

        Button boton = new Button("boton");
        boton.setPrefHeight(50);
        boton.setMinHeight(50);
        itemsContainer.getChildren().addAll(boton);
        System.out.println("itemsss");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/mochila.fxml"));
        VBox root2 = loader.load();
    }

}
