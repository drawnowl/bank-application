package ua.spalah.bank;

import ua.spalah.bank.listeners.ClientRegistrationListener;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private ArrayList<ClientRegistrationListener> listeners = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    void addListener(ClientRegistrationListener listener) {
        listeners.add(listener);
    }

    public void addClient(Client client) {
        clients.add(client);
        for (ClientRegistrationListener listener : listeners) {
            listener.onClientAdded(client);
        }
    }

    public void removeClient(Client client) {
        if(clients.contains(client)) {
            clients.remove(client);
        }
    }

    public List<Client> getAllClients() {
        return clients;
    }

    void getClientFullInfo(String name) {
        for (Client client: clients) {
            if(client.getName().equals(name)) {
                System.out.println(client.toString());
                return;
            }
        }
        System.out.println("Can't find client");
    }
}
