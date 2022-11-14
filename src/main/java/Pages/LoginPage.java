package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn(String email, String password) {
        WebElement emailInput = driver.findElement(By.cssSelector("input[class='form-control']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }
}