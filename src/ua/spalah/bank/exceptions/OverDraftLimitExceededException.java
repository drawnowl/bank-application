package ua.spalah.bank.exceptions;

public class OverDraftLimitExceededException extends NotEnoughFundsException {

    public OverDraftLimitExceededException(double balance, double amount) {
        super(balance, amount);
    }
}
