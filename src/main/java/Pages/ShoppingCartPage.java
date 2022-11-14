package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProceedToCheckout() {
        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
        proceedToCheckoutButton.click();
    }
}
