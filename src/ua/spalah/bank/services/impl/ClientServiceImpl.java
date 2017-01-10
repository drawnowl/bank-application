package ua.spalah.bank.services.impl;

import ua.spalah.bank.exceptions.ClientNotFoundException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Override
    public Client findClientByName(Bank bank, String name) throws ClientNotFoundException {
        List<Client> clients = bank.getClients();
        for (Client client: clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        throw new ClientNotFoundException(name);
    }

    @Override
    public List<Client> findAllClients(Bank bank) {
        List<Client> clients = bank.getClients();
        return clients;
    }

    @Override
    public Client saveClient(Bank bank, Client client) {
        List<Client> clients = bank.getClients();
        clients.add(client);
        bank.setClients(clients);
        return client;
    }

    @Override
    public void deleteClient(Bank bank, Client client) throws ClientNotFoundException {
        List<Client> clients = bank.getClients();
        if(clients.contains(client)) {
            clients.remove(client);
            bank.setClients(clients);
        }
        throw new ClientNotFoundException(client);
    }

    @Override
    public double getTotalBalance(Client client) {
        double result = 0;

        List<Account> accounts = client.getAccounts();
        for (Account account : accounts) {
            result += account.getBalance();
        }
        return result;
    }

    @Override
    public void addAccount(Account account, Client client) {
        List<Account> accounts = client.getAccounts();
        if(accounts.isEmpty()) {
            client.setActiveAccount(account);
        }
        accounts.add(account);
        client.setAccounts(accounts);
    }

    @Override
    public void setActiveAccount(Account account, Client client) {
        List<Account> accounts = client.getAccounts();
        if(accounts.contains(account)) {
            client.setActiveAccount(account);
        }
    }
}
