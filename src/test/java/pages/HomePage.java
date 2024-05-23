package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;

public class HomePage {

    private static WebDriver driver;

    private By logoutBtn = By.xpath("//a[contains(text(), 'Log Out')]");
    private By createEventBtn = By.xpath("//a[contains(text(), 'Create Event')]");

    @SuppressWarnings("static-access")
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyHomePageUrl() {
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

    public void checkElementsVisibility(WebDriver driver, List<By> locators) {
        for (By locator : locators) {
            try {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    System.out.println("Element located by " + locator + " is displayed.");
                } else {
                    System.out.println("Element located by " + locator + " is not displayed.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Element located by " + locator + " is not present in the DOM.");
            }
        }
    }

    public void verifyOtherHomePageElements() {
        // List of locators to check
        List<By> locators = List.of(
                logoutBtn,
                createEventBtn
        );
        checkElementsVisibility(driver, locators);

    }

    public void closeBrowser() {

        driver.quit();
        System.out.println("Browser session has been closed");
    }

}
