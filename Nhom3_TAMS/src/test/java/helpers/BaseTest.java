package helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        baseUrl = ConfigReader.get("base.url");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
