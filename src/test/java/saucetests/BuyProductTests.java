package saucetests;

import data.UserData;
import init.Base;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import pages.*;

public class BuyProductTests extends Base {

    @Test
    @Description(value = "E2E test, that checks possibility to login with correct data and make successful purchase.")
    public void buyProduct() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Cart cart = new Cart(driver);
        Checkout checkout = new Checkout(driver);
        Overview overview = new Overview(driver);
        Finish finish = new Finish(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickAddCartSauceLabsBackpackButton();
        homePage.clickCartButton();
        cart.clickCheckoutButton();
        checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
        checkout.clickContinueButton();
        overview.clickFinishButton();
        Assert.assertEquals("Thank you for your order!", finish.getGratitudeNotification());
    }

    @Test
    @Description(value = "Test checks possibility to make purchase from product's page.")
    public void buyProductFromItsPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Backpack sauceLabsBackpack = new Backpack(driver);
        Cart cart = new Cart(driver);
        Checkout checkout = new Checkout(driver);
        Overview overview = new Overview(driver);
        Finish finish = new Finish(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickSauceLabsBackpack();
        sauceLabsBackpack.clickAddToCartButton();
        sauceLabsBackpack.clickCartButton();
        cart.clickCheckoutButton();
        checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
        checkout.clickContinueButton();
        overview.clickFinishButton();
        Assert.assertEquals("Thank you for your order!", finish.getGratitudeNotification());
    }

    @Test
    @Description(value = "Test confirms possibility to cancel purchase before customer fills its personal data")
    public void cancelPurchase() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Cart cart = new Cart(driver);
        Checkout checkout = new Checkout(driver);
        Overview overview = new Overview(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickAddCartSauceLabsBackpackButton();
        homePage.clickCartButton();
        cart.clickCheckoutButton();
        checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
        checkout.clickContinueButton();
        overview.clickCancelButton();
        Assert.assertEquals(0, homePage.getitemsSuiteInt());
    }
}