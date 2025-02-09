package seleniumTestDemo.sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class InventoryPage {
    private WebDriver driver;
    private By title = By.className("title");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        WebElement titleElement = driver.findElement(title);
        return titleElement.getText();
    }
}
