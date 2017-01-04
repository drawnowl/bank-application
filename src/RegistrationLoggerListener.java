import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class RegistrationLoggerListener implements ClientRegistrationListener {

    @Override
    public void onClientAdded(Client c) {
        System.out.println(c.getName() + " added on: " + LocalDateTime.now());
    }
}
