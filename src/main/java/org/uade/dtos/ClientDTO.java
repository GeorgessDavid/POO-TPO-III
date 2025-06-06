package org.uade.dtos;

public class ClientDTO {
    private String name;
    private String lastName;
    private int dni;

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