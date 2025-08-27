package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "div.inventory_item_name")
    WebElement productName;
    @FindBy (css = "div.inventory_item_price")
    WebElement productPrice;
    @FindBy (id = "checkout")
    WebElement checkoutButton;

    public String getProductName(){
        return productName.getText();
    }
    public String getProductPrice() {
        return productPrice.getText();
    }
    public CheckOutPage clickCheckoutButton() {
        checkoutButton.click();
        return new CheckOutPage(driver);
    }
}
