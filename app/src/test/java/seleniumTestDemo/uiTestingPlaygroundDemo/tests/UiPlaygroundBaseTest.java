package seleniumTestDemo.uiTestingPlaygroundDemo.tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import seleniumTestDemo.utils.Constans;
import seleniumTestDemo.utils.DriverManager;

public class UiPlaygroundBaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver.get(Constans.UI_TESTING_PLAYGROUND_URL);
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void teardown() {
        DriverManager.quitDriver();
    }
}
