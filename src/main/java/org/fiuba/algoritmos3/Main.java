package org.fiuba.algoritmos3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Inputs input = new Inputs();
        int opcion = input.pedirAccion();
        String nombre = input.pedirNombre();
        System.out.println("Opcion: " + opcion);
        System.out.println("Nombre: " + nombre);
    }
}