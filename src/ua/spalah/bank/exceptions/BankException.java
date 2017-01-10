package ua.spalah.bank.exceptions;

public class BankException extends Exception {

    private String message;

    public BankException(String message) {
        this.message = message;
    }
}
