package ua.spalah.bank.services.impl;

import ua.spalah.bank.exceptions.NotEnoughFundsException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.AccountType;
import ua.spalah.bank.models.CheckingAccount;
import ua.spalah.bank.services.AccountService;

public class AccountServiceImpl implements AccountService {

    @Override
    public void deposit(Account account, double amount) {
        if(amount > 0) {
            account.setBalance(account.getBalance() + amount);
        } else {
            throw new IllegalArgumentException("Amount can't be negative.");
        }
    }

    @Override
    public void withdraw(Account account, double amount) throws NotEnoughFundsException {
        if (account.getType().equals(AccountType.CHECKING)) {
            CheckingAccount checkingAccount = (CheckingAccount) account;
            if (checkingAccount.getBalance() + checkingAccount.getOverdraft() > amount) {
                account.setBalance(account.getBalance() - amount);
            }
        } else if(account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        } else { throw new NotEnoughFundsException(account.getBalance(), amount); }
    }

    @Override
    public void transfer(Account fromAccount, Account toAccount, double amount) throws NotEnoughFundsException {
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
    }
}
