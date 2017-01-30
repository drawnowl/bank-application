package ua.spalah.bank.support;

public class RegExChecks {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_PATTERN = "\\d{10}";

    public static boolean phoneCheck(String phoneNumber) {
        return phoneNumber.matches(PHONE_PATTERN);
    }

    public static boolean emailCheck(String email) {
        return email.matches(EMAIL_PATTERN);
    }
}