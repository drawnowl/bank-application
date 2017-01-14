package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;

public class SelectActiveAccountCommand implements Command {

    @Override
    public void execute() {

        // BankCommander.currentClient.getActiveAccount(); - ? =)
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"11\" for get Select Active Account command");
    }
}
