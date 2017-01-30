package ua.spalah.bank.tests;

import org.junit.Before;
import org.junit.Test;
import ua.spalah.bank.exceptions.NotEnoughFundsException;
import ua.spalah.bank.exceptions.OverDraftLimitExceededException;
import ua.spalah.bank.models.*;
import ua.spalah.bank.services.impl.AccountServiceImpl;

import static org.junit.Assert.assertEquals;

public class AccountServiceTests {

    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;
    private AccountServiceImpl accountService = new AccountServiceImpl();

    @Before
    public void refresh() {
        checkingAccount = new CheckingAccount(100, 10);
        savingAccount = new SavingAccount(100);
    }

    @Test
    public void deposit_checking() {
        accountService.deposit(checkingAccount, 20);

        assertEquals(120, checkingAccount.getBalance(), 0);
    }

    @Test
    public void deposit_saving() {
        accountService.deposit(savingAccount, 20);

        assertEquals(120, savingAccount.getBalance(), 0);
    }

    @Test
    public void withdraw_checking() throws NotEnoughFundsException {
        accountService.withdraw(checkingAccount, 20);

        assertEquals(80, checkingAccount.getBalance(), 0);
    }

    @Test
    public void withdraw_saving() throws NotEnoughFundsException {
        accountService.withdraw(savingAccount, 20);

        assertEquals(80, savingAccount.getBalance(), 0);
    }

    @Test (expected = OverDraftLimitExceededException.class)
    public void withdraw_checking_exception() throws NotEnoughFundsException {
        accountService.withdraw(checkingAccount, 120);
    }

    @Test (expected = NotEnoughFundsException.class)
    public void withdraw_saving_exception() throws NotEnoughFundsException {
        accountService.withdraw(savingAccount, 120);
    }

    @Test
    public void transfer() throws NotEnoughFundsException {
        accountService.transfer(savingAccount, checkingAccount, 30);

        assertEquals(70, savingAccount.getBalance(), 0);
        assertEquals(130, checkingAccount.getBalance(), 0);
    }

    @Test (expected = NotEnoughFundsException.class)
    public void transfer_exception() throws NotEnoughFundsException {
        accountService.transfer(savingAccount, checkingAccount, 120);
    }

    @Test (expected = OverDraftLimitExceededException.class)
    public void transfer_exception_2() throws NotEnoughFundsException {
        accountService.transfer(checkingAccount, savingAccount, 120);
    }
}