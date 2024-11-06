package org.example.bank.model;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private AccountType accountType;

    public enum AccountType {       // Se crea el tipo de dato enum
        AHORROS, CORRIENTE
    }
}
