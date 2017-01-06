package ua.spalah.bank.models;

public class CheckingAccount extends SavingAccount implements Account {

    private double balance;
    private double overdraft;

    public CheckingAccount(double balance, double overdraft) {
        super(balance);
        this.balance = balance;
        this.overdraft = overdraft;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
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
