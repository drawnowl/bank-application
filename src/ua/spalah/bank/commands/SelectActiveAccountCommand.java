package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.services.impl.BankReportServiceImpl;

public class SelectActiveAccountCommand implements Command {

    @Override
    public void execute() {
        BankReportServiceImpl bankReportService = new BankReportServiceImpl();

        System.out.println(bankReportService.getClientsSortedByCity(BankCommander.currentBank).toString());
        // BankCommander.currentClient.getActiveAccount(); - ? =)
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"11\" for get Select Active Account command");
    }
}
