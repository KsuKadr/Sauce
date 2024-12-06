package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest{

    @Test
    public void smokeCart(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isOpened();
        productsPage.openCart();
        Assert.assertTrue(cartPage.buttonIsDisplayed(),"кнопка видна");
        Assert.assertTrue(cartPage.qtyElementIsDisplayed(),"элемент кту");
        Assert.assertTrue(cartPage.descriptionElementIsDisplayed(),"описание видно");
        Assert.assertTrue(cartPage.titleIsDisplayed(),"заголовок виден");

    }
}
