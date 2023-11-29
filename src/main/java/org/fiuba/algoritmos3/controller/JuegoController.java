package org.fiuba.algoritmos3.controller;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.controller.Eventos.CambioTurnoEvent;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;

import java.io.IOException;
import java.util.List;


public class JuegoController implements EventHandler<CambioTurnoEvent> {
    private Juego juego;

    public Stage stage;
    public BattleMainController battleController;

    public void setJuego(Juego juego) throws IOException {
        this.juego = juego;
        BattleMainController controller = new BattleMainController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/battleMain.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root, 600, 450);
        stage.setScene(scene);
        stage.show();
        root.addEventHandler(CambioTurnoEvent.CAMBIO_TURNO_EVENT, this);
        BattleMainController battleController = loader.getController();
        SingletonJuego.getInstancia().setJuegoController(this);
        battleController.setJuego(juego);
        battleController.setStage(stage);
        this.battleController = battleController;
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
            comprobarPokemonActualEstaVivo();   // Si el pokemon que comienza el turno está muerto
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            comprobarPokemonEnemigoEstaVivo();   // Si el pokemon que teminó el turno murió por un estado
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        juego.aplicarClima();

        }

    public void comprobarPokemonActualEstaVivo() throws IOException {
        Pokemon pokemon = juego.getJugadorActual().getPokemonActual();
        if (pokemon.estaMuerto()){
            handlePokemonMuerto(juego.getJugadorActual());
        }
    }
    public void comprobarPokemonEnemigoEstaVivo() throws IOException {
        Pokemon pokemon = juego.getOponente().getPokemonActual();
        if (pokemon.estaMuerto()){
            handlePokemonMuerto(juego.getOponente());
        }
    }

    public void handlePokemonMuerto(Jugador jugador) {
        Platform.runLater(() -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/seleccionPokemon.fxml"));
            try {
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));

                SeleccionPokemonController controladorSeleccionPokemon = loader.getController();

                controladorSeleccionPokemon.setJugadorActual(jugador);
                controladorSeleccionPokemon.init(jugador.getPokemones(), stage,battleController);
                this.stage.close();
                stage.showAndWait();
                this.stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}