public class EmailNotificationListener implements ClientRegistrationListener {

    @Override
    public void onClientAdded(Client c) {
        System.out.println("Notification email for: " + c.getName() + " has been sent.");
    }
}
