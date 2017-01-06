package ua.spalah.bank.models;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private Gender gender;
    private List<Account> accounts = new ArrayList<>();
    private Account activeAccount;

    public Client(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    Gender getGender() {
        return gender;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    @Override
    public String toString() {
        return "name: " + name + ". gender: " + gender + ". Accounts:" +
                accounts.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        return gender == client.gender;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
