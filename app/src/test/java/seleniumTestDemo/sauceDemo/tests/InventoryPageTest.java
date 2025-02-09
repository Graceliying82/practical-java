package seleniumTestDemo.sauceDemo.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seleniumTestDemo.sauceDemo.pages.InventoryPage;
import seleniumTestDemo.sauceDemo.pages.LoginPage;
import seleniumTestDemo.utils.Constans;
import seleniumTestDemo.utils.DriverManager;

public class InventoryPageTest extends SauceDemoBaseTest{
    private static LoginPage loginPage;
    private static InventoryPage inventoryPage;

    @BeforeAll
    public static void setup() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(Constans.SAUCE_DEMO_USERNAME);
        loginPage.enterPassword(Constans.SAUCE_DEMO_PASSWORD);
        loginPage.clickLogin();
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void testInventoryPage() {
        // Now you can test inventory page with the user logged in
        String pageTitle = inventoryPage.getPageTitle();
        // Verify the page title
        Assertions.assertEquals("Products", pageTitle);
    }
}
