package org.example.bank.model;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private AccountType accountType;
    private Client client;

    public enum AccountType {       // Se crea el tipo de dato enum
        SAVINGS, CURRENT            // Ahorros y Corriente
    }

    // Constructor para inicializar una cuenta bancaria
    public BankAccount(String accountNumber, double initialBalance, AccountType accountType, Client client) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Método para depositar dinero en la cuenta
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    // Método para retirar dinero de la cuenta, considerando reglas de negocio
    public boolean withdraw(double amount) {
        if (accountType == AccountType.SAVINGS) {
            if (balance - amount >= 0) { // Validación para cuenta de ahorros
                balance -= amount;
                return true;
            } else {
                System.out.println("Error: No se puede retirar, saldo insuficiente en cuenta de ahorros.");
            }
        } else if (accountType == AccountType.CURRENT) {
            if (balance - amount >= -500) { // Límite de sobregiro para cuenta corriente
                balance -= amount;
                return true;
            } else {
                System.out.println("Error: No se puede retirar, límite de sobregiro alcanzado en cuenta corriente.");
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "numeroCuenta='" + accountNumber + '\'' +
                ", saldo=" + balance +
                ", tipoCuenta=" + accountType +
                ", client=" + client.getName() + " " + client.getLastName() +
                '}';
    }
}
