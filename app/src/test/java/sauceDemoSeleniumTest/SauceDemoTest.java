package sauceDemoSeleniumTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SauceDemoTest {

    private WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    public void navigateToSite() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLogin() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Login with standard user credentials
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Verify we are on the inventory page
        WebElement inventoryTitle = driver.findElement(By.className("title"));
        Assertions.assertEquals("Products", inventoryTitle.getText());
    }

    @AfterAll
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
