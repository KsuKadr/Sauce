package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test
    public void addGoods() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isOpened();
        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.addToCart(2);
        productsPage.openCart();
        assertTrue(productsPage.getProductsNames().contains("Sauce Labs Backpack"));
    }

    @Test(description = "Проверка колличества товаров в корзине и на иконке корзины")
    public void countInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isOpened();
        productsPage.addToCart(0);
        Assert.assertTrue(productsPage.removeBtn(0));
        productsPage.addToCart(1);
        Assert.assertTrue(productsPage.removeBtn(1));
        productsPage.addToCart(2);
        Assert.assertTrue(productsPage.removeBtn(2));
        Assert.assertEquals(productsPage.getCountInCart(),"3","количество товаров на иконке корзины");
        productsPage.openCart();
        Assert.assertEquals(productsPage.getCountProducts(), 4, "количество товаров в корзине");// специально падает
    }

}
