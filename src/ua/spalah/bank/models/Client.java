package ua.spalah.bank.models;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private String email;
    private String city;
    private String phoneNumber;
    private Gender gender;
    private Account activeAccount;
    private List<Account> accounts = new ArrayList<>();

    public Client(String name, Gender gender, String email, String city, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public Account getActiveAccount() {
        return activeAccount;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (city != null ? !city.equals(client.city) : client.city != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(client.phoneNumber) : client.phoneNumber != null) return false;
        return gender == client.gender;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", accounts=" + accounts +
                ", activeAccount=" + activeAccount +
                '}';
    }
}
