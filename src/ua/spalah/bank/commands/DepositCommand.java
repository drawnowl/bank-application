package ua.spalah.bank.commands;
import ua.spalah.bank.BankCommander;
import ua.spalah.bank.services.impl.AccountServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepositCommand implements Command {

    private AccountServiceImpl accountService;

    public DepositCommand(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("How much amount you want to deposit");
        try {
            double amount = Double.parseDouble(reader.readLine());
            accountService.deposit(BankCommander.currentClient.getActiveAccount(), amount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"2\" for get Deposit command");
    }
}
