package org.uade.models;

public class ClientModel {
    private final String name;
    private final String lastName;
    private final int dni;

    public ClientModel(String name, String lastName, int dni) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }
}
