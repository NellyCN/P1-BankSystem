package org.example.bank.service;

import org.example.bank.model.Client;

import java.util.ArrayList;

public class ClientService {

//    // Metodo para registrar un cliente nuevo
        public void registerClient(Client client) {
            System.out.println(client.name);    //Imprimimos del objeto cliente, clase Client
            System.out.println(client.lastName);

            // Crear Array List de Clientes
            ArrayList<Client> clients = new ArrayList<>();

            Client newClient = new Client();
            newClient.name = "Maria";
            newClient.lastName = "Mendoza";
            newClient.dni = "10203042";
            newClient.email = "ana@gmail.com";
            clients.add(newClient);

            for (Client client1 : clients) {
                if (client1.dni.equals(client.dni)) {
                    throw new IllegalArgumentException("El DNI ya está registrado");
                }
                else {
                    System.out.printf("Cliente Registrado con éxito!");
                }
            }
        }
}
