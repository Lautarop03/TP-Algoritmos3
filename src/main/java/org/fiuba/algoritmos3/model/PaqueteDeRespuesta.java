package org.fiuba.algoritmos3.model;

public class PaqueteDeRespuesta<T> {
    private boolean mibool;
    private T generico;

    public PaqueteDeRespuesta(boolean mibool, T generico) {
        this.mibool = mibool;
        this.generico = generico;
    }

    public boolean getError() {
        return mibool;
    }

    public T getGenerico() {
        return generico;
    }
}
