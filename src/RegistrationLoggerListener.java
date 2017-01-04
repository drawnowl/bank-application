import java.time.LocalDateTime;

public class RegistrationLoggerListener implements ClientRegistrationListener {

    @Override
    public void onClientAdded(Client c) {
        System.out.println(c.getName() + " added on: " + LocalDateTime.now());
    }
}
