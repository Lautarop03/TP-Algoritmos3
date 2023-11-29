package org.fiuba.algoritmos3.controller.Eventos;

import javafx.event.Event;
import javafx.event.EventType;

public class CambioTurnoEvent extends Event {
    public static EventType<CambioTurnoEvent> CAMBIO_TURNO_EVENT = new EventType<>("Cambio de Turno Event");

    public CambioTurnoEvent() {
        super(CAMBIO_TURNO_EVENT);
    }
}
