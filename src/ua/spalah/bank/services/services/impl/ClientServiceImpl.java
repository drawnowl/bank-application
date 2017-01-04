package ua.spalah.bank.services.services.impl;

import ua.spalah.bank.Bank;
import ua.spalah.bank.Client;
import ua.spalah.bank.services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Override
    public Client findClientByName(Bank bank, String name) {
        List<Client> clients = bank.getAllClients();
        for (Client client: clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> findAllClients(Bank bank) {
        List<Client> clients = bank.getAllClients();
        return clients;
    }

    @Override
    public Client saveClient(Bank bank, Client client) {
        bank.addClient(client);
        return client;
    }

    @Override
    public void deleteClient(Bank bank, Client client) {
        bank.removeClient(client);
    }
}
