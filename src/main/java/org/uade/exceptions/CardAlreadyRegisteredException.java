package org.uade.exceptions;

public class CardAlreadyRegisteredException extends RuntimeException {
    public CardAlreadyRegisteredException(String message) {
        super(message);
    }
}
