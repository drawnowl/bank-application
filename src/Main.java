import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Bank bank = new Bank();

        Client clientNick;
        Client clientSteve;
        Client clientBen;
        Client clientSharon;
        Client clientOlga;

        CheckingAccount standartCheckingAccount = new CheckingAccount(250, 50);
        SavingAccount standartSavingAccount = new SavingAccount(50);

        bank.addClient(clientNick = new Client("Nick", Client.Gender.MALE));
        bank.addClient(clientSharon = new Client("Sharon", Client.Gender.FEMALE));
        bank.addClient(clientSteve = new Client("Steve", Client.Gender.MALE));
        bank.addClient(clientBen = new Client("Ben", Client.Gender.MALE));
        bank.addClient(clientOlga = new Client("Olga", Client.Gender.FEMALE));

        clientBen.addAccount(standartCheckingAccount);
        clientBen.addAccount(standartSavingAccount);
        clientBen.addAccount(standartCheckingAccount);

        clientNick.addAccount(standartCheckingAccount);
        clientNick.addAccount(standartSavingAccount);
        clientNick.addAccount(standartCheckingAccount);

        clientSteve.addAccount(standartCheckingAccount);
        clientSteve.addAccount(standartSavingAccount);
        clientSteve.addAccount(standartCheckingAccount);

        clientSharon.addAccount(standartCheckingAccount);
        clientSharon.addAccount(standartSavingAccount);
        clientSharon.addAccount(standartCheckingAccount);

        clientOlga.addAccount(standartCheckingAccount);
        clientOlga.addAccount(standartSavingAccount);
        clientOlga.addAccount(standartCheckingAccount);

        bank.getClientFullInfo(reader.readLine());
    }
}
