package org.fiuba.algoritmos3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws IOException{
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("battleMain.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(),450,600);
//        stage.setTitle("Hello World!");
//        stage.setScene(scene);
//        stage.show();

        stage.setTitle("Hello World!");
        StackPane root = new StackPane();
        stage.setScene(new Scene(root, 300, 250));
        stage.show();

    }
}
