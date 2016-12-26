public class CheckingAccount extends Account {

    private double balance;
    private double overdraft;

    public CheckingAccount(double balance, double overdraft) {

        if(balance >= 0) {
            this.balance = balance;
            this.overdraft = overdraft;
        } else {
            System.out.println("Wrong input");
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
        if(Math.abs(balance - sum) < Math.abs(overdraft)) {
            balance -= sum;
        } else {
            System.out.println("Not enough money");
        }
    }
}
