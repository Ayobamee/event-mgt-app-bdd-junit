package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import pages.HomePage;
import utils.driverUtils.loadApp;

import java.io.IOException;

public class CreateEventSteps extends loadApp {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I am logged into the application")
    public void i_am_logged_into_the_application() throws IOException, InterruptedException {
        driver = loadApp();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLoginAction(driver);

    }

    @When("I click the create event button")
    public void i_click_the_create_event_button() throws IOException {

        HomePage homePage = new HomePage(driver);
        homePage.createEvent();

    }

}
