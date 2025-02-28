package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By homePageTitle = By.xpath("//title[text()='Swag Labs']");
    private final By sauceLabsBackpack = By.xpath("//div[text()='Sauce Labs Backpack']");
    private final By sauceLabsOnesie = By.xpath("//div[text()='Sauce Labs Onesie']");
    private final By sauceLabsFleeceJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private final By ShirtRed = By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']");
    private final By addCartSauceLabsBackpackToCartButton = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack' and text()='Add to cart']");
    private final By cartButton = By.xpath("//div[@id='shopping_cart_container']/a");
    private final By cartButtonWithQuantity = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
    private final By sortContainer = By.xpath("//select[@class='product_sort_container']");
    private final By sortAtoZButton = By.xpath("//select[@class='product_sort_container']//option[@value='az']");
    private final By sortZtoAButton = By.xpath("//select[@class='product_sort_container']//option[@value='za']");
    private final By sortPriceLowToHigh = By.xpath("//select[@class='product_sort_container']//option[@value='lohi']");
    private final By sortPriceHighToLow = By.xpath("//select[@class='product_sort_container']//option[@value='hilo']");
    private final By sidebarButton = By.xpath("//div[@class='bm-burger-button']");
    private final By allItemsLink = By.xpath("//a[@id='inventory_sidebar_link']");
    private final By aboutLink = By.xpath("//a[@id='about_sidebar_link']");
    private final By logoutLink = By.xpath("//a[@id='logout_sidebar_link']");
    private final By itemsSuite = By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name']");
    private final By itemsPrice = By.xpath("//div[@class='inventory_item_price']");
    private final By addToCartButtons = By.xpath("//button[@class='btn_primary btn_inventory']");
    private final By buttonAddToCart = By.xpath("//button[text()='ADD TO CART']");

    public ArrayList<String> sortListAToZ() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(itemsSuite);

        for (int i = 0; i < elementList.size(); i++) {
            obtainedList.add(elementList.get(i).getText());
        }
        Collections.sort(obtainedList);
        return obtainedList;
    }

    public ArrayList<String> sortListZToA() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(itemsSuite);

        for (int i = 0; i < elementList.size(); i++) {
            obtainedList.add(elementList.get(i).getText());
        }
        obtainedList.sort(Comparator.reverseOrder());
        return obtainedList;
    }

    public ArrayList<String> notSortedItemList() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> itemsList = driver.findElements(itemsSuite);

        for (int i = 0; i < itemsList.size(); i++) {
            obtainedList.add(itemsList.get(i).getText());
        }
        return obtainedList;
    }

    public ArrayList<Double> sortPriceLowToHigh() {
        List<WebElement> priceItems = driver.findElements(itemsPrice);
        ArrayList<String> sortLowHigh = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();

        for (int i = 0; i < priceItems.size(); i++) {
            sortLowHigh.add(priceItems.get(i).getText().toString());
        }

        for (int i = 0; i < sortLowHigh.size(); i++) {
            price.add(Double.parseDouble(sortLowHigh.get(i).toString().replace("$", "")));
        }
        price.sort(Comparator.naturalOrder());
        return price;
    }

    public ArrayList<Double> sortPriceHighToLow() {
        List<WebElement> priceItems = driver.findElements(itemsPrice);
        ArrayList<String> sortLowHigh = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();

        for (int i = 0; i < priceItems.size(); i++) {
            sortLowHigh.add(priceItems.get(i).getText().toString());
        }

        for (int i = 0; i < sortLowHigh.size(); i++) {
            price.add(Double.parseDouble(sortLowHigh.get(i).toString().replace("$", "")));
        }
        price.sort(Comparator.reverseOrder());
        return price;
    }

    public ArrayList<Double> getPriceItemsFromPage() {
        List<WebElement> priceItems = driver.findElements(itemsPrice);
        ArrayList<Double> price = new ArrayList<>();
        for (int i = 0; i < priceItems.size(); i++) {
            price.add(Double.parseDouble(priceItems.get(i).getText().replace("$", "")));
        }
        return price;
    }

    public void addSeveralItemsToCart() {
        List<WebElement> buttonAddToCart = new ArrayList<>();
        buttonAddToCart = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
        for (int i = 0; i < 3; i++) {
            buttonAddToCart.get(i).click();
        }
    }

    public int getitemsSuiteInt() {
        List<WebElement> itemsSuiteList = driver.findElements(itemsSuite);
        return itemsSuiteList.size();
    }

    public List<String> getItemsSuiteString() {
        List<WebElement> obtainedList = driver.findElements(itemsSuite);
        List<String> itemsList = new ArrayList<>();

        for (int i = 0; i < obtainedList.size(); i++) {
            itemsList.add(obtainedList.get(i).getText());
        }
        return itemsList;
    }

    public WebElement getVisibleCartButton() {
        WebElement visibleCartButton = driver.findElement(cartButton);
        return visibleCartButton;
    }

    @Step("Click on the name of the Sauce Labs Backpack product item")
    public void clickSauceLabsBackpack() {
        driver.findElement(sauceLabsBackpack).click();
    }

    @Step("Click \"ADD TO CART\" button on the Sauce Labs Backpack product item on the Home page")
    public void clickAddCartSauceLabsBackpackButton() {
        driver.findElement(addCartSauceLabsBackpackToCartButton).click();
    }

    @Step("Click \"Cart\" icon on the Home page")
    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    @Step("Add all product items to cart by clicking \"ADD TO CART\" button near each product on the Home page")
    public void addAllItemsOfProductsToCart() {
        List<WebElement> allProductsAddToCartButtons = driver.findElements(addToCartButtons);
        for (int i = 0; i < allProductsAddToCartButtons.size(); i++) {
            allProductsAddToCartButtons.get(i).click();
        }
    }

    @Step("Click \"sidebar\" icon on the Home page")
    public void clickSideBarButton() {
        driver.findElement(sidebarButton).click();
    }

    @Step("Click \"All items\" button inside Sidebar")
    public void clickAllItemsButton() {
        driver.findElement(allItemsLink).click();
    }

    @Step("Click \"About\" button inside Sidebar")
    public void clickAboutButton() {
        driver.findElement(aboutLink).click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl().toString();
    }

    @Step("Click \"Logout\" button on the Home Page")
    public void clickLogoutButton() {
        driver.findElement(logoutLink).click();
    }


}