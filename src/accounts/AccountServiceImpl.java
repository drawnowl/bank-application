package accounts;

public class AccountServiceImpl implements AccountService {

    @Override
    public void deposit(Account account, double amount) {
        if(amount >= 0) {
            account.setBalance(account.getBalance() + amount);
        } else {
            System.out.println("Wrong input");
        }
    }

    @Override
    public void withdraw(Account account, double amount) {
        if(amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
        } else {
            System.out.println("Not enough money");
        }
    }

    @Override
    public void transfer(Account fromAccount, Account toAccount, double amount) {
        if(amount > 0 & fromAccount.getBalance() - amount >= 0) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
        } else {
            System.out.println("Not enough money");
        }
    }
}
