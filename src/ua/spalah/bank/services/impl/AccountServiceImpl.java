package ua.spalah.bank.services.impl;

import ua.spalah.bank.exceptions.NotEnoughFundsException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.AccountType;
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
        if(amount <= account.getBalance()) {
//            if(account.getType() == AccountType.CHECKING) {
//                if(account.getBalance() + account.get > amount) {
//                    account.setBalance(account.getBalance() - amount);
//            }  else {
            account.setBalance(account.getBalance() - amount);
//            }
        } else {
            throw new NotEnoughFundsException(account.getBalance(), amount);
        }
    }

    @Override
    public void transfer(Account fromAccount, Account toAccount, double amount) throws NotEnoughFundsException {
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
    }
}
