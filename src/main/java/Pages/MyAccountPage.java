package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddressesTile() {
        WebElement addressesTile = driver.findElement(By.cssSelector("a[title='Addresses']"));
        addressesTile.click();
    }

    public void clickClothesTile() {
        WebElement clothesTile = driver.findElement(By.cssSelector(".dropdown-item[href='" +
                "https://mystore-testlab.coderslab.pl/index.php?id_category=3&controller=category']"));
        clothesTile.click();
    }

    public void clickOrderHistoryTile() {
        WebElement orderHistorytile = driver.findElement(By.id("history-link"));
        orderHistorytile.click();
    }
}