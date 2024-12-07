package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static sun.security.jgss.GSSUtil.login;

public class LoginTest extends BaseTest {

    @Epic("Модуль логина интернет-магазина")
    @Feature("TMS-56")
    @Story("TNS-56.67")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Kadrova Kseniya kadrova@gmail.com")
    @TmsLink("UrnSu")
    @Issue("3")
    @Description("Проверка входа в систему интернет-магазина")
    @Flaky
    @Test(description = "авторизация под верными данными")
    public void correctLogin() {
        loginPage
                .open()
                .login(user, password);
        assertTrue(productsPage.isDisplayed());
        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider(name = "param")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", password, "Epic sadface: Sorry, this user has been locked out."},
                {user, "", "Epic sadface: Password is required"},
                {"", password, "Epic sadface: Username is required"}
        };
    }

    @Test(dataProvider = "param")
    public void loginWrongData(String user, String pass, String errorMsg) {
        loginPage
                .open()
                .login(user,pass);
        assertEquals(loginPage.getErrorMessage(), errorMsg);
    }
}
