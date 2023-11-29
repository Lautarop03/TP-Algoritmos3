package org.fiuba.algoritmos3.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.MainFX;
import org.fiuba.algoritmos3.controller.Eventos.CambioTurnoEvent;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.io.IOException;
import java.util.Objects;


public class JuegoController implements EventHandler<CambioTurnoEvent> {
    private Juego juego;

    public Stage stage;
    public BattleMainController battleController;
    public Scene battleMain;

    public void setJuego(Juego juego) throws IOException {
        this.juego = juego;
        battleController = new BattleMainController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/battleMain.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root, 600, 450);
        stage.setScene(scene);
        stage.show();
        root.addEventHandler(CambioTurnoEvent.CAMBIO_TURNO_EVENT, this);
        BattleMainController battleController = loader.getController();
        battleMain = battleController.setJuego(juego);
        battleController.setStage(stage);
    }

    public Juego getJuego() {
        return juego;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(CambioTurnoEvent cambioTurnoEvent) {
        juego.cambiarTurno();
        try {
            comprobarPokemonActualEstaVivo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        juego.aplicarClima();
    }
    public void comprobarPokemonActualEstaVivo() throws IOException {
        Pokemon pokemon = juego.getJugadorActual().getPokemonActual();
        if (!pokemon.estaVivo()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/seleccionPokemon.fxml"));
            Parent root = loader.load();
            SeleccionPokemonController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            controller.init(juego.getJugadorActual().getPokemones(),stage,battleController);
            stage.show();
            this.stage.close();
            //TODO: Mandar a seleccionar pokemon y intercambiar (ahi? o aca?)
        }
    }


    //TODO: Cuando termina la ronda{
    // La ronda pasa cuando: *Aplico un item *Ataco *Cambio de pokemon
    // }aplicar efectos y atacar en base a eso
    //TODO: Aplicar Items
    //TODO: Huir
    //TODO:
}