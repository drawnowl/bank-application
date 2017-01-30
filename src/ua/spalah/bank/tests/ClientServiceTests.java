package ua.spalah.bank.tests;

import org.junit.Before;
import org.junit.Test;
import ua.spalah.bank.exceptions.ClientNotFoundException;
import ua.spalah.bank.models.*;
import ua.spalah.bank.services.impl.ClientServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClientServiceTests {

    private Bank bank;
    private ClientServiceImpl clientService = new ClientServiceImpl();

    private Client richard = new Client("Richard", Gender.MALE, "richard@gmail.com", "Schalke", "0928762312");
    private Client bastian = new Client("Bastian", Gender.MALE, "bastian@gmail.com", "Bayern", "0748772312");
    private Client matt = new Client("Matt", Gender.MALE, "matt@hotmail.com", "Dortmund", "0346762312");
    private Client carl = new Client("Carl", Gender.MALE, "carl@gmail.com", "Leipzig", "0828762332");
    private Client anna = new Client("Anna", Gender.FEMALE, "anna@gmail.com", "Dortmund", "0348762912");

    @Before
    public void refresh() {
        bank = new Bank();

        clientService.saveClient(bank, richard);
        clientService.saveClient(bank, bastian);
        clientService.saveClient(bank, matt);
    }

    @Test(expected = ClientNotFoundException.class)
    public void findClientByName_false() throws ClientNotFoundException {
        assertEquals(null, clientService.findClientByName(bank, "Vasja"));
    }

    @Test
    public void findClientByName_true() throws ClientNotFoundException {
        assertEquals("Richard", clientService.findClientByName(bank, "Richard").getName());
    }

    @Test(expected = ClientNotFoundException.class)
    public void findClientByName_complex_false() throws ClientNotFoundException {
        clientService.saveClient(bank, anna);
        clientService.deleteClient(bank, anna);

        assertEquals(null, clientService.findClientByName(bank, "Anna").getName());
    }

    @Test
    public void findClientByName_complex_true_1() throws ClientNotFoundException {
        clientService.saveClient(bank, anna);

        assertEquals("Anna", clientService.findClientByName(bank, "Anna").getName());
    }

    @Test
    public void findAllClients_overall() {
        List<Client> clients = new ArrayList<>();
        clients.addAll(bank.getClients());

        assertEquals(clients, bank.getClients());
    }

    @Test
    public void findAllClients_complex() throws ClientNotFoundException {
        List<Client> clients = new ArrayList<>();

        clientService.saveClient(bank, anna);
        clients.add(richard);
        clients.add(bastian);
        clients.add(matt);
        clients.add(anna);

        assertEquals(clients, bank.getClients());
    }

    @Test(expected = AssertionError.class)
    public void saveClient_false() {
        assertEquals(richard, clientService.saveClient(bank, anna));
    }

    @Test
    public void saveClient_true_1() {
        assertEquals(anna, clientService.saveClient(bank, anna));
    }

    @Test
    public void saveClient_true_2() {
        assertEquals(richard, clientService.saveClient(bank, richard));
    }

    @Test(expected = ClientNotFoundException.class)
    public void deleteClient() throws ClientNotFoundException {

        Bank testBank = bank;
        clientService.deleteClient(bank, richard);

        assertEquals(testBank.getClients(), bank.getClients());
    }

    @Test
    public void getTotalBalance() {
        clientService.addAccount(new SavingAccount(100.5), richard);
        clientService.addAccount(new CheckingAccount(210, 1), richard);

        assertEquals(310.5, clientService.getTotalBalance(richard), 0);
    }

    @Test
    public void addAccount() {
        clientService.addAccount(new SavingAccount(100), richard);
        clientService.addAccount(new SavingAccount(100), richard);

        assertEquals(2, richard.getAccounts().size());
    }

    @Test
    public void addAccount_empty() {
        assertEquals(0, richard.getAccounts().size());
    }

    @Test
    public void setActiveAccount() {
        CheckingAccount testCheckingAccount = new CheckingAccount(10, 3);
        clientService.addAccount(testCheckingAccount, richard);
        clientService.setActiveAccount(testCheckingAccount, richard);

        assertEquals(10, richard.getActiveAccount().getBalance(), 0);
    }

    @Test(expected = NullPointerException.class)
    public void setActiveAccount_null() {
        CheckingAccount testCheckingAccount = new CheckingAccount(10, 3);

        clientService.setActiveAccount(testCheckingAccount, richard);

        assertEquals(null, richard.getActiveAccount().getBalance());
    }
}