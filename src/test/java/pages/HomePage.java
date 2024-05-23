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

    private By logoImage = By.xpath(" //div[@class='logo mr-3']");
    private By homeLink = By.xpath("//a[contains(@class, 'active') and contains(@href, 'home')]");
    private By eventLink = By.cssSelector("a[href=\"https://staging.liveet.co/my-events\"]");
    private By favouriteLink = By.cssSelector("a[href=\"https://staging.liveet.co/favourite\"]");
    private By invitationLink = By.cssSelector("a[href=\"https://staging.liveet.co/invitation\"]");
    private By profileImg = By.cssSelector("a[href=\"https://staging.liveet.co/profile\"]");
    private By createEventBtn = By.xpath("//a[contains(text(), 'Create Event')]");
    private By logoutBtn = By.xpath("//a[contains(text(), 'Log Out')]");
    private By allEventsList = By.cssSelector("a[href=\"#all-events\"]");
    private By privateEventsList = By.cssSelector("a[href=\"#private-events\"]");
    private By publicEventsList = By.cssSelector("a[href=\"#public-events\"]");
    private By footerLogoImage = By
            .cssSelector("img[src=\"https://staging.liveet.co/assets/images/logo/logo-secondary.svg\"]");
    private By termsAndConditionLink = By.xpath("//a[contains(text(), ' Terms and Conditions ')]");
    private By privacyAndPolicyLink = By.cssSelector("a[href=\"https://liveet.gitbook.io/docs/privacy\"]");

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

    // For validiating multiple element(s)

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

    // For validiating multiple elements

    public void verifyOtherHomePageElements() {
        // List of locators to check
        List<By> locators = List.of(
                logoImage, homeLink, eventLink, favouriteLink, invitationLink, profileImg, createEventBtn, logoutBtn,
                allEventsList, privateEventsList, publicEventsList, footerLogoImage, termsAndConditionLink,
                privacyAndPolicyLink);
        checkElementsVisibility(driver, locators);

    }

    // For validiating one element
    public boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true; // Element is present
        } catch (NoSuchElementException e) {
            return false; // Element is not present
        }
    }

    // xpath selector
    /* //input[@id='username'] */

    public void closeBrowser() {

        driver.quit();
        System.out.println("Browser session has been closed");
    }

}
