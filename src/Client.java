import accounts.Account;

import java.util.ArrayList;

public class Client {

    private String name;
    private Gender gender;
    private ArrayList<Account> accounts = new ArrayList<>();
    private Account activeAccount;

    Client(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    String getName() {
        return name;
    }

    Gender getGender() {
        return gender;
    }

    public ArrayList<Account> getAccounts() {
        if(accounts.isEmpty()) {
            System.out.println("No accounts on this client");
        }
        return accounts;
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    void addAccount(Account account) {
        if(accounts.isEmpty()) {
            activeAccount = account;
        }
        accounts.add(account);
    }

    void setActiveAccount(Account account) {
        if(accounts.contains(account)) {
            activeAccount = account;
            return;
        }
        System.out.println("accounts.Account is not contains in client list");
    }

    double getTotalBalance() {
        double result = 0;
        for (Account account: accounts) {
            result += account.getBalance();
        }
        return result;
    }

    @Override
    public String toString() {
        return "name: " + name + ". gender: " + gender + ". Accounts:" +
                accounts.toString() + ". Total balance: " + getTotalBalance();
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
