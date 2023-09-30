package org.fiuba.algoritmos3.views;


import org.fiuba.algoritmos3.items.Item;

import java.util.List;

public class ItemView {
    public void mostrarItem(Item item) {
        System.out.println(item.getNombre()+ " Cantidad:" + item.getCantidad());
    }
}