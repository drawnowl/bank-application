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
        List<Client> clients = bank.getClients();

        for (Client client : clients) {
            result += client.getAccounts().size();
        }
        return result;
    }

    @Override
    public double getTotalAccountSum(Bank bank) {
        double result = 0;
        List<Client> clients = bank.getClients();
        List<Account> accounts;

        for (Client client : clients) {
            accounts = client.getAccounts();
            for (Account account: accounts) {
                result += account.getBalance();
            }
        }
        return result;
    }

    @Override
    public double getBankCreditSum (Bank bank) {
        double result = 0;
        List<Client> clients = bank.getClients();
        List<Account> accounts;

        for (Client client : clients) {
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
    public List<Client> getClientsSortedByName (Bank bank) {
        List<Client> clients = bank.getClients();
        Collections.sort(clients, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return clients;
    }

    @Override
    public Map<String, List<Client>> getClientsSortedByCity(Bank bank) {
        Map<String, List<Client>> clients = new HashMap<>();
        List list = new ArrayList(clients.entrySet());
        Collections.sort(list, (Comparator<Map.Entry<String, List<Client>>>) (a, b) -> a.getKey().compareTo(b.getKey()));
        return clients;
    }
}