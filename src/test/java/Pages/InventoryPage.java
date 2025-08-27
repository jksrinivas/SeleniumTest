package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.inventory_item_name")
    List <WebElement> productList;
    @FindBy(id = "add-to-cart")
    WebElement addToCartButton;
    @FindBy (css = "a.shopping_cart_link")
    WebElement cartContainer;

    public void getAllProducts() throws InterruptedException {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).getText());
        }
        if (!productList.isEmpty()) {
            productList.get(2).click();
            Thread.sleep(1000);
            addToCartButton.click();
        }
    }
         public void clickCartContainer() {
             cartContainer.click();
         }
    }

