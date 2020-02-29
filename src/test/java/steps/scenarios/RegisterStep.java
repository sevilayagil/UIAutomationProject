package steps.scenarios;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import steps.base.BaseStep;

public class RegisterStep extends BaseStep {
    private LoginPage login;
    private RegisterPage register;
    public RegisterStep() {
        super("register");
        login = PageFactory.initElements(this.driver, LoginPage.class);
        register = PageFactory.initElements(this.driver, RegisterPage.class);
        set_timeOutValue(5000);
    }
    @Given("^I am on the home page for register process$")
    public void iAmOnTheHomePageForRegisterProcess() {
        GotoUrl();
    }
    @When("^I click register items$")
    public void iClickRegisterItems() {
        clickElement(login.registerOrLoginItem);
    }

    @And("^I fill register forms$")
    public void iFillRegisterForms() {
        visibilityOfElement(register.nickName).sendKeys("Testautomation"+randomGenerator.nextInt(10));
        visibilityOfElement(register.email).sendKeys("Testautomationdolap" + randomGenerator.nextInt(100) + "@gmail.com");
        clickElement(register.membershipAgreement);
        clickElement(register.password);
        visibilityOfElement(register.password).sendKeys("12dCQhFgh" );
    }
    @And("^I press register button$")
    public void iPressRegisterButton() {
        pageScrollDown();
        clickElement(register.registerButton);
    }

    @Then("^I should see ProfileLink after register$")
    public void iShouldSeeProfileLinkAfterRegister() {
        visibilityOfElement(login.profileLink);
    }

    @And("^I fill register forms by mistake$")
    public void iFillRegisterFormsByMistake() {
        visibilityOfElement(register.nickName).sendKeys("dolap");
        visibilityOfElement(register.email).sendKeys("Test" +  "@gmail.com");
        clickElement(register.membershipAgreement);
        clickElement(register.password);
        visibilityOfElement(register.password).sendKeys("12dCQhFgh" );

    }

    @Then("^I should see errorbox$")
    public void iShouldSeeErrorbox() {
        visibilityOfElement(register.errorBox);
        driver.quit();
    }

    @And("^I fill register forms for email by mistake$")
    public void iFillRegisterFormsForEmailByMistake() {
        visibilityOfElement(register.nickName).sendKeys("Testautomation"+randomGenerator.nextInt(10));
        visibilityOfElement(register.email).sendKeys("Test");
        clickElement(register.membershipAgreement);
        clickElement(register.password);
        visibilityOfElement(register.password).sendKeys("12dCQhFgh" );
    }

    @Then("^I should see errorbox about email$")
    public void iShouldSeeErrorboxAboutEmail() {
        visibilityOfElement(register.emailError);
        driver.quit();
    }

    @And("^I fill register forms for password by mistake$")
    public void iFillRegisterFormsForPasswordByMistake() {
        visibilityOfElement(register.nickName).sendKeys("Testautomation"+randomGenerator.nextInt(10));
        visibilityOfElement(register.email).sendKeys("Testautomationdolap" + randomGenerator.nextInt(100) + "@gmail.com");
        clickElement(register.membershipAgreement);
        clickElement(register.password);
        visibilityOfElement(register.password).sendKeys("" );
    }

    @Then("^I should see errorbox about password$")
    public void iShouldSeeErrorboxAboutPassword() {
        visibilityOfElement(register.passwordError);
        driver.quit();
    }
}
