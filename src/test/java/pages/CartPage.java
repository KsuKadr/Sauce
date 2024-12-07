package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By title = By.cssSelector("[class=title]");
    private final By qtyElement = By.xpath("//div[@class='cart_quantity_label']");
    private final By descriptionElement = By.xpath("//div[@class='cart_desc_label']");
    private final By button = By.xpath("//button[@class='btn btn_secondary back btn_medium']");

    public boolean titleIsDisplayed() {
        driver.findElement(title).isDisplayed();
        return true;
    }

    public boolean qtyElementIsDisplayed() {
        driver.findElement(qtyElement).isDisplayed();
        return true;
    }

    public boolean descriptionElementIsDisplayed() {
        driver.findElement(descriptionElement).isDisplayed();
        return true;
    }

    public boolean buttonIsDisplayed() {
        driver.findElement(button).isDisplayed();
        return true;
    }
}
