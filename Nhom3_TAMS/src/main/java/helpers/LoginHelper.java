package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class LoginHelper {
    private WebDriver driver;
    public LoginHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password, String role) {
        driver.get(ConfigReader.get("base.url"));

        // TODO: replace locators with actual ones from site
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        // if role must be selected on login page:
        // driver.findElement(By.id("role")).sendKeys(role);

        driver.findElement(By.id("loginButton")).click();
    }
}
