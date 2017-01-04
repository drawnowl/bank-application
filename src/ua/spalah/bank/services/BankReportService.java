package ua.spalah.bank.services;

import ua.spalah.bank.Bank;
import ua.spalah.bank.Client;

import java.util.List;

public interface BankReportService {

    int getNumberOfClients(Bank bank);
    int getNumberOfAccounts(Bank bank);
    double getTotalAccountSum(Bank bank);
    double getBankCreditSum(Bank bank);
    List<Client> getClientsSortedByName(Bank bank);

}
