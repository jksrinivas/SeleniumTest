package BaseTestSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    FileInputStream fileStream;
    Properties prop;

    public WebDriver intializeDriver(String key) throws IOException {
        fileStream = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config.properties");
        prop = new Properties();
        prop.load(fileStream);
        String url = prop.getProperty(key);
        driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(4));
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
