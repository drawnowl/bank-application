package ua.spalah.bank;

public class PrintClientListener implements ClientRegistrationListener {

    @Override
    public void onClientAdded(Client c) {
        System.out.println(c.toString());
    }
}