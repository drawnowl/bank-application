import accounts.Account;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BankReportServiceImpl implements BankReportService {

    @Override
    public int getNumberOfClients(Bank bank) {
        return bank.getAllClients().size();
    }

    @Override
    public int getNumberOfAccounts(Bank bank) {

        int result = 0;
        List<Client> clients = bank.getAllClients();

        for (Client client: clients) {
            result += client.getAccounts().size();
        }
        return result;
    }

    @Override
    public double getTotalAccountSum(Bank bank) {

        int result = 0;
        List<Client> clients = bank.getAllClients();
        List<Account> accounts;

        for (Client client: clients) {
            accounts = client.getAccounts();
            for (int i = 0; i < accounts.size(); i++) {
                result += accounts.get(i).getBalance();
            }
        }
        return result;
    }

    @Override
    public double getBankCreditSum(Bank bank) {

        int result = 0;
        List<Client> clients = bank.getAllClients();
        List<Account> accounts;

        for (Client client: clients) {
            accounts = client.getAccounts();
            for (int i = 0; i < accounts.size(); i++) {
                if(accounts.get(i).getBalance() < 0) {
                    result -= accounts.get(i).getBalance();
                }
            }
        }
        return result;
    }

    @Override
    public List<Client> getClientsSortedByName(Bank bank) {

        List<Client> clients = bank.getAllClients();
        Collections.sort(clients, new Comparator<Client>() {
            public int compare(Client o1, Client o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return clients;
    }
}
