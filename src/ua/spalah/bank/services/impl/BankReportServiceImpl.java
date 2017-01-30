package ua.spalah.bank.services.impl;

import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.BankReportService;

import java.util.*;

public class BankReportServiceImpl implements BankReportService {

    @Override
    public int getNumberOfClients(Bank bank) {
        return bank.getClients().size();
    }

    @Override
    public int getNumberOfAccounts(Bank bank) {
        int result = 0;

        for (Client client : bank.getClients()) {
            result += client.getAccounts().size();
        }
        return result;
    }

    @Override
    public double getTotalAccountSum(Bank bank) {
        double result = 0;

        for (Client client : bank.getClients()) {
            for (Account account : client.getAccounts()) {
                result += account.getBalance();
            }
        }
        return result;
    }

    @Override
    public double getBankCreditSum(Bank bank) {
        double result = 0;
        List<Account> accounts;

        for (Client client : bank.getClients()) {
            accounts = client.getAccounts();
            for (Account account : accounts) {
                if (account.getBalance() < 0) {
                    result -= account.getBalance();
                }
            }
        }
        return result;
    }

    @Override
    public List<Client> getClientsSortedByName(Bank bank) {
        List<Client> clients = bank.getClients();
        Collections.sort(clients, new Comparator<Client>() {
            public int compare(Client o1, Client o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return clients;
    }

    @Override
    public Map<String, Client> getClientsByCity(Bank bank) {
        Map<String, Client> clientMap = new TreeMap<>();

        for (Client client: bank.getClients()) {
            clientMap.put(client.getCity(), client);
        }
        return clientMap;
    }
}