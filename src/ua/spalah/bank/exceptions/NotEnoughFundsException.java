package ua.spalah.bank.exceptions;

public class NotEnoughFundsException extends BankException {

    public NotEnoughFundsException(double balance, double amount) {
        super("Total amount your funds is: [" + balance + "]. Not enough for withdraw " + amount + " amount");
    }
}
