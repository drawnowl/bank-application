package accounts;

public class AccountServiceImpl implements AccountService {

    @Override
    public void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    @Override
    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }

    @Override
    public void transfer(Account fromAccount, Account toAccount, double amount) {
        if(amount >= 0 & fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } else {
            System.out.println("Not enough money");
        }
    }
}
