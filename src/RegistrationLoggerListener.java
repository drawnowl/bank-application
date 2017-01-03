import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationLoggerListener implements ClientRegistrationListener {

    private String pattern = "yyyy-MM-dd : hh-mm-ss";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private String date = simpleDateFormat.format(new Date());

    @Override
    public void onClientAdded(Client c) {
        System.out.println(c.getName() + " added on: " + date);
    }
}
