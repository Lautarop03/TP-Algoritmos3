package org.fiuba.algoritmos3.controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.fiuba.algoritmos3.controller.Eventos.CambioTurnoEvent;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.PaqueteDeRespuesta;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class BattleMainController {

    @FXML
    private HBox fondoBattleMain;
    @FXML
    private Label nombre_actual_pk1;

    @FXML
    private ImageView img_pk1;

    @FXML
    private ProgressBar barra_vida_pk1;

    @FXML
    private Label vida_actual_max_pk1;

    @FXML
    private Label nivel_actual_pk1;

    @FXML
    private Label nombre_actual_pk2;

    @FXML
    private ImageView img_pk2;

    @FXML
    private ProgressBar barra_vida_pk2;

    @FXML
    private Label vida_actual_max_pk2;

    @FXML
    private Label nivel_actual_pk2;

    @FXML
    private Label habilidadLabel0;
    @FXML
    private Label habilidadLabel1;
    @FXML
    private Label habilidadLabel2;
    @FXML
    private Label habilidadLabel3;
    @FXML
    private Label tipoLabel;
    @FXML
    private Label usosRestantesLabel;
    @FXML
    private Label consola;
    @FXML
    private GridPane botonesContainer;
    @FXML
    private GridPane habilidadesContainer;
    @FXML
    private GridPane descripcionHabilidadesContainer;

    private Juego juego;

    private JuegoController juegoController;

    private List<Habilidad> habilidades;
    private List<Label> labelsHabilidades;
    private Stage stage;

    public Scene setJuego(Juego juego) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/battleMain.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root, 600, 450);


        Image image = new Image(getClass().getResource("/org/fiuba/algoritmos3/background/battlebgroute.jpg").toString());
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
        fondoBattleMain.setBackground(bg);



        this.juego = juego;
        List<Jugador> jugadores = juego.getJugadores();
        Jugador jugador1 = juego.getJugadorActual();
        Jugador jugador2 = juego.getOponente();
        Pokemon pk1 = jugador1.getPokemonActual();
        Pokemon pk2 = jugador2.getPokemonActual();
        this.nombre_actual_pk1.setText(pk1.getNombre());
        this.nombre_actual_pk2.setText(pk2.getNombre());
        this.vida_actual_max_pk1.setText(pk1.getVidaActual()+"/"+ pk1.getVidaMaxima());
        this.vida_actual_max_pk2.setText(pk2.getVidaActual()+"/" + pk2.getVidaMaxima());
        this.barra_vida_pk1.setProgress(porcentajeVidaPokemon(pk1));
        this.barra_vida_pk2.setProgress(porcentajeVidaPokemon(pk2));
        this.nivel_actual_pk1.setText("Nv:" + pk1.getNivel());
        this.nivel_actual_pk2.setText("Nv:" + pk2.getNivel());
        Image pk1Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonBack/" + pk1.getNombre() +"_back.png").toString());
        this.img_pk1.setImage(pk1Image);
        Image pk2Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonFront/" + pk2.getNombre() +"_front.png").toString());
        this.img_pk2.setImage(pk2Image);
        this.habilidades = juego.getJugadorActual().getPokemonActual().getHabilidades();
        this.labelsHabilidades = List.of(habilidadLabel0, habilidadLabel1, habilidadLabel2, habilidadLabel3);
        return scene;
        // TODO: aca seteo todos los datos de la pantalla
    }

    public double porcentajeVidaPokemon(Pokemon pokemon){
        double porcentaje = (double)pokemon.getVidaActual()/(double)pokemon.getVidaMaxima();
        return porcentaje;
    }


    private void toggleMenuHabilidades() {
        boolean visibilidad = consola.isVisible();
        consola.setVisible(!visibilidad);
        botonesContainer.setVisible(!visibilidad);
        habilidadesContainer.setVisible(visibilidad);
        descripcionHabilidadesContainer.setVisible(visibilidad);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void handleAtaqueBtn(MouseEvent mouseEvent) {
        toggleMenuHabilidades();

        for (int i = 0; i < habilidades.size(); i++) {
            Label label = labelsHabilidades.get(i);
            Habilidad habilidad = habilidades.get(i);
            label.setText(habilidad.getNombre());
        }
    }

    @FXML
    public void handleHabilidadLabelClick(MouseEvent event) throws IOException, InterruptedException {
        Label source = (Label) event.getSource();
        String labelId = source.getId();

        Habilidad habilidad = getHabilidadDeMouseEvent(event);;

        PauseTransition animacionAtaque = new PauseTransition(Duration.seconds(1));
        animacionAtaque.setOnFinished(e -> img_pk2.setEffect(null));

        MotionBlur motionBlur = new MotionBlur();
        img_pk2.setEffect(motionBlur);
        animacionAtaque.playFromStart();

        // TODO: toda la logica para realizar el ataque
        if (habilidad.getCantidadDeUsos() == 0) {
            //TODO: Imprimir en la pantalla habilidad sin usos y volver al menu
            toggleMenuHabilidades();
        } else {
            juego.atacar(new PaqueteDeRespuesta<>(true,habilidad));
            if (!juego.aplicarEstados()){
                juego.realizarAtaque();
            }
            setJuego(juego);
        }
        tipoLabel.fireEvent(new CambioTurnoEvent());

        setJuego(juego);

        toggleMenuHabilidades();
    }
    public void hoverHabilidad(MouseEvent mouseEvent) {
        Habilidad habilidad = getHabilidadDeMouseEvent(mouseEvent);

        tipoLabel.setText("Tipo: " + habilidad.getTipo().toString());
        usosRestantesLabel.setText("Usos restantes: " + habilidad.getCantidadDeUsos().toString());
    }

    private Habilidad getHabilidadDeMouseEvent(MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        Integer idHabilidad = Integer.parseInt(label.getId().replace("habilidadLabel", ""));
        return habilidades.get(idHabilidad);
    }


    public void handleMochilaBtn(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/mochila.fxml"));
        Parent root = loader.load();
        MochilaController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(juego.getJugadorActual().getItems(),stage,this);
        stage.show();
        this.stage.close();
    }

    public void handlePokemonBtn(MouseEvent mouseEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/seleccionPokemon.fxml"));
        Parent root = loader.load();
        SeleccionPokemonController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(juego.getJugadorActual().getPokemones(),stage,this);
        stage.show();
        this.stage.close();
    }

    public void handleHuirBtn(MouseEvent mouseEvent) {
        //TODO: BOTON PARA RENDIRSE
    }

    public void show() {
        this.stage.show();
    }

    public void setJuegoController(JuegoController juegoController) {
        this.juegoController = juegoController;
    }
}
