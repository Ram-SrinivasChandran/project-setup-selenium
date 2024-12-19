package breezeware.stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import breezeware.Compass.LogInPage;
import breezeware.ManageDrivers.CompassShareContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorValidation {

    CompassShareContext compassShareContext;

    LogInPage logInPage;

    public ErrorValidation() throws IOException {
        compassShareContext = new CompassShareContext();
        logInPage = compassShareContext.compassPageObjectManager().getLoginPage();
    }

    @Given("^I landed on Renter Application$")
    public void i_landed_on_renter_application_error() {
        logInPage.clickLogin();
    }

    @When("^enter email (.+)$")
    public void enter_email(String email) throws InterruptedException {
        logInPage.enterEmail(email);
    }

    @And("^enter password (.+)$")
    public void enter_password(String password) throws Throwable {
        logInPage.enterPassword(password);
    }

    @And("^click submit$")
    public void click_submit() throws Throwable {
        logInPage.login();
    }

    @Then("^\\\"([^\\\"]*)\\\" message is displayed.$")
    public void something_message_is_displayed(String string) {
        String error = logInPage.getErrorMessage();
        Assert.assertEquals(string, error);

    }
}
