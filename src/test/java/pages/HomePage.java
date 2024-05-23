package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.junit.Assert;

public class HomePage {

    private static WebDriver driver;

    private By registerLoginBtn = By.cssSelector("a[href=\"https://staging.liveet.co/login\"]");

    @SuppressWarnings("static-access")
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // public void clickLoginRegisterButton() {

    // driver.findElement(registerLoginBtn).click();

    // }

    public void verifyHomePageItems() {
        // Set up a wait with a specified timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedUrl = "https://staging.liveet.co/home";

        // Wait until the URL contains the expected URL
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Now retrieve the current URL
        String currentUrl = driver.getCurrentUrl();

        // Assert that the expected URL is the current URL
        Assert.assertEquals("URL does not match expected value", expectedUrl, currentUrl);
    }

    public void closeBrowser() {

        driver.quit();
        System.out.println("Browser session has been closed");
    }

}
