package org.fiuba.algoritmos3.controller.Eventos;

import javafx.event.Event;
import javafx.event.EventType;

public class SeleccionPokemonEvent extends Event {
    public static EventType<SeleccionPokemonEvent> POKEMON_EVENT = new EventType<>("Se selecciono un pokemon");
    public SeleccionPokemonEvent() {super(POKEMON_EVENT);}
}
