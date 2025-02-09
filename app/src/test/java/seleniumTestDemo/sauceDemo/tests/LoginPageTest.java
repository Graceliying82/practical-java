package seleniumTestDemo.sauceDemo.tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import seleniumTestDemo.sauceDemo.pages.InventoryPage;
import seleniumTestDemo.sauceDemo.pages.LoginPage;
import seleniumTestDemo.utils.Constans;
import seleniumTestDemo.utils.DriverManager;

public class LoginPageTest extends SauceDemoBaseTest{
    protected static WebDriver driver;

    @Test
    public void testLogin() {
        // Page object usage
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(Constans.SAUCE_DEMO_USERNAME);
        loginPage.enterPassword(Constans.SAUCE_DEMO_PASSWORD);
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        String pageTitle = inventoryPage.getPageTitle();

        // Verify the page title
        Assertions.assertEquals("Products", pageTitle);
    }
}
