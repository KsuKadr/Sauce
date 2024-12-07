package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_TO_CART_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By title = By.cssSelector("[class=title]");
    private final By title2 = By.xpath("//*[text()='Products']");
    private final By addToCartBtn = By.xpath("//*[text()='Add to cart']");
    private final By removeBtn = By.xpath("//*[text()='Remove']");
    private final By cartIcon = By.xpath("//*[@class='shopping_cart_link']");
    private final By goodsInCart = By.cssSelector(".inventory_item_name");
    private final By cartCount = By.xpath("//span[@class='shopping_cart_badge']");

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCart).click();
    }

    public void addToCart(int index) {
        driver.findElements(addToCartBtn).get(index).click();
    }

    public boolean removeBtn(int index) {
        return driver.findElements(removeBtn).get(index).isDisplayed();
    }

    public boolean isDisplayed() {
        driver.findElement(title2).isDisplayed();
        return true;
    }

    public String getCountInCart() {
        return driver.findElement(cartCount).getText();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductsNames = driver.findElements(goodsInCart);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }

    public int getCountProducts() {
        List<WebElement> allProductsNames = driver.findElements(removeBtn);
        return allProductsNames.size();
    }

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
    }
}
