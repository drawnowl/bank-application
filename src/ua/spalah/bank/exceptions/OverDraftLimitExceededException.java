package ua.spalah.bank.exceptions;

public class OverDraftLimitExceededException extends NotEnoughFundsException {

    public OverDraftLimitExceededException(double balance, double amount, double overdraft) {
        super(balance, amount, overdraft);
    }
}
