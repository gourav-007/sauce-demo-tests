package saucetests;

import data.UserData;
import init.Base;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import pages.Cart;
import pages.HomePage;
import pages.LoginPage;

public class CartTests extends Base {

    @Test
    @Description(value = "Test confirms possibility to add one product item to cart and then delete product item from cart.")
    public void addItemToCartAndDeleteIt() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Cart cart = new Cart(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickAddCartSauceLabsBackpackButton();
        homePage.clickCartButton();
        cart.removeOneItemFromCart();
        Assert.assertEquals(0, cart.listOfItems());
    }

    @Test
    @Description(value = "Test confirms possibility to add all product items to cart and then delete all product items from cart.")
    public void addAllItemsToCartAndDeleteIt() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Cart cart = new Cart(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.addAllItemsOfProductsToCart();
        homePage.clickCartButton();
        cart.removeAllItemsFromCart();
        Assert.assertEquals(0, cart.listOfItems());
    }

    @Test
    @Description(value = "Test confirms possibility to add product item to cart and then click CONTINUE SHOPPING button.")
    public void addItemToCartAndContinueShopping() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Cart cart = new Cart(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickAddCartSauceLabsBackpackButton();
        homePage.clickCartButton();
        cart.clickContinueShoppingButton();
        Assert.assertEquals(0, homePage.getitemsSuiteInt());
    }
}