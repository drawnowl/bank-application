package ua.spalah.bank.models;

public interface Account {

    double getBalance();
    void setBalance(double balance);
    AccountType getType();
}