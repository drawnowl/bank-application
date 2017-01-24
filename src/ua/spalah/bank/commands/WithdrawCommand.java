package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.exceptions.NotEnoughFundsException;
import ua.spalah.bank.services.impl.AccountServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WithdrawCommand implements Command {

    private AccountServiceImpl accountService;

    public WithdrawCommand(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("How much amount you want to Withdraw");
        try {
            double amount = Double.parseDouble(reader.readLine());
            try {
                accountService.withdraw(BankCommander.currentClient.getActiveAccount(), amount);
            } catch (NotEnoughFundsException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"9\" for get Withdraw command");
    }
}
