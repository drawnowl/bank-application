package ua.spalah.bank;

import ua.spalah.bank.exceptions.ClientNotFoundException;
import ua.spalah.bank.exceptions.NotEnoughFundsException;
import ua.spalah.bank.models.*;
import ua.spalah.bank.services.impl.AccountServiceImpl;
import ua.spalah.bank.services.impl.BankReportServiceImpl;
import ua.spalah.bank.services.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, ClientNotFoundException, NotEnoughFundsException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Bank bank = new Bank();
        AccountServiceImpl accountService = new AccountServiceImpl();
        BankReportServiceImpl bankReportService = new BankReportServiceImpl();
        ClientServiceImpl clientService = new ClientServiceImpl();

        CheckingAccount standartCheckingAccount = new CheckingAccount(250, 50);
        SavingAccount standartSavingAccount = new SavingAccount(50);

        Client nick = new Client("Nick", Gender.MALE);
        Client sharon = new Client("Sharon", Gender.FEMALE);
        Client steve = new Client("Steve", Gender.MALE);
        Client ben = new Client("Ben", Gender.MALE);
        Client olga = new Client("Olga", Gender.FEMALE);

        clientService.addAccount(standartCheckingAccount, nick);
        clientService.addAccount(standartSavingAccount, nick);

        clientService.addAccount(standartCheckingAccount, sharon);
        clientService.addAccount(standartSavingAccount, sharon);
        clientService.addAccount(standartCheckingAccount, sharon);

        clientService.addAccount(standartCheckingAccount, steve);
        clientService.addAccount(standartSavingAccount, steve);
        clientService.addAccount(standartCheckingAccount, steve);

        clientService.addAccount(standartCheckingAccount, ben);
        clientService.addAccount(standartSavingAccount, ben);
        clientService.addAccount(standartCheckingAccount, ben);

        clientService.addAccount(standartCheckingAccount, olga);
        clientService.addAccount(standartSavingAccount, olga);
        clientService.addAccount(standartCheckingAccount, olga);

        clientService.saveClient(bank, nick);
        clientService.saveClient(bank, sharon);
        clientService.saveClient(bank, steve);
        clientService.saveClient(bank, olga);

        accountService.withdraw(standartCheckingAccount,  300);
        System.out.println(standartCheckingAccount.getBalance());
        System.out.println(standartCheckingAccount.getType());
    }
}
