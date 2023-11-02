package org.fiuba.algoritmos3.model.pokemon;
import java.util.HashMap;
import java.util.Map;
import org.fiuba.algoritmos3.model.pokemon.Tipo;


public class MatrizDeEfectividad {

/*
    private Map<Tipo, Map<Tipo, Double>> matriz2 = new HashMap<>();
*/



    private final double[][] matriz = {
            {0.5,1,0.5,1,1,2,1,1,1,0.5,1,2,2,1,1},
            {1,1,1,1,0.5,0.5,1,0.5,1,2,2,1,1,2,0.5},
            {1,1,2,1,1,1,1,1,1,1,1,1,1,1,1},
            {2,1,0.5,0.5,1,1,1,1,1,0.5,1,1,0,1,2},
            {1,1,1,1,2,1,1,1,0,1,0,1,1,1,1},
            {0.5,2,0.5,1,1,0.5,2,1,1,2,1,0.5,1,1,1},
            {0.5,1,2,1,1,1,0.5,1,1,2,1,1,2,1,2},
            {1,0.5,1,1,0,1,2,1,2,1,0.5,2,1,0.5,0.5},
            {1,1,1,1,0,1,1,1,1,1,1,0.5,1,1,1},
            {2,0.5,0.5,1,1,0.5,1,1,1,0.5,1,2,2,0.5,0.5},
            {1,1,1,1,1,1,1,2,1,1,0.5,1,1,2,1},
            {1,2,1,1,1,2,2,0.5,1,1,1,1,0.5,1,2},
            {1,0.5,1,2,1,2,1,1,1,0.5,1,2,1,2,0},
            {1,2,1,1,0.5,1,1,1,1,2,1,0.5,0.5,0.5,1},
            {1,2,1,0.5,1,1,1,2,1,2,1,0.5,1,1,1}};

    public MatrizDeEfectividad(){
/*        matriz2.put(Tipo.Agua, new HashMap<>());
        matriz2.get(Tipo.Agua).put(Tipo.Agua, 0.5);
        matriz2.get(Tipo.Agua).put(Tipo.Bicho, 1.0);
        matriz2.get(Tipo.Agua).put(Tipo.Dragon, 0.5);
        matriz2.get(Tipo.Agua).put(Tipo.Electrico, 1.0);
        matriz2.get(Tipo.Agua).put(Tipo.Fantasma, 1.0);
        matriz2.get(Tipo.Agua).put(Tipo.Fuego, 2.0);
        matriz2.get(Tipo.Agua).put(Tipo.Hielo, 1.0);
        matriz2.get(Tipo.Agua).put(Tipo.Lucha, 1.0);
        matriz2.get(Tipo.Agua).put(Tipo.Normal, 1.0);
        matriz2.get(Tipo.Agua).put(Tipo.Planta, 0.5);
        matriz2.get(Tipo.Agua).put(Tipo.Psiquico, 1.0);
        matriz2.get(Tipo.Agua).put(Tipo.Roca, 2.0);
        matriz2.get(Tipo.Agua).put(Tipo.Tierra, 2.0);
        matriz2.get(Tipo.Agua).put(Tipo.Veneno, 1.0);
        matriz2.get(Tipo.Agua).put(Tipo.Volador, 1.0);
        matriz2.put(Tipo.Bicho, new HashMap<>());
        matriz2.get(Tipo.Bicho).put(Tipo.Agua, 1.0);
        matriz2.get(Tipo.Bicho).put(Tipo.Bicho, 0.5);
        matriz2.get(Tipo.Bicho).put(Tipo.Dragon, 1.0);
        matriz2.get(Tipo.Bicho).put(Tipo.Electrico, 1.0);
        matriz2.get(Tipo.Bicho).put(Tipo.Fantasma, 0.5);
        matriz2.get(Tipo.Bicho).put(Tipo.Fuego, 0.5);
        matriz2.get(Tipo.Bicho).put(Tipo.Hielo, 1.0);
        matriz2.get(Tipo.Bicho).put(Tipo.Lucha, 0.5);
        matriz2.get(Tipo.Bicho).put(Tipo.Normal, 1.0);
        matriz2.get(Tipo.Bicho).put(Tipo.Planta, 2.0);
        matriz2.get(Tipo.Bicho).put(Tipo.Psiquico, 2.0);
        matriz2.get(Tipo.Bicho).put(Tipo.Roca, 1.0);
        matriz2.get(Tipo.Bicho).put(Tipo.Tierra, 1.0);
        matriz2.get(Tipo.Bicho).put(Tipo.Veneno, 2.0);
        matriz2.get(Tipo.Bicho).put(Tipo.Volador, 0.5);
        matriz2.put(Tipo.Dragon, new HashMap<>());
        matriz2.get(Tipo.Dragon).put(Tipo.Agua, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Bicho, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Dragon, 2.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Electrico, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Fantasma, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Fuego, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Hielo, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Lucha, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Normal, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Planta, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Psiquico, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Roca, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Tierra, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Veneno, 1.0);
        matriz2.get(Tipo.Dragon).put(Tipo.Volador, 1.0);
        matriz2.put(Tipo.Electrico, new HashMap<>());
        matriz2.get(Tipo.Electrico).put(Tipo.Agua, 2.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Bicho, 1.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Dragon, 0.5);
        matriz2.get(Tipo.Electrico).put(Tipo.Electrico, 0.5);
        matriz2.get(Tipo.Electrico).put(Tipo.Fantasma, 1.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Fuego, 1.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Hielo, 1.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Lucha, 1.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Normal, 1.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Planta, 0.5);
        matriz2.get(Tipo.Electrico).put(Tipo.Psiquico, 1.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Roca, 1.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Tierra, 0.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Veneno, 1.0);
        matriz2.get(Tipo.Electrico).put(Tipo.Volador, 2.0);
        matriz2.put(Tipo.Fantasma, new HashMap<>());
        matriz2.get(Tipo.Fantasma).put(Tipo.Agua, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Bicho, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Dragon, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Electrico, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Fantasma, 2.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Fuego, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Hielo, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Lucha, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Normal, 0.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Planta, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Psiquico, 0.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Roca, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Tierra, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Veneno, 1.0);
        matriz2.get(Tipo.Fantasma).put(Tipo.Volador, 1.0);
        matriz2.put(Tipo.Fuego, new HashMap<>());
        matriz2.get(Tipo.Fuego).put(Tipo.Agua, 0.5);
        matriz2.get(Tipo.Fuego).put(Tipo.Bicho, 2.0);
        matriz2.get(Tipo.Fuego).put(Tipo.Dragon, 0.5);
        matriz2.get(Tipo.Fuego).put(Tipo.Electrico, 1.0);
        matriz2.get(Tipo.Fuego).put(Tipo.Fantasma, 1.0);
        matriz2.get(Tipo.Fuego).put(Tipo.Fuego, 0.5);
        matriz2.get(Tipo.Fuego).put(Tipo.Hielo, 2.0);
        matriz2.get(Tipo.Fuego).put(Tipo.Lucha, 1.0);
        matriz2.get(Tipo.Fuego).put(Tipo.Normal, 1.0);
        matriz2.get(Tipo.Fuego).put(Tipo.Planta, 2.0);
        matriz2.get(Tipo.Fuego).put(Tipo.Psiquico, 1.0);
        matriz2.get(Tipo.Fuego).put(Tipo.Roca, 0.5);
        matriz2.get(Tipo.Fuego).put(Tipo.Tierra, 1.0);
        matriz2.get(Tipo.Fuego).put(Tipo.Veneno, 1.0);
        matriz2.get(Tipo.Fuego).put(Tipo.Volador, 1.0);*/
    }

    public double[][] getMatriz() {
        return matriz;
    }
}
