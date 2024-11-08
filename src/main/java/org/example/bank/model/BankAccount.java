package org.example.bank.model;

import java.util.UUID;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private AccountType accountType;
    private String dniClient;

    public enum AccountType {       // Se crea el tipo de dato enum
        AHORROS, CORRIENTE            // Ahorros y Corriente
    }
    public BankAccount() {

    }

    // Constructor para inicializar una cuenta bancaria
    public BankAccount(AccountType accountType, String dniClient) {
        this.accountNumber = accountNumber();
    //    this.balance = initialBalance;
        this.accountType = accountType;
        this.dniClient = dniClient;
    }

    // El numero de Cuenta String debe ser único
    private String accountNumber() {
        return UUID.randomUUID().toString();
    }

    // Métodos Getters y Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getDniClient() {     // TIPO Y METODO
        return dniClient;
    }

    public void setDniClient(String client) {
        this.dniClient = client;
    }
}
