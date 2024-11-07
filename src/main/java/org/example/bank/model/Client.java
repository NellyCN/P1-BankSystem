package org.example.bank.model;

public class Client {
    private String name;
    private String lastName;
    private String dni;
    private String email;

    // Constructor
    public Client(String nombre, String apellido, String dni, String email) {
        this.name = nombre;
        this.lastName = apellido;
        this.dni = dni;
        this.email = email;
    }

    // Getters y Setters (encapsulamiento)
    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + " " + lastName + "\nDNI: " + dni + "\nEmail: " + email;
    }
}
