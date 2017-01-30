package ua.spalah.bank.models;

public class SavingAccount implements Account {

    private double balance;

    public SavingAccount(double balance) {
        if (balance <= 0) {
            return;
        }
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public AccountType getType() {
        return AccountType.SAVING;
    }

    @Override
    public String toString() {
        return "Saving account with: " + getBalance() + " balance.";
    }
}