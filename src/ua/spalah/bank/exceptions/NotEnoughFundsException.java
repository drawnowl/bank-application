package ua.spalah.bank.exceptions;

public class NotEnoughFundsException extends BankException {

    public NotEnoughFundsException(double balance, double amount) {
        super("Total amount your funds is: [" + balance + "]. Not enough for withdraw " + amount + " amount");
    }

    public NotEnoughFundsException(double balance, double amount, double overdraft) {
        super("Total amount your funds is: [" + balance + "]. Not enough for withdraw " + amount + " amount "
                + overdraft + "overdraft");
    }
}
