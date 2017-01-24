package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.models.CheckingAccount;
import ua.spalah.bank.models.SavingAccount;
import ua.spalah.bank.services.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddAccountCommand implements Command {

    private ClientServiceImpl clientService;

    public AddAccountCommand(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {

        if(!BankCommander.currentBank.getClients().isEmpty()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Add account to new client. SAVING or CHECKING?");
            try {
                String accountType = reader.readLine();

                double balance;
                if (accountType.equals("SAVING")) {
                    System.out.println("Add initial balance:");
                    balance = Double.parseDouble(reader.readLine());
                    SavingAccount savingAccount = new SavingAccount(balance);
                    clientService.addAccount(savingAccount, BankCommander.currentClient);
                } else if (accountType.equals("CHECKING")) {
                    System.out.println("Add initial balance:");
                    balance = Double.parseDouble(reader.readLine());
                    System.out.println("Add initial overdraft:");
                    double overdraft = Double.parseDouble(reader.readLine());
                    CheckingAccount checkingAccount = new CheckingAccount(balance, overdraft);
                    clientService.addAccount(checkingAccount, BankCommander.currentClient);
                } else { throw new VerifyError(); }
            } catch (IOException e) { e.printStackTrace(); }
        } else { throw new NullPointerException(); }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"10\" for get Add Account command");
    }
}