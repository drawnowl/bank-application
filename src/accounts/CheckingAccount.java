package accounts;

public class CheckingAccount extends Account {

    private double overdraft;

    public CheckingAccount(double balance, double overdraft) {
        super(balance);

        if(overdraft >= 0) {
            this.overdraft = overdraft;
        } else {
            System.out.println("Wrong input");
        }
    }

    @Override
    public void withdraw(double money) {
        if(getBalance() + overdraft > money) {
             setBalance(getBalance() - money);
        } else {
            System.out.println("Not enough money");
        }
    }

    @Override
    public String toString() {
        return "Checking account with: " + getBalance() + " balance, and " + overdraft + " overdraft.";
    }
}
