package pages;

import init.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends Base {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By fieldUsername = By.xpath("//input[@id='user-name']");
    private final By fieldPassword = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@class='submit-button btn_action']");

    @Step("Fill \"Username\" field with data ({login}), fill \"Password\" field with data ({password}) and click \"LOGIN\" button")
    public void login(String login, String password) {
        driver.findElement(fieldUsername).sendKeys(login);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
