package ua.spalah.bank.models;

public class CheckingAccount extends SavingAccount implements Account {

    private double overdraft;

    public CheckingAccount(double balance, double overdraft) {
        super(balance);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    @Override
    public AccountType getType() {
        return AccountType.CHECKING;
    }

    @Override
    public String toString() {
        return "Checking account with: " + getBalance() + " balance, and " + overdraft + " overdraft.";
    }
}