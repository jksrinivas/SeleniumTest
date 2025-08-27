package Testscripts;

import BaseTestSetup.BaseTest;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Properties;

public class LockedUserTest extends BaseTest {
    WebDriver driver;
    LoginPage login;
    BaseTest baseTest;
    Properties prop;

    @Before
    public void openBrowser() throws IOException {
        baseTest = new BaseTest();
        driver = baseTest.intializeDriver("url");

    }

    @Test
    public void enterUserNameAndPassword(){
        LoginPage login = new LoginPage(driver);
        login.enterUserNameAndPassword("locked_out_user", "secret_sauce");
        String message = login.getErrorMessage();
        System.out.println(message);
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", message);
        System.out.println("Successfully verified the error message for locked out user.");
    }

    @After
    public void closeBrowser(){
        baseTest.tearDown();

    }
}
