package org.uade.exceptions;

public class ClientAlreadyRegisteredException extends RuntimeException {
    public ClientAlreadyRegisteredException(String message) {
        super(message);
    }
}
