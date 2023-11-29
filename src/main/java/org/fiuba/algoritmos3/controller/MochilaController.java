package org.fiuba.algoritmos3.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.fiuba.algoritmos3.ControladorDeJuego;
import org.fiuba.algoritmos3.Inputs;
import org.fiuba.algoritmos3.controller.Eventos.CambioTurnoEvent;
import org.fiuba.algoritmos3.model.AdministradorDeJuego;
import org.fiuba.algoritmos3.model.Juego;
import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.views.ViewControlador;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MochilaController extends Controller {

    @FXML
    public Label labelItem1;
    @FXML
    public Pane descripcionContainer;
    @FXML
    public VBox confirmacionContainer;
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
    @FXML
    public Label LabelConfirmacion;

    @FXML
    public Button botonVolver;

    private List<Item> items;
    private Stage stage;
    private Controller controller;
    private Item item;




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
            if (item.getCantidad() ==0){
                continue;
            }
            mostrarHileraItem(item, i);
            altura += 50;
        }
        itemsContainer.setPrefHeight(altura);
        VBox newContenedorPrincipal = new VBox();
        newContenedorPrincipal.getChildren().addAll(contenedorPrincipal.getChildren());
        newContenedorPrincipal.setPrefSize(contenedorPrincipal.getPrefWidth(), contenedorPrincipal.getPrefHeight());

        Scene scene = new Scene(newContenedorPrincipal);
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
        confirmacionContainer.setVisible(true);
        descripcionContainer.setVisible(false);
        itemsContainer.setDisable(true);
        this.item = item;
    }
    public void cancelarBtn(){
        confirmacionContainer.setVisible(false);
        descripcionContainer.setVisible(true);
        itemsContainer.setDisable(false);
    }



    public void handleConfirmarSalir() throws IOException {
//        confirmacionContainer.fireEvent(new CambioTurnoEvent());
        controller.show();
        this.stage.close();
        controller.cambiarEscena = true;
    }

    public void confirmarBtn() throws IOException{
        confirmacionContainer.setVisible(false);
        descripcionContainer.setVisible(true);
        itemsContainer.setDisable(false);
        Pokemon pokemon = cambiarAPokemon(); // Si solo vuelve a la mochila, pokemon es NULL
        if (pokemon!=null) {
            Boolean aplicado = item.aplicarItem(pokemon);
            if (!aplicado) {
                LabelConfirmacion.setText("El item " + item.getNombre() + " se aplico correctamente en " + pokemon.getNombre());
                LabelConfirmacion.setVisible(true);
                descripcionContainer.setVisible(false);
                itemsContainer.setDisable(true);
                botonVolver.setDisable(true);
                controller.cambiarEscena = true;
            } else {
                descripcionLabel.setText("El item " + item.getNombre() + " no se pudo aplicar, elija otro pokemon u objeto.");
            }
        }
    }


    public Pokemon cambiarAPokemon() throws IOException{
        Juego juego = SingletonJuego.getInstancia().getJuego();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fiuba/algoritmos3/plantillas/seleccionPokemon.fxml"));
        Parent root = loader.load();
        SeleccionPokemonController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(juego.getJugadorActual().getPokemones(),stage,this);
        this.stage.close();
        stage.showAndWait();
        return controller.getPokemonSeleccionado();
    }

    public void volverBtn() throws IOException {
           controller.show();
           this.stage.close();
    }
    public void show() {
        this.stage.show();
    }
    public void init(List<Item> items, Stage stage, Controller controller) throws IOException {
        setItems(items,stage);
        this.stage = stage;
        this.controller = controller;
    }
}
