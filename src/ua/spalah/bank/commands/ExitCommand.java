package ua.spalah.bank.commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"3\" for get Exit command");
    }
}
