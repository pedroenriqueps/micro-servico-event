package com.pedro.events_microservice.exceptions;

public class EventFullException extends RuntimeException {

    public EventNotFullException() {
        super("Evento está lotado");
    }

    public EventNotFullException(String message) {
        super(message);
    }
}
