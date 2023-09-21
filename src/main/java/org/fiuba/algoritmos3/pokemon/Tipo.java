package org.fiuba.algoritmos3.pokemon;

public enum Tipo {
    Agua(0),
    Bicho(1),
    Dragon(2),
    Electrico(3),
    Fantasma(4),
    Fuego(5),
    Hielo(6),
    Lucha(7),
    Normal(8),
    Planta(9),
    Psiquico(10),
    Roca(11),
    Tierra(12),
    Veneno(13),
    Volador(14);

    private final int indice;

    Tipo(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }
}
