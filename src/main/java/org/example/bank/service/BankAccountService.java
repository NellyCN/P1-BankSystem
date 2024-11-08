package org.example.bank.service;

import org.example.bank.model.BankAccount;
import org.example.bank.model.Client;

import java.util.*;


public class BankAccountService {

    private List<BankAccount> bankAccounts = new ArrayList<>();
    private ClientService clientService;

    // Constructor que inyecta el servicio de cliente
    public BankAccountService(ClientService clientService) {
        this.clientService = clientService;
    }

    // **Metodo para abrir una cuenta bancaria.
    // Verifica que el cliente exista y genera un número de cuenta único..

    public void openAccount(String dni, BankAccount.AccountType type) {
        Optional<Client> clientOpt = clientService.getClientByDni(dni);

        // Verifica si el cliente existe (Abstracción y encapsulación)
        String accountNumber;
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();

            // Genera un número de cuenta único usando UUID
//            accountNumber = UUID.randomUUID().toString();
              BankAccount newAccount = new BankAccount(type, client.getDni());

            bankAccounts.add(newAccount);
            System.out.println("Se creó la cuenta de " + type + " para el cliente " + client.getName() + " con éxito!");
        } else {
            System.out.println("Error: Cliente no fue encontrado.");
        }
    }

    // Método para obtener una cuenta por DNI
    public Optional<BankAccount> getAccountByDni(String dni) {
        // Usa un stream para buscar el cliente que coincide con el DNI proporcionado
        return Accounts().stream()
                .filter(bankAccount -> bankAccount.getDniClient().equals(dni))
                .findFirst();
    }


    // Método pora depositar
    public void deposit(String dni, String accountNumber, double amount) {
        Optional<BankAccount> accountOpt = getAccountByDni(dni);

        // Verifica si el cliente existe, se realizará el deposito (Abstracción y encapsulación)
        if (accountOpt.isPresent()) {
            BankAccount bankAccount = accountOpt.get();
            Double newBalance = bankAccount.getBalance() + amount;
            bankAccount.setBalance(newBalance);
            System.out.println("Su nuevo saldo es: " + bankAccount.getBalance());
        }

    }


    //Método Accounts() para crear Array de Objetos de cuentas bancarias
    public List<BankAccount> Accounts() {       //METODO
        BankAccount bankAccount1 = new BankAccount();       //OBJETO
        bankAccount1.setAccountNumber("100");
        bankAccount1.setAccountType(BankAccount.AccountType.AHORROS);
        bankAccount1.setBalance(1000);
        bankAccount1.setDniClient("70101050");

        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.setAccountNumber("200");
        bankAccount2.setAccountType(BankAccount.AccountType.CORRIENTE);
        bankAccount2.setBalance(1200);
        bankAccount2.setDniClient("20106050");

        // Arreglo de Cuentas Bancarias
        List<BankAccount> AccountList = new ArrayList<>();
        AccountList.add(bankAccount1);
        AccountList.add(bankAccount2);
        return AccountList;
    }

}