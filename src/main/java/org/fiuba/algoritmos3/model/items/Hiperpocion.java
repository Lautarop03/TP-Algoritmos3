package org.fiuba.algoritmos3.model.items;

public class Hiperpocion extends ItemRestauradorDeVida {

    public Hiperpocion(Integer cantidad) {
        super(cantidad);
        this.cantidadDeItems = verificarCantidad(cantidad);
        this.cantidadDeCura = 100;
        this.nombre = "HiperPoción";
        this.descripcion = "Restaura 100 de vida.";
    }

    private Integer verificarCantidad(Integer cantidad) {
        if(cantidad > 1){
            cantidad = 1;
        }
        return cantidad;
    }

}