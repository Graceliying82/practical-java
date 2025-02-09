package seleniumTestDemo.sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class InventoryPage {
    private WebDriver driver;
    private By title = By.className("title");
    private By burgerButton = By.id("react-burger-menu-btn");
    private By menuBar = By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[1]");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        WebElement titleElement = driver.findElement(title);
        return titleElement.getText();
    }

    public WebElement getBurgerMenuButton() {
        return driver.findElement(burgerButton);
    }

    public WebElement getMenuBar () {
        return driver.findElement(menuBar);
    }

}
