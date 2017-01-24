package ua.spalah.bank.models;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private Gender gender;
    private List<Account> accounts = new ArrayList<>();
    private Account activeAccount;
    private String email;
    private String phoneNumber;
    private String city;

    public Client(String name, Gender gender, String city) {
        this.name = name;
        this.gender = gender;
        this.city = city;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", accounts=" + accounts +
                ", activeAccount=" + activeAccount +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (gender != client.gender) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(client.phoneNumber) : client.phoneNumber != null) return false;
        return city != null ? city.equals(client.city) : client.city == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
