module TP.Algoritmos {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jline;
    requires com.google.gson;

    opens org.fiuba.algoritmos3 to javafx.fxml;
    exports org.fiuba.algoritmos3;
}