package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.models.AccountType;
import ua.spalah.bank.models.CheckingAccount;
import ua.spalah.bank.services.impl.AccountServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransferCommand implements Command {

    private AccountServiceImpl accountService;

    public TransferCommand(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter from what of account you want to transfer: CHECKING OR SAVING");
        try {
            String fromAcc = reader.readLine();
            if(fromAcc.equals("CHECKING") & BankCommander.currentClient.getAccounts().contains(AccountType.CHECKING)) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter amount number");
        try {
            double amount = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"8\" for get Transfer command");
    }
}
