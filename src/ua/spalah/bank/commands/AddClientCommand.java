package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.models.*;
import ua.spalah.bank.services.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddClientCommand implements Command {

    private ClientServiceImpl clientService;

    public AddClientCommand(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Create client. Enter client's name: ");
            String name = reader.readLine();
            System.out.println("Choose gender: MALE or FEMALE");
            String gender = reader.readLine();

            if(gender.equals("MALE")) {
                BankCommander.currentClient = clientService.saveClient(BankCommander.currentBank, new Client(name, Gender.MALE));
            } else if(gender.equals("FEMALE")) {
                BankCommander.currentClient = clientService.saveClient(BankCommander.currentBank, new Client(name, Gender.FEMALE));
            } else {
                throw new VerifyError();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"1\" for get Add Client command");
    }
}
