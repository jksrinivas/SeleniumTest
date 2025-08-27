package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement pass;
    @FindBy(id = "login-button")
    public WebElement submitButton;
    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;

    public void enterUserNameAndPassword(String user, String passField) {
        this.userName.sendKeys(user);
        this.pass.sendKeys(passField);
        this.submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
