import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Bank {

    private ArrayList<Client> clients = new ArrayList<>();

    void addClient(Client client) {
        clients.add(client);
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
