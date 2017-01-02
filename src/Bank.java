import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Bank {

    private ArrayList<ClientRegistrationListener> listeners = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    void addListener(ClientRegistrationListener listener) {
        listeners.add(listener);
    }

    void addClient(Client client) {
        clients.add(client);

        if(!listeners.isEmpty()) {
            for (ClientRegistrationListener listener : listeners) {
                listener.onClientAdded(client);
            }
        }
    }

    List<Client> getAllClients() {
        return Collections.unmodifiableList(clients);
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
