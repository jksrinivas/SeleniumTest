package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    WebDriver driver;
    public CheckOutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy (id = "finish")
    WebElement finishButton;
    @FindBy (css = "h2.complete-header")
    WebElement confirmationMessage;

    public void enterUserDetails(String first, String last, String postal){
        this.firstName.sendKeys(first);
        this.lastName.sendKeys(last);
        this.postalCode.sendKeys(postal);
    }
    public void clickContinueButton(){
        continueButton.click();
    }
    public void clickFinishButton(){
        finishButton.click();
    }
    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }

}
