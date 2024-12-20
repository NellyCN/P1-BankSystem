package org.example;

import org.example.bank.model.Client;
import org.example.bank.model.BankAccount;
import org.example.bank.service.ClientService;
import org.example.bank.service.BankAccountService;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        BankAccountService bankAccountService = new BankAccountService(clientService);

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

        // Cliente válido
        Client client5 = new Client("Felipe", "Dias", "10203050", "felipe.dias@gmail.com");
        clientService.registerClient(client5);

        // Abrir una cuenta corriente para el cliente no registrado
        bankAccountService.openAccount("12340000", BankAccount.AccountType.CORRIENTE);

        // Abrir una cuenta de ahorros para el cliente registrado
        bankAccountService.openAccount("12345678", BankAccount.AccountType.AHORROS);

        bankAccountService.deposit("70101050", "100", 100);
        // Mostrar todos los clientes válidos
        clientService.displayClients();

    }
}