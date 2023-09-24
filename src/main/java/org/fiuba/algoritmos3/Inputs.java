package org.fiuba.algoritmos3;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class Inputs {
    private LineReader reader;
    public Inputs() throws IOException {

        Terminal terminal = TerminalBuilder.terminal();

        reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build();}
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

    public int pedirAccion() {
        String[] acciones = {"Rendirse","Ver el campo de batalla","Intercambiar Pokemon","Aplicar item","Ataque"};
        for (int i = 0; i < acciones.length; i++) {
            System.out.println((i+1) + ". " + acciones[i]);
        }
        while (true) {
            String input = reader.readLine("Ingrese numero de la opcion deseada: ");

            try {
                int opcion = Integer.parseInt(input);
                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                } else {
                    System.out.println("Opcion no valida. Por favor, ingrese un numero valido.");
                }
            } catch (NumberFormatException exepcion) {
                System.out.println("Entrada no valida. Por favor, ingrese un numero");
            }
        }
    }

}
