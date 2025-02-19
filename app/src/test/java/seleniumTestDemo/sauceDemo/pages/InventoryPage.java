package seleniumTestDemo.sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    private WebDriver driver;
    private By title = By.className("title");
    private By burgerButton = By.id("react-burger-menu-btn");
    private By menuBar = By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[1]");
    private By all_items = By.id("inventory_sidebar_link");
    private By about = By.id("about_sidebar_link");
    private By logout = By.id("logout_sidebar_link");
    private By reset = By.id("reset_sidebar_link");
    private By close_burger_menu = By.id("react-burger-cross-btn");

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

    public WebElement getAllItemsLink() {
        return driver.findElement(all_items);
    }

    public WebElement getAboutLink() {
        return driver.findElement(about);
    }

    public WebElement getLogoutLink() {
        return driver.findElement(logout);
    }

    public WebElement getResetAppLink() {
        return driver.findElement(reset);
    }

    public WebElement getCloseMenuButton() {
        return driver.findElement(close_burger_menu);
    }

}
