package saucetests;

import data.UserData;
import init.Base;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTests extends Base {

    @Test
    @Description(value = "Login with correct Username and Password")
    public void CorrectLogin() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        Assert.assertTrue(homePage.getVisibleCartButton().isDisplayed());
    }
}