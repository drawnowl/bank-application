package ua.spalah.bank.exceptions;

import ua.spalah.bank.models.Client;

public class ClientNotFoundException extends BankException {

    public ClientNotFoundException(Client client) {
        super(client.getName() + " not found");
    }

    public ClientNotFoundException(String name) {
        super(name + " not found");
    }
}
