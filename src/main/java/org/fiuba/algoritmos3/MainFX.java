package org.fiuba.algoritmos3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battleMain.fxml"));
        VBox root = loader.load();

        Scene scene = new Scene(root, 600, 450);

        stage.setScene(scene);
        stage.show();

        HBox pelea = (HBox) scene.lookup("#batalla");

        Image image = new Image(getClass().getResource("background/battlebgroute.jpg").toString());
        BackgroundImage bgImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        root.getHeight(), root.getWidth(), true, true, true, true)
        );

        Background bg = new Background(bgImage);
        pelea.setBackground(bg);

        stage.show();

    }
}