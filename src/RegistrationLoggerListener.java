import java.time.LocalDateTime;

public class RegistrationLoggerListener implements ClientRegistrationListener {

    @Override
    public void onClientAdded(Client c) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(c.getName() + " added on: " + localDateTime);
    }
}
