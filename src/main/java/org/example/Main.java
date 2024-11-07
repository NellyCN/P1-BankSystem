package org.example;

import org.example.bank.model.Client;
import org.example.bank.service.ClientService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        System.out.println("Ingrese el nombre del cliente a Registrar");
        Scanner teclado = new Scanner(System.in);

        ClientService clientService = new ClientService();

        // Crear instancias de Client
        // Cliente válido
        Client client1 = new Client("Luis", "Pérez", "12345678", "luis.perez@gmail.com");
        clientService.registerClient(client1);

        // Cliente con DNI duplicado
        Client client2 = new Client("Maria", "García", "12345678", "maria.garcia@gmail.com");
        clientService.registerClient(client2);

        // Cliente con email inválido
        Client client3 = new Client("Mara", "López", "87654321", "mara.lopez@-");
        clientService.registerClient(client3);

        // Cliente con campo obligatorio faltante
        Client client4 = new Client("Luis", "", "98765432", "luis.perez@example.com");
        clientService.registerClient(client4);

        Client client5 = new Client("Felipe", "Dias", "10203050", "felipe.dias@gmail.com");
        clientService.registerClient(client5);

        // Mostrar todos los clientes válidos
        clientService.displayClients();
    }
}