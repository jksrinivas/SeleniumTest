package Testscripts;

import BaseTestSetup.BaseTest;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StandardUserTest extends BaseTest {
    WebDriver driver;
    LoginPage login;
    BaseTest baseTest;
    InventoryPage product;
    CartPage cart;
    CheckOutPage checkout;

    @Before
    public void openBrowser() throws IOException {
        baseTest = new BaseTest();
        driver = baseTest.intializeDriver("url");
    }

    @Test
    public void enterUserNameAndPassword() throws InterruptedException, IOException {
        login = new LoginPage(driver);
        login.enterUserNameAndPassword("standard_user", "secret_sauce");
        product = new InventoryPage(driver);
        product.getAllProducts();
        product.clickCartContainer();
        cart = new CartPage(driver);
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cart.getProductName());
        Assert.assertEquals("$15.99", cart.getProductPrice());
        checkout = cart.clickCheckoutButton();
        checkout.enterUserDetails("first","@Last", "12345");
        checkout.clickContinueButton();
        checkout.clickFinishButton();
        Assert.assertEquals("Thank you for your order!", checkout.getConfirmationMessage());
    }

    @After
    public void closeBrowser(){
        baseTest.tearDown();

    }
}
