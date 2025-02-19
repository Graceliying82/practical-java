package seleniumTestDemo.sauceDemo.tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import seleniumTestDemo.utils.Constans;
import seleniumTestDemo.utils.DriverManager;

public class SauceDemoBaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = DriverManager.getDriver();
        driver.get(Constans.SAUCE_DEMO_URL);
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void teardown() {
        DriverManager.quitDriver();
    }
}
