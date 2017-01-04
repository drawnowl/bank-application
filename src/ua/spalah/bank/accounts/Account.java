package ua.spalah.bank.accounts;

public abstract class Account {

    private double balance;

    public Account(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Negative balance");
        }
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double money) {
        this.balance = money;
    }

    public void deposit(double money) {
        if(money >= 0) {
            balance += money;
        } else {
            System.out.println("Wrong input");
        }
    }

    public void withdraw(double money) {
        if(money <= balance) {
            balance -= money;
        } else {
            System.out.println("Not enough money");
        }
    }

    @Override
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() + ", balance: " + this.getBalance();
    }
}
