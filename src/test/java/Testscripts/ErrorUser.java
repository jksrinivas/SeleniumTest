package Testscripts;

import BaseTestSetup.BaseTest;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ErrorUser extends BaseTest { WebDriver driver;
    LoginPage login;
    BaseTest baseTest;


    @Before
    public void openBrowser() throws IOException {
        baseTest = new BaseTest();
        driver = baseTest.intializeDriver("url");
    }

    @Test
    public void enterUserNameAndPassword(){
        LoginPage login = new LoginPage(driver);
        login.enterUserNameAndPassword("error_user", "secret_sauce");
    }

    @After
    public void closeBrowser(){
        baseTest.tearDown();

    }

}
