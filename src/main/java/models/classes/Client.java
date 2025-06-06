package models.classes;

public class Client {

    private String name;
    private String lastName;
    private int dni;

    public Client(String name, String lastName, int dni) {
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
