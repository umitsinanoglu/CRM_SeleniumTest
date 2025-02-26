package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.AssertionUtils;
import utils.DriverFactory;

import static utils.Constants.TESLA_PASSWORD;
import static utils.Constants.TESLA_USERNAME;

public class LoginSteps {

    LoginPage loginPage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage = new LoginPage();
        loginPage.open();
    }


    @When("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expected) {
        String actual = loginPage.getResponseMessage();
        loginPage.verifyErrorMessage(expected, actual, "Error message is not displayed");

    }

    @Then("a {string} error message should be displayed")
    public void ErrorMessageShouldBeDisplayed(String expected) {
        String actual = loginPage.getTextEmptyUserNameError();
        loginPage.verifyErrorMessage(expected, actual, "Error message is not displayed");

    }

    @When("the user enters a valid username and an empty password")
    public void theUserEntersAValidUsernameAndAnEmptyPassword() {
        loginPage.login("username", "");
    }

    @Then("{string} error message should be displayed for the password field")
    public void errorMessageShouldBeDisplayedForThePasswordField(String expected) {
        String actual = loginPage.getTextEmptyPasswordError();
        loginPage.verifyErrorMessage(expected, actual, "Error message is not displayed");
    }

    @And("the user should not be logged in")
    public void theUserShouldNotBeLoggedIn() {
        loginPage.verifyNotLoggedIn();
    }

    @And("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
        loginPage.verifyLoggedIn();

    }

    @And("the user should be redirected to the home page")
    public void theUserShouldBeRedirectedToTheHomePage() {
        loginPage.verifyRedirectedToHomePage();
    }

    @Then("the countdown timer should be visible on the login page")
    public void theCountdownTimerShouldBeVisibleOnTheLoginPage() {
    }

    @And("the two-factor authentication input field should be displayed")
    public void theTwoFactorAuthenticationInputFieldShouldBeDisplayed() {
    }


    @And("the user should be prompted to enter a two factor code")
    public void theUserShouldBePromptedToEnterATwoFactorCode() {
    }

    @When("the user enters a valid two factor code")
    public void theUserEntersAValidTwoFactorCode() {
    }

    @When("the user enters an empty username and a valid password")
    public void theUserEntersAnEmptyUsernameAndAValidPassword() {
        loginPage.login("", "password");
    }


    @And("the user should remain on the login page")
    public void theUserShouldRemainOnTheLoginPage() {
        loginPage.verifyUserIsOnLoginPage();
    }

    @When("the user enters valid username and valid password")
    public void theUserEntersValidUsernameAndValidPassword() {
        loginPage.login(TESLA_USERNAME, TESLA_PASSWORD);
    }

    @Then("the username should match the expected username as on myaccount page")
    public void theUsernameShouldMatchTheExpectedUsernameAsOnMyAccountPage() {
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.open();

        AssertionUtils.assertAll(
                () -> AssertionUtils.assertTextEquals(TESLA_USERNAME, myAccountPage.getUserName(), "Kullanıcı adı yanlış!"),
                () -> AssertionUtils.assertTextEquals("https://tesla.example.co/myaccount", DriverFactory.getDriver().getCurrentUrl(), "Yanlış sayfaya yönlendirildi!")
        );

        Assertions.assertEquals(TESLA_USERNAME, myAccountPage.getUserName(), "Kullanıcı adı yanlış!");
        Assertions.assertEquals("https://tesla.example.co/myaccount", DriverFactory.getDriver().getCurrentUrl(), "Yanlış sayfaya yönlendirildi!");

        // Print success message to console
        System.out.println("Test case 'testSuccessfulLogin' passed successfully.");
    }

    @And("the user should be able to logout successfully")
    public void theUserShouldBeAbleToLogoutSuccessfully() {
        loginPage.logout();
    }


    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(TESLA_USERNAME, TESLA_PASSWORD);

    }

    @And("the user is on the CRM home page")
    public void theUserIsOnTheCRMHomePage() {
        loginPage.verifyLoggedIn();
        loginPage.verifyRedirectedToHomePage();
    }


}
