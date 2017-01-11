package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.exceptions.ClientNotFoundException;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveClientCommand implements Command {

    private ClientServiceImpl clientService;

    public RemoveClientCommand(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name client what you want to remove");
            try {
                String name = bufferedReader.readLine();
                Client client = clientService.findClientByName(BankCommander.currentBank, name);
                clientService.deleteClient(BankCommander.currentBank, client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClientNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"7\" for get Remove Clients command");
    }
}
