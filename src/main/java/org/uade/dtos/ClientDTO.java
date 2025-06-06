package org.uade.dtos;

public class ClientDTO {
    private final String name;
    private final String lastName;
    private final int dni;

    public ClientDTO(String name, String lastName, int dni) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDni() {
        return dni;
    }
}