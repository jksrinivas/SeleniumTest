package Testscripts;

import BaseTestSetup.BaseTest;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class PerformanceGlitchUser {
    WebDriver driver;
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
        login.enterUserNameAndPassword("performance_glitch_user", "secret_sauce");
    }

    @After
    public void closeBrowser(){
        baseTest.tearDown();

    }
}
