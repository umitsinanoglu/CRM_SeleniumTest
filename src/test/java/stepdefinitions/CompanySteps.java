package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CompanyPage;

public class CompanySteps {
    CompanyPage companyPage = new CompanyPage();

    @Given("the user is on the create a new company page")
    public void theUserIsOnTheCreateANewCompanyPage() {
        companyPage.open();

    }

    @When("the user enters the company details")
    public void theUserEntersTheCompanyDetails() {
        companyPage.enterCompanyDetails();

    }

    @Then("the company should be created successfully")
    public void theCompanyShouldBeCreatedSuccessfully() {
    }
}
