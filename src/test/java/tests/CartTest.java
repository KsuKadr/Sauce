package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void smokeCart() {
        loginPage
                .open()
                .login(user, password);
        productsPage.isOpened();
        productsPage.openCart();
        Assert.assertTrue(cartPage.buttonIsDisplayed(), "не видна кнопка");
        Assert.assertTrue(cartPage.qtyElementIsDisplayed(), "не виден элемент qty");
        Assert.assertTrue(cartPage.descriptionElementIsDisplayed(), "не видно описание");
        Assert.assertTrue(cartPage.titleIsDisplayed(), "заголовок не виден");
    }
}
