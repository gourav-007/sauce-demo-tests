package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {

    public WebDriver driver;

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    private String errorFirstNameNotification = "Error: First Name is required";
    private String errorLastNameNotification = "Error: Last Name is required";
    private String errorPostalCodeNotification = "Error: Postal Code is required";


    private final By firstNamxeField = By.xpath("//input[@id='first-name']");
    private final By lastNameField = By.xpath("//input[@id='last-name']");
    private final By postalCodeField = By.xpath("//input[@id='postal-code']");
    private final By continueButton = By.xpath("//*[@id='continue']");
    private final By errorNotification = By.xpath("//h3");

    @Step("Fill field \"First Name\" with data ({firstname}), fill field \"Last Name\" with data ({lastName}), fill field \"Zip/Postal Code\" with data ({postalCode})")
    public void fillFields(String firstname, String lastName, String postalCode) {
        driver.findElement(firstNamxeField).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    @Step("Click \"CONTINUE\" button on the Checkout page")
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    @Step("Method returns notification with requirement of necessary about First Name")
    public String getErrorFirstNameNotification() {
        return errorFirstNameNotification;
    }

    @Step("Method returns notification with requirement of necessary about Last Name")
    public String getErrorLastNameNotification() {
        return errorLastNameNotification;
    }

    @Step("Method returns notification with requirement of necessary about Postal Code")
    public String getErrorPostalCodeNotification() {
        return errorPostalCodeNotification;
    }

    @Step("Method returns error notification")
    public String errorNotification() {
        return driver.findElement(errorNotification).getText();
    }
}