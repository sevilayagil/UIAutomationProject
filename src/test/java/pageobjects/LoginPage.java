package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.CSS, using = "#nav li:nth-child(7) >a")
    public WebElement registerOrLoginItem;
    @FindBy(how = How.CSS, using = "#to-login-switch span>a")
    public WebElement loginItem;
    @FindBy(how = How.NAME, using = "username")
    public WebElement name;
    @FindBy(how = How.NAME, using = "password")
    public WebElement password;
    @FindBy(how = How.ID, using = "login-button")
    public WebElement loginButton;
    @FindBy(how = How.CSS, using = "#login-form .alert-danger")
    public WebElement errorBox;
    @FindBy(how = How.ID, using = "profileLink")
    public WebElement profileLink;

}
