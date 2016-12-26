public class SavingAccount extends Account {

    private double balance;

    public SavingAccount(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Negative balance");
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public void addMoney(double sum) {
        if(sum >= 1) {
            balance += sum;
        } else {
            System.out.println("Wrong input");
        }
    }

    @Override
    public void takeMoney(double sum) {
        if(sum <= balance) {
            balance -= sum;
        } else {
            System.out.println("Not enough money");
        }
    }
}
