package ua.spalah.bank.models;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Client> clients = new ArrayList<>();

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
