package org.example;

import org.example.bank.model.Client;
import org.example.bank.service.ClientService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

            // Registrar Cliente
            // Crear un objeto con sus atributos
            Client newClient = new Client();
            newClient.name = "Ana";
            newClient.lastName = "Perez";
            newClient.dni = "10203040";
            newClient.email = "ana@gmail.com";

            ClientService clientService = new ClientService();   // Instancio la clase ClientService() con el objeto clientService
            clientService.registerClient(newClient);            // Llamar al servicio


    }
}