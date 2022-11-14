package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClothesPage {
    private WebDriver driver;

    public ClothesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHummingbirdSweater() {
        WebElement hummingbirdSweater = driver.findElement(By.xpath("//a[normalize-space()='Hummingbird printed sweater']"));
        hummingbirdSweater.click();
    }
}