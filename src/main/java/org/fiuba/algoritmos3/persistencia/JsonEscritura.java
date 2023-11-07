package org.fiuba.algoritmos3.persistencia;

import com.google.gson.Gson;

public class JsonEscritura {
    private Gson writer;

    public JsonEscritura() {
        this.writer = new Gson();
    }
}
