package seleniumTestDemo.sauceDemo.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumTestDemo.sauceDemo.pages.InventoryPage;
import seleniumTestDemo.sauceDemo.pages.LoginPage;
import seleniumTestDemo.utils.Constans;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.Duration;

public class InventoryPageTest extends SauceDemoBaseTest {
    private InventoryPage inventoryPage;

    @BeforeEach
    public void goToInventoryPage() {
        LoginPage loginPage = new LoginPage(driver);
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

    @Test
    public void testBurgeBar() {
        WebElement burgerMenu = inventoryPage.getBurgerMenuButton();
        assertTrue(burgerMenu.isDisplayed(), "Burger menu button should be displayed.");
        burgerMenu.click();
        WebElement menuBar = inventoryPage.getMenuBar();
        assertTrue(menuBar.isDisplayed(), "Menu bar should be displayed.");
    }

    @Test
    public void testMenuBar() {
        WebElement burgerMenu = inventoryPage.getBurgerMenuButton();
        burgerMenu.click();
        WebElement menuBar = inventoryPage.getMenuBar();
        
        // Add wait before checking menu visibility
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(menuBar));
        
        // Verify menu bar is displayed
        assertTrue(menuBar.isDisplayed(), "Menu bar should be displayed after clicking burger menu");
        
        // Add waits for menu items
        assertTrue(wait.until(ExpectedConditions.visibilityOf(inventoryPage.getAllItemsLink())).isDisplayed(), 
            "All Items link should be displayed");
        assertTrue(wait.until(ExpectedConditions.visibilityOf(inventoryPage.getAboutLink())).isDisplayed(), 
            "About link should be displayed");
        assertTrue(wait.until(ExpectedConditions.visibilityOf(inventoryPage.getLogoutLink())).isDisplayed(), 
            "Logout link should be displayed");
        assertTrue(wait.until(ExpectedConditions.visibilityOf(inventoryPage.getResetAppLink())).isDisplayed(), 
            "Reset App State link should be displayed");
        
        // Test closing the menu
        WebElement closeButton = inventoryPage.getCloseMenuButton();
        closeButton.click();
        
        // Add wait for menu to disappear
        wait.until(ExpectedConditions.invisibilityOf(menuBar));
        assertFalse(menuBar.isDisplayed(), "Menu bar should be hidden after clicking close button");
    }
}
