public abstract class Account {

    private double balance;
    public abstract double checkBalance();
    public abstract void addMoney(double sum);
    public abstract void takeMoney(double sum);

    @Override
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() + ", balance: " + this.checkBalance();
    }
}
