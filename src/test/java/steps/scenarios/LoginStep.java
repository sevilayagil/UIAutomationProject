package steps.scenarios;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageobjects.LoginPage;
import steps.base.BaseStep;

public class LoginStep extends BaseStep {
    private LoginPage login;

    public LoginStep() {
        super("login");
        login = PageFactory.initElements(this.driver, LoginPage.class);
        set_timeOutValue(5000);
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        GotoUrl();
    }

    @When("^I click login items$")
    public void iClickLoginItems() {
        clickElement(login.registerOrLoginItem);
        pageScrollDown();
        clickElement(login.loginItem);
    }

    @And("^I fill username for missing$")
    public void iFillUsernameForMissing() {
        visibilityOfElement(login.password).sendKeys("");
    }

    @And("^I fill password for missing$")
    public void iFillPasswordForMissing() {
        visibilityOfElement(login.password).sendKeys("");
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        clickElement(login.loginButton);
    }

    @Then("^I should see response$")
    public void iShouldSeeResponse() {
        visibilityOfElement(login.errorBox);
        driver.quit();
    }

    @And("^I fill \"([^\"]*)\" for missing$")
    public void iFillForMissing(String arg0) {
        visibilityOfElement(login.name).sendKeys("");
        visibilityOfElement(login.password).sendKeys("");
    }

    @And("^I fill username for successful$")
    public void iFillUsernameForSuccessful() {
        visibilityOfElement(login.name).sendKeys(user.getUserName());
    }

    @And("^I fill password for successful$")
    public void iFillPasswordForSuccessful() {
        visibilityOfElement(login.password).sendKeys(user.getUserPassword());
    }

    @Then("^I should see ProfileLink$")
    public void iShouldSeeProfileLink() {
        visibilityOfElement(login.profileLink);
        driver.quit();
    }

    @And("^I enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iEnterUsernameAndPassword(String username, String password) {
        visibilityOfElement(login.name).sendKeys(username);
        visibilityOfElement(login.password).sendKeys(password);
    }
}
