package seleniumTestDemo.utils;

public class Constans {
    // Base URL for both websites
    public static final String SAUCE_DEMO_URL = "https://www.saucedemo.com/";
    public static final String UI_TESTING_PLAYGROUND_URL = "https://www.uitestingplayground.com/";

    // Login credentials for both sites (if they share the same credentials)
    public static final String SAUCE_DEMO_USERNAME = "standard_user";  // Replace with the actual username
    public static final String SAUCE_DEMO_PASSWORD = "secret_sauce";   // Replace with the actual password

    // Timeout values
    public static final int IMPLICIT_WAIT_TIMEOUT = 10;
    public static final int EXPLICIT_WAIT_TIMEOUT = 20;
}
