package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSignIn() {
        WebElement signInTile = driver.findElement(By.cssSelector("a[title='Log in to your customer account']"));
        signInTile.click();
    }
}