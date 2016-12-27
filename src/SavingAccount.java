public class SavingAccount extends Account {

    public SavingAccount(double balance) {
        super(balance);
    }

    @Override
    public String toString() {
        return "Saving account with: " + getBalance() + " balance.";
    }
}
