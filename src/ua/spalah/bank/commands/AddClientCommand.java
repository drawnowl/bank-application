package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.models.*;
import ua.spalah.bank.services.impl.ClientServiceImpl;
import ua.spalah.bank.support.RegExChecks;

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

            if(!gender.equals("MALE") && !gender.equals("FEMALE")) {
                System.out.println("Wrong gender input");
                return;
            }

            System.out.println("Enter client's email");
            String email = reader.readLine();
            if(!RegExChecks.emailCheck(email)) {
                System.out.println("Wrong email format");
                return;
            }

            System.out.println("In what city live our client?");
            String city = reader.readLine();

            System.out.println("Enter client's phone number");
            String phoneNumber = reader.readLine();
            if(!RegExChecks.phoneCheck(phoneNumber)) {
                System.out.println("Wrong phone number format");
                return;
            }

            if(gender.equals("MALE")) {
                clientService.saveClient(BankCommander.currentBank, new Client(name, Gender.MALE, email, city, phoneNumber));
                return;
            }
            clientService.saveClient(BankCommander.currentBank, new Client(name, Gender.FEMALE, email, city, phoneNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"1\" for get Add Client command");
    }
}