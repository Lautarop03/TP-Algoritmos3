package org.fiuba.algoritmos3.model;

import org.fiuba.algoritmos3.model.items.Item;
import org.fiuba.algoritmos3.model.pokemon.Pokemon;
import org.fiuba.algoritmos3.model.pokemon.habilidades.Habilidad;
import org.fiuba.algoritmos3.views.ViewControlador;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.List;

public class Inputs {
    private final LineReader reader;
    private final ViewControlador viewControlador;

    public Inputs() throws IOException {
        this.viewControlador = new ViewControlador();
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

    private int validarOpcion(int limiteInferior, int limiteSuperior) {
        while (true) {
            String input = reader.readLine("Ingrese numero de la opcion deseada: ");
            try {
                int opcion = Integer.parseInt(input);
                if (opcion >= limiteInferior && opcion <= limiteSuperior) {
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
        return validarOpcion(1,acciones.length);
    }

    public int pedirItem(List<Item> items) {
        System.out.println("0. Volver al menu de acciones");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. ", (i + 1));
            viewControlador.mostrarItem(items.get(i));
        }
        return validarOpcion(0,items.size()) - 1;
    }

    public int pedirPokemonMuerto(List<Pokemon> pokemones) {
        System.out.print("Pokemon Actual: ");
        viewControlador.mostrarPokemon(pokemones.get(0));
        for (int i = 1; i < pokemones.size(); i++) {
            System.out.printf("%d. ",(i));
            viewControlador.mostrarPokemon(pokemones.get(i));
        }
        return validarOpcion(1,pokemones.size()-1);
    }

    public int pedirPokemon(List<Pokemon> pokemones) {
        for (int i = 0; i < pokemones.size(); i++) {
            System.out.printf("%d. ",(i + 1));
            viewControlador.mostrarPokemon(pokemones.get(i));
        }
        return validarOpcion(0,pokemones.size())-1;
    }

    public int pedirHabilidad(List<Habilidad> habilidades) {
        System.out.println("0. Volver al menu de acciones");
        for (int i = 0; i < habilidades.size(); i++) {
            System.out.printf("%d. ",(i+1));
            viewControlador.mostrarHabilidad(habilidades.get(i));
        }
        return validarOpcion(0,habilidades.size())-1;
    }
}
