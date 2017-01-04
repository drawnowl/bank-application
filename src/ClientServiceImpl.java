import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Override
    public Client findClientByName(Bank bank, String name) {
        List<Client> clients = bank.getAllClients();
        for (Client client: clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> findAllClients(Bank bank) {
<<<<<<< HEAD
=======

>>>>>>> origin/master
        List<Client> clients = bank.getAllClients();
        return clients;
    }

    @Override
    public Client saveClient(Bank bank, Client client) {
<<<<<<< HEAD
        bank.addClient(client);
        return client;
=======
        List<Client> clients = bank.getAllClients();
        if(clients.contains(client)) {
            return client;
        }
        return null;
>>>>>>> origin/master
    }

    @Override
    public void deleteClient(Bank bank, Client client) {
        bank.removeClient(client);
    }
}
