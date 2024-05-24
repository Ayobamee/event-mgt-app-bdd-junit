package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import utils.filereader.readProperties;

public class LoginPage {

    private static WebDriver driver;

    private By registerLoginBtn = By.cssSelector("a[href=\"https://staging.liveet.co/login\"]");
    private By phoneNumberInputField = By.cssSelector("input[type=\"tel\"]");
    private By firstContinueBtn = By
            .cssSelector("button[class=\"button button-theme-01 text-sm font-medium py-2 w-full\"]");
    private By passwordField = By.cssSelector("input[type=\"password\"]");
    private By secondContinueBtn = By.xpath("//button[contains(text(), 'Continue')]");

    @SuppressWarnings("static-access")
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginRegisterButton() {

        driver.findElement(registerLoginBtn).click();

    }

    public void enterPhoneNumber(String phoneNo) {
        driver.findElement(phoneNumberInputField).sendKeys(phoneNo);
    }

    public void clickFirstContinueButton() {

        driver.findElement(firstContinueBtn).click();

    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSecondContinueButton() {
        driver.findElement(secondContinueBtn).click();
    }

    public void performLoginAction(WebDriver driver) throws IOException {
        readProperties readTestData = new readProperties();
        clickLoginRegisterButton();
        enterPhoneNumber((String) readTestData.getUsername());
        clickFirstContinueButton();
        enterPassword((String) readTestData.getPassword());
        clickSecondContinueButton();
        System.out.println("Login is successful");
    }

}
