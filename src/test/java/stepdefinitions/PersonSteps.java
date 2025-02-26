package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PersonPage;

public class PersonSteps {

    PersonPage personPage;

    @Given("the user is on the create a new person page")
    public void theUserIsOnTheCreateANewPersonPage() {
        personPage = new PersonPage();
        personPage.open();
    }

    @When("the user enters the person details")
    public void theUserEntersThePersonDetails() {
        personPage.enterPersonDetails();
    }

    @And("the user clicks on the save button")
    public void theUserClicksOnTheSaveButton() {
        personPage.save();
    }

    @Then("the person should be created successfully")
    public void thePersonShouldBeCreatedSuccessfully() {
        personPage.verifyPersonCreated();
    }
}
