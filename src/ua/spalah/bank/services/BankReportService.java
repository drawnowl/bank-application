package ua.spalah.bank.services;

import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;

import java.util.List;
import java.util.Map;

public interface BankReportService {

    int getNumberOfClients(Bank bank);
    int getNumberOfAccounts(Bank bank);
    double getTotalAccountSum(Bank bank);
    double getBankCreditSum(Bank bank);
    List<Client> getClientsSortedByName(Bank bank);
    Map<String, List<Client>> getClientsSortedByCity(Bank bank);
}
