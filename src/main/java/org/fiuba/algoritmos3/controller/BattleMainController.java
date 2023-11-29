package org.fiuba.algoritmos3.controller;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.fiuba.algoritmos3.controller.Eventos.CambioTurnoEvent;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.Jugador;
import org.fiuba.algoritmos3.model.PaqueteDeRespuesta;
import org.fiuba.algoritmos3.model.clima.Clima;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.estados.Estado;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.model.pokemon.habilidades.HabilidadDeClima;
import org.fiuba.algoritmos3.viewsJavaFX.ViewControladorJavaFX;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class BattleMainController extends Controller {

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
    @FXML
    private VBox vboxDerecho;
    @FXML
    private VBox vboxIzquierdo;
    @FXML private ImageView pokeballActual0;
    @FXML private ImageView pokeballActual1;
    @FXML private ImageView pokeballActual2;
    @FXML private ImageView pokeballActual3;
    @FXML private ImageView pokeballActual4;
    @FXML private ImageView pokeballActual5;
    @FXML private ImageView pokeballEnemiga0;
    @FXML private ImageView pokeballEnemiga1;
    @FXML private ImageView pokeballEnemiga2;
    @FXML private ImageView pokeballEnemiga3;
    @FXML private ImageView pokeballEnemiga4;
    @FXML private ImageView pokeballEnemiga5;
    @FXML private Label estadoActual0;
    @FXML private Label estadoActual1;
    @FXML private Label estadoActual2;
    @FXML private Label estadoActual3;
    @FXML private Label estadoEnemigo0;
    @FXML private Label estadoEnemigo1;
    @FXML private Label estadoEnemigo2;
    @FXML private Label estadoEnemigo3;
    @FXML private Pane contenedorHuir;


    private Juego juego;
    private String fondo = "battlebgroute";
    private List<Habilidad> habilidades;
    private List<Label> labelsHabilidades;
    private List<ImageView> pokeballsEnemigas;
    private List<ImageView> pokeballsActuales;
    private  List<Label> estadosActuales;
    private  List<Label> estadosEnemigos;

    private ViewControladorJavaFX viewControlador;
    private Stage stage;

    public Scene setJuego(Juego juego) throws IOException {
        this.juego = juego;
        this.contenedorHuir.setVisible(false);
        chequearClima();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/battleMain.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root, 600, 450);

        setFondoBattleMain(fondo);
        this.viewControlador = new ViewControladorJavaFX();


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

        // Animación para la ProgressBar de pk2
        animateProgressBarProgresivamente(barra_vida_pk2, porcentajeVidaPokemon(pk2), 1000);


        this.barra_vida_pk1.setStyle(cambiarColorBarra(pk1));
        this.barra_vida_pk2.setStyle(cambiarColorBarra(pk2));
        this.nivel_actual_pk1.setText("Nv:" + pk1.getNivel());
        this.nivel_actual_pk2.setText("Nv:" + pk2.getNivel());
        Image pk1Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonBack/" + pk1.getNombre() +"_back.png").toString());
        this.img_pk1.setImage(pk1Image);
        Image pk2Image = new Image(getClass().getResource("/org/fiuba/algoritmos3/pokemonFront/" + pk2.getNombre() +"_front.png").toString());
        this.img_pk2.setImage(pk2Image);
        this.habilidades = juego.getJugadorActual().getPokemonActual().getHabilidades();
        this.labelsHabilidades = List.of(habilidadLabel0, habilidadLabel1, habilidadLabel2, habilidadLabel3);
        this.pokeballsActuales = List.of(pokeballActual0, pokeballActual1, pokeballActual2, pokeballActual3, pokeballActual4, pokeballActual5);
        this.pokeballsEnemigas = List.of(pokeballEnemiga0, pokeballEnemiga1, pokeballEnemiga2, pokeballEnemiga3, pokeballEnemiga4, pokeballEnemiga5);
        this.estadosActuales = List.of(estadoActual0, estadoActual1, estadoActual2, estadoActual3);
        this.estadosEnemigos = List.of(estadoEnemigo0, estadoEnemigo1, estadoEnemigo2, estadoEnemigo3);
        return scene;
    }

    public void chequearClima() {
        Clima clima = juego.getClima();
        if (clima == null) {
            fondo = "battlebgroute";
        }
    }

    private void animateProgressBarProgresivamente(ProgressBar progressBar, double to, int durationMillis) {
        double decremento = 0.04;
        int maxCycles = (int) (durationMillis / 50 / decremento);

        animate(progressBar, to, decremento, maxCycles);
    }

    private void animate(ProgressBar progressBar, double to, double decremento, int remainingCycles) {
        double current = progressBar.getProgress();

        if (current > to && remainingCycles > 0) {
            progressBar.setProgress(current - decremento);

            PauseTransition pause = new PauseTransition(Duration.millis(100));
            pause.setOnFinished(event -> animate(progressBar, to, decremento, remainingCycles - 1));
            pause.play();
        } else {
            progressBar.setProgress(to);
        }
    }

    public double porcentajeVidaPokemon(Pokemon pokemon){
        double porcentaje = (double)pokemon.getVidaActual()/(double)pokemon.getVidaMaxima();
        return porcentaje;
    }


    public String cambiarColorBarra(Pokemon pokemon) {
        double rojo = 255;
        double verde = 255;
        double porcentaje = porcentajeVidaPokemon(pokemon);
        double porcentajeAMultiplicar = (-Math.abs(2 * porcentaje - 1)) + 1;

        if (porcentaje > 0.5) {
            rojo = rojo * porcentajeAMultiplicar;
        } else if (porcentaje < 0.5){
            verde = verde *porcentajeAMultiplicar;
        }
        return "-fx-accent:  rgb(" + rojo + "," + verde + ",0) ";
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
        this.contenedorHuir.setVisible(false);

        for (int i = 0; i < habilidades.size(); i++) {
            Label label = labelsHabilidades.get(i);
            Habilidad habilidad = habilidades.get(i);
            label.setText(habilidad.getNombre());
            label.setStyle("-fx-font-family: \"Pokemon Emerald\"; -fx-font-size:25px ");
        }
    }
    public void mostrarEstados(List<Estado> estados, Pokemon pokemon, List<Boolean> aplicados){
        if (!estados.isEmpty()){
            for (int iterador = 0; iterador<estados.size(); iterador++){
                int finalIterador = iterador;
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(2), e -> {
                            consola.setText(viewControlador.mostrarEfectoEstado(estados.get(finalIterador), pokemon, aplicados.get(finalIterador)));
                        })
                );
                timeline.play();
            }
        }

    }
    @FXML
    public void handleHabilidadLabelClick(MouseEvent event) throws IOException, InterruptedException {
        Habilidad habilidad = getHabilidadDeMouseEvent(event);;

        if (habilidad.getCantidadDeUsos() == 0) {
            consola.setText("Habilidad sin usos, elija otra");
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(2), e -> {
                        consola.setText("Que desea hacer?");
                    })
            );
            timeline.play();
            toggleMenuHabilidades();
            return;
        }

        botonesContainer.setDisable(true);

        juego.atacar(new PaqueteDeRespuesta<>(true,habilidad));
        List<Boolean> aplicados = juego.aplicarEstados();
        List<Estado> estados = juego.getJugadorActual().getPokemonActual().getEstados();
        if (aplicados.isEmpty() || !aplicados.contains(true)){
            juego.realizarAtaque();
            consola.setText(viewControlador.mostrarAccion(habilidad, juego.getJugadorActual().getPokemonActual(), juego.getOponente().getPokemonActual()));
            mostrarEstados(estados, juego.getJugadorActual().getPokemonActual(), aplicados);
        } else {
            mostrarEstados(estados, juego.getJugadorActual().getPokemonActual(), aplicados);
        }
        setJuego(juego);
        if (habilidad.getClass() == HabilidadDeClima.class) {
            setFondoBattleMain(habilidad.getNombre());
            this.fondo = habilidad.getNombre();
        }
        actualizarPokemonesRestantes();
        actualizarEstados();

        PauseTransition animacionAtaque = new PauseTransition(Duration.seconds(1));

        animacionAtaque.setOnFinished((finalizado) -> {
            cambiarDeTurno();
        });
        actualizarEstados();

        MotionBlur motionBlur = new MotionBlur();
        Blend blend = new Blend();
        blend.setMode(BlendMode.RED);
        blend.setBottomInput(motionBlur);

        img_pk2.setEffect(blend);
        animacionAtaque.playFromStart();

        toggleMenuHabilidades();

        mostrarPokemonesRestantes(juego.getJugadorActual().getCantidadPokemonVivos(), pokeballsActuales);
        mostrarPokemonesRestantes(juego.getOponente().getCantidadPokemonVivos(), pokeballsEnemigas);
    }

    public void mostrarGanador(Jugador jugador){
        if (juego.terminado()){
            this.consola.setText("Felicidades ganaste: " + jugador.getNombre());
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                Platform.exit();
            }));
            timeline.setCycleCount(1);
            timeline.play();
        }
    }
    public void cambiarDeTurno() {
        mostrarGanador(juego.getJugadorActual());
        img_pk2.setEffect(null);

        PathTransition transitionDer = animacionCambioDeTurno(vboxDerecho, vboxDerecho.getWidth()/2, vboxDerecho.getHeight()/2, 500);
        PathTransition transitionIzq = animacionCambioDeTurno(vboxIzquierdo, vboxIzquierdo.getWidth()/2, vboxIzquierdo.getHeight()/2, -500);
        transitionDer.play();
        transitionIzq.play();

        transitionIzq.setOnFinished((finalizado2) -> {
            lanzarEventocambiarDeTurno();
            botonesContainer.setDisable(false);
            actualizarPokemonesRestantes();
            actualizarEstados();

            PathTransition transitionDerFin = animacionCambioDeTurno(vboxDerecho, vboxDerecho.getWidth()/2 + 500, vboxDerecho.getHeight()/2, 150);
            PathTransition transitionIzqFin = animacionCambioDeTurno(vboxIzquierdo, vboxIzquierdo.getWidth()/2 - 500, vboxIzquierdo.getHeight()/2, 150);
            transitionDerFin.play();
            transitionIzqFin.play();
        });
    }
    
    private PathTransition animacionCambioDeTurno(VBox vbox, double posInicial, double posFinal, double destino) {
        Path pathDerecho = new Path();
        pathDerecho.getElements().add(new MoveTo(posInicial, posFinal));
        pathDerecho.getElements().add(new HLineTo(destino));

        PathTransition transicion = new PathTransition();
        transicion.setNode(vbox);
        transicion.setDuration(Duration.seconds(1));
        transicion.setPath(pathDerecho);
        transicion.setCycleCount(1);
        return transicion;
    }

    private void lanzarEventocambiarDeTurno() {
        tipoLabel.fireEvent(new CambioTurnoEvent());
        try {
            setJuego(juego);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void hoverHabilidad(MouseEvent mouseEvent) {
        Habilidad habilidad = getHabilidadDeMouseEvent(mouseEvent);

        tipoLabel.setText("Tipo: " + habilidad.getTipo().toString());
        usosRestantesLabel.setText("Usos restantes: " + habilidad.getCantidadDeUsos().toString());
        tipoLabel.setStyle("-fx-font-family: \"Pokemon Emerald\"; -fx-font-size:25px ");
        usosRestantesLabel.setStyle("-fx-font-family: \"Pokemon Emerald\"; -fx-font-size:25px ");
    }

    private Habilidad getHabilidadDeMouseEvent(MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        int idHabilidad = Integer.parseInt(label.getId().replace("habilidadLabel", ""));
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
        consola.setText("\uD83D\uDC14 ¿Eres un gallina McFly? \uD83D\uDC14"  );
        this.contenedorHuir.setVisible(true);
        this.contenedorHuir.toFront();
    }
    public void  botonHuirCancelar(MouseEvent mouseEvent) {
        this.contenedorHuir.setVisible(false);

    }
    public void  botonHuirConfirmar(MouseEvent mouseEvent){
        this.contenedorHuir.setVisible(false);
        juego.getJugadorActual().rendirse();
        mostrarGanador(juego.getOponente());
    }
    public void actualizarEstados(){
        mostrarEstados(juego.getJugadorActual().getPokemonActual().getEstados(), estadosActuales);
        mostrarEstados(juego.getOponente().getPokemonActual().getEstados(), estadosEnemigos);
    }
    public void mostrarEstados(List<Estado> estados, List<Label> labelsEstados){
        for (int i = 0; i < labelsEstados.size(); i++) {
            Label label = labelsEstados.get(i);
            if (i < estados.size()) {
                String nombreEstado = estados.get(i).getNombre();
                label.setVisible(true);
                label.getStyleClass().clear();
                label.getStyleClass().addAll(nombreEstado, "Estado");
                label.setText(nombreEstado.substring(0,3).toUpperCase());
            } else {
                label.setVisible(false);
            }
        }
    }


    private void actualizarPokemonesRestantes(){
        mostrarPokemonesRestantes(juego.getJugadorActual().getCantidadPokemonVivos(), pokeballsActuales);
        mostrarPokemonesRestantes(juego.getOponente().getCantidadPokemonVivos(), pokeballsEnemigas);
    }

    private void mostrarPokemonesRestantes(int cantidad, List<ImageView> pokeballs) {
        for (int i=0; i < pokeballs.size(); i++) {
            if (cantidad > i) {
                ImageView pokeballImageView = pokeballs.get(i);
                Image pokeballImage = new Image(getClass().getResource("/org/fiuba/algoritmos3/background/pokeball.png").toString());
                pokeballImageView.setImage(pokeballImage);
            } else {
                ImageView pokeballImageView = pokeballs.get(i);
                Image pokeballImage = new Image(getClass().getResource("/org/fiuba/algoritmos3/background/pokeballGris.png").toString());
                pokeballImageView.setImage(pokeballImage);
            }
        }
    }

    public void show() throws IOException {
        this.stage.show();
        setJuego(SingletonJuego.getInstancia().getJuego());
        actualizarPokemonesRestantes();

        if (this.cambiarEscena == true) {
            cambiarDeTurno();
            cambiarEscena = false;
        }
    }

    public void setFondoBattleMain(String ruta) {
        Image image = new Image(getClass().getResource("/org/fiuba/algoritmos3/background/"+ruta+".jpg").toString());
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
    }
}
