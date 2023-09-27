package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.items.Item;
import org.fiuba.algoritmos3.views.ItemView;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.List;

public class Inputs {
    private final LineReader reader;
    private ItemView itemView;
    public Inputs() throws IOException {
        this.itemView = new ItemView();
        Terminal terminal = TerminalBuilder.terminal();

        reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build();
    }

    public String pedirNombre() {
        while (true) {
            String nombre = reader.readLine("Ingrese nombre de jugador: ");
            if (nombre.length() <= 50) {
                return nombre;
            } else {
                System.out.println("El nombre debe tener como maximo 50 caracteres");
            }
        }
    }
    public int validarOpcion(int cantidad) {
        while (true) {
            String input = reader.readLine("Ingrese numero de la opcion deseada: \n");
            try {
                int opcion = Integer.parseInt(input);
                if (opcion >= 1 && opcion <= cantidad) {
                    return opcion;
                } else {
                    System.out.println("Opcion no valida. Por favor, ingrese un numero valido.");
                }
            } catch (NumberFormatException exepcion) {
                System.out.println("Entrada no valida. Por favor, ingrese un numero");
            }
        }
    }
    public int pedirAccion() {
        String[] acciones = {"Rendirse","Ver el campo de batalla","Intercambiar Pokemon","Aplicar item","Ataque"};
        for (int i = 0; i < acciones.length; i++) {
            System.out.println((i+1) + ". " + acciones[i]);
        }
        return validarOpcion(acciones.length);
    }
    public int pedirItem(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. ",(i+1));
            itemView.mostrarItem(items.get(i));
        }
        return validarOpcion(items.size());
    }
}
