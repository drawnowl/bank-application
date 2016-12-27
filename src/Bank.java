import java.util.ArrayList;

class Bank {

    private ArrayList<Client> clients = new ArrayList<>();

    void addClient(Client client) {
        clients.add(client);
    }

    ArrayList<Client> getAllClients() {
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
