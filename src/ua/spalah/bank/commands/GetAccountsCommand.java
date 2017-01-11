package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;

public class GetAccountsCommand implements Command {

    @Override
    public void execute() {
        System.out.println(BankCommander.currentClient.getAccounts().toString());
        System.out.println(BankCommander.currentClient.getActiveAccount().toString() + " - is Active Account");
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"5\" for take Get Accounts command");
    }
}
