package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Overview {

    public WebDriver driver;

    public Overview(WebDriver driver) {
        this.driver = driver;
    }

    private final By finishButton = By.xpath("//button[@id='finish' and text()='Finish']");
    private final By cancelButton = By.xpath("//button[@id='cancel']");

    @Step("Click \"FINISH\" button on the Overview page")
    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }
}