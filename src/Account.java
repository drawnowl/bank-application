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

    protected void setBalance(double sum) {
        this.balance = sum;
    }

    public void addMoney(double sum) {
        if(sum >= 0) {
            balance += sum;
        } else {
            System.out.println("Wrong input");
        }
    }

    public void takeMoney(double sum) {
        if(sum <= balance) {
            balance -= sum;
        } else {
            System.out.println("Not enough money");
        }
    }

    @Override
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() + ", balance: " + this.getBalance();
    }
}
