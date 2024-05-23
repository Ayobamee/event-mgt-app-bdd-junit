package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import pages.HomePage;
import utils.driverUtils.loadApp;
import utils.filereader.readProperties;

import java.io.IOException;

public class LoginSteps extends loadApp {

    private WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws IOException, InterruptedException {

        driver = loadApp();
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() throws IOException {

        readProperties readTestData = new readProperties();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLoginRegisterButton();
        loginPage.enterPhoneNumber((String) readTestData.getUsername());
        loginPage.clickFirstContinueButton();
        loginPage.enterPassword((String) readTestData.getPassword());
        loginPage.clickSecondContinueButton();

    }

    @Then("I should be redirected to the home page")
    public void i_should_be_redirected_to_the_home_page() {
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePageItems();
        homePage.closeBrowser();

    }

}
