package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.services.impl.BankReportServiceImpl;

public class GetClientsByCity implements Command {

    private BankReportServiceImpl bankReportService;

    public GetClientsByCity(BankReportServiceImpl bankReportService) {
        this.bankReportService = bankReportService;
    }

    @Override
    public void execute() {
        System.out.println(bankReportService.getClientsByCity(BankCommander.currentBank).values().toString());
    }

    @Override
    public void printCommandInfo() {
        System.out.println("GetClientsByCity - press 12 ");
    }
}
