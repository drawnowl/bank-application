package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.exceptions.ClientNotFoundException;
import ua.spalah.bank.services.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindClientCommand implements Command {

    private ClientServiceImpl clientService;

    public FindClientCommand(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String name = reader.readLine();
            try {
                System.out.println(BankCommander.currentClient = clientService.findClientByName(BankCommander.currentBank, name));
            } catch (ClientNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"4\" for get Find Client command");
    }
}
