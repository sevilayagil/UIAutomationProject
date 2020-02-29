package pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
    @FindBy(how = How.NAME, using = "nickName")
    public WebElement nickName;
    @FindBy(how = How.NAME, using = "email")
    public WebElement email;
    @FindBy(how = How.CSS, using = ".form-group:nth-child(4) .form-control")
    public WebElement password;
    @FindBy(how = How.ID, using = "membershipAgreement")
    public WebElement membershipAgreement;
    @FindBy(how = How.CSS, using = "#register-button")
    public WebElement registerButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Bu kullanıcı adı kullanılamaz.')]")
    public WebElement errorBox;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'E-posta geçerli formatta değil.')]")
    public WebElement emailError;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Şifre zorunlu alan.')]")
    public WebElement passwordError;

}
