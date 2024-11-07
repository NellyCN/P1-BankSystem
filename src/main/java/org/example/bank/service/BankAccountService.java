package org.example.bank.service;

import org.example.bank.model.BankAccount;
import org.example.bank.model.Client;

import java.util.*;


public class BankAccountService {
    //private final Map<String, BankAccount> bankAccounts = new HashMap<>();
    private List<BankAccount> bankAccounts = new ArrayList<>();
    private ClientService clientService;

    // Constructor que inyecta el servicio de cliente
    public BankAccountService(ClientService clientService) {
        this.clientService = clientService;
    }

    // **Metodo para abrir una cuenta bancaria.
    // Verifica que el cliente exista y genera un número de cuenta único.

    public void openAccount(String dni, BankAccount.AccountType type) {
        Optional<Client> clientOpt = clientService.getClientByDni(dni);

        // Verifica si el cliente existe (Abstracción y encapsulación)
        String accountNumber;
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();

            // Genera un número de cuenta único usando UUID
            accountNumber = UUID.randomUUID().toString();
            BankAccount newAccount = new BankAccount(accountNumber, 0.0, type, client);

            bankAccounts.add(newAccount);
            System.out.println("Cuenta " + type + " creada para el cliente " + client.getName());
        } else {
            System.out.println("Error: Cliente no fue encontrado.");
        }
    }

}