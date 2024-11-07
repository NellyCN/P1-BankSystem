package org.example.bank.service;

import org.example.bank.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Optional;

public class ClientService {
    private List<Client> clients = new ArrayList<>();   // Crear Array List de Clientes

    // Método para obtener un cliente por su DNI
    public Optional<Client> getClientByDni(String dni) {
        // Usa un stream para buscar el cliente que coincide con el DNI proporcionado
        return clients.stream()
                .filter(client -> client.getDni().equals(dni))
                .findFirst();
    }

    // Método para registrar clientes (abstracción de la operación de agregar)
    public void registerClient(Client client) {

        // Validar campos obligatorios
        if (client.getName() == null || client.getName().isEmpty() ||
                client.getLastName() == null || client.getLastName().isEmpty() ||
                client.getDni() == null || client.getDni().isEmpty() ||
                client.getEmail() == null || client.getEmail().isEmpty()) {
            System.out.println("Error: El cliente " + client.getName() + " no se ha podido registrar! ...Todos los campos son obligatorios.");
            return;
        }

        // Validar que el DNI sea único
        for (Client c : clients) {
            if (c.getDni().equals(client.getDni())) {
                System.out.println("Error: El cliente " + client.getName() + " no se ha podido registrar! ... El DNI ya está registrado para otro cliente.");
                return;
            }
        }

        // Validar formato del email
        if (!isValidEmail(client.getEmail())) {
            System.out.println("Error: El cliente " + client.getName() + " no se ha podido registrar! ...  El formato del email no es válido.");
            return;
        }

        // Si pasa todas las validaciones, agrega el cliente
        clients.add(client);
        System.out.println("Cliente Registrado con Éxito: " + client.getName() + " " + client.getLastName());
    }

    // Método para verificar el formato de email
    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";    //Uso de Expresión regular para validar formato de email
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Método para mostrar todos los clientes (para verificación)
    public void displayClients() {
        System.out.println("");
        System.out.println("--- Lista de clientes Registrados: ---");
        for (Client client : clients) {
            System.out.println("Nombre: " + client.getName() + " " + client.getLastName());
            System.out.println("DNI: " + client.getDni());
            System.out.println("Email: " + client.getEmail());
            System.out.println("----------");
        }
    }
}
