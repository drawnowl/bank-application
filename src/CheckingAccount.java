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
    public void takeMoney(double sum) {
        if(getBalance() + overdraft > sum) {
             setBalance(getBalance() - sum);
        } else {
            System.out.println("Not enough money");
        }
    }

    @Override
    public String toString() {
        return "Checking account with: " + getBalance() + " balance, and " + overdraft + " overdraft.";
    }
}
