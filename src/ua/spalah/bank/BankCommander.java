package ua.spalah.bank;

import ua.spalah.bank.commands.*;
import ua.spalah.bank.models.*;
import ua.spalah.bank.services.impl.AccountServiceImpl;
import ua.spalah.bank.services.impl.BankReportServiceImpl;
import ua.spalah.bank.services.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankCommander {

    public static Bank currentBank;
    public static Client currentClient;
    private Command[] commands;

    public BankCommander() {
        init();
    }

    private void init() {
        try {
            currentBank = new Bank();
            commands = new Command[11];

            SavingAccount savingAccount = new SavingAccount(500);
            CheckingAccount checkingAccount = new CheckingAccount(250, 50);

            ClientServiceImpl clientService = new ClientServiceImpl();
            AccountServiceImpl accountService = new AccountServiceImpl();
            BankReportServiceImpl bankReportService = new BankReportServiceImpl();

            AddClientCommand addClientCommand = new AddClientCommand(clientService);
            AddAccountCommand addAccountCommand = new AddAccountCommand(clientService);
            DepositCommand depositCommand = new DepositCommand(accountService);
            ExitCommand exitCommand = new ExitCommand();
            FindClientCommand findClientCommand = new FindClientCommand(clientService);
            GetAccountsCommand getAccountsCommand = new GetAccountsCommand();
            GetBankInfoCommand getBankInfoCommand = new GetBankInfoCommand(bankReportService);
            RemoveClientCommand removeClientCommand = new RemoveClientCommand(clientService);
            SelectActiveAccountCommand selectActiveAccountCommand = new SelectActiveAccountCommand();
            TransferCommand transferCommand = new TransferCommand(accountService);
            WithdrawCommand withdrawCommand = new WithdrawCommand(accountService);

            commands[0] = addClientCommand;
            commands[1] = depositCommand;
            commands[2] = exitCommand;
            commands[3] = findClientCommand;
            commands[4] = getAccountsCommand;
            commands[5] = getBankInfoCommand;
            commands[6] = removeClientCommand;
            commands[7] = transferCommand;
            commands[8] = withdrawCommand;
            commands[9] = addAccountCommand;
            commands[10] = selectActiveAccountCommand;

        } catch (Exception e) {
            RuntimeException runtimeException = new RuntimeException("Init Error");
            runtimeException.initCause(e);
            throw runtimeException;
        }
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        init();
        while (true) {
            for (Command command : commands) {
                command.printCommandInfo();
            }

            try {
                int choice = Integer.parseInt(reader.readLine());
                commands[choice - 1].execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BankCommander bankCommander = new BankCommander();
        bankCommander.run();
    }
}