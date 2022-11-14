package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
    private WebDriver driver;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewAddressTile() {
        WebElement createNewAddress = driver.findElement(By.cssSelector("a[data-link-action='add-address']"));
        createNewAddress.click();
    }

    public boolean checkAddressCreated() {
        WebElement alertBox = driver.findElement(By.cssSelector("article[role='alert'] ul li"));
        String alertText = alertBox.getText();
        String expectedAlertText = "Address successfully added!";
        Boolean isPresent;
        if (alertText.equals(expectedAlertText)) {
            isPresent = true;
        } else {
            isPresent = false;
        }
        return isPresent;
    }

    public void deleteAddress() {
        WebElement deleteTile = driver.findElement(By.cssSelector("div:nth-child(3) > article:nth-child(1) > " +
                "div:nth-child(2) > a:nth-child(2) > span:nth-child(2)"));
        deleteTile.click();
    }

    public boolean checkAddressDeleted() {
        WebElement alertBox = driver.findElement(By.cssSelector("article[role='alert'] ul li"));
        String alertText = alertBox.getText();
        String expectedAlertText = "Address successfully deleted!";
        Boolean isPresent;
        if (alertText.equals(expectedAlertText)) {
            isPresent = true;
        } else {
            isPresent = false;
        }
        return isPresent;
    }
}