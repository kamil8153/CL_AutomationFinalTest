package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage {
    private WebDriver driver;
    private static String totalPriceOrderPage;
    private static String orderReferenceOrderPage;

    public static String getOrderReferenceOrderPage() {
        return orderReferenceOrderPage;
    }

    public static String getTotalPriceOrderPage() {
        return totalPriceOrderPage;
    }

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkOrderConfirmed() {
        WebElement alertBox = driver.findElement(By.cssSelector(".h1.card-title"));

        String alertText = alertBox.getText();
        String expectedAlertText = "\uE876YOUR ORDER IS CONFIRMED";

        Boolean isConfirmed;
        if (alertText.equals(expectedAlertText)) {
            isConfirmed = true;
        } else {
            isConfirmed = false;
        }
        return isConfirmed;
    }

    public void takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(".//screenshot/screen" + System.currentTimeMillis() + ".png"));
    }

    public void getOrderInfo() {
        WebElement orderTotalPrice = driver.findElement(By.cssSelector("div.text-xs-right.bold"));
        WebElement orderReference = driver.findElement(By.id("order-reference-value"));
        totalPriceOrderPage = orderTotalPrice.getText();
        orderReferenceOrderPage = orderReference.getText().replace("Order reference: ", "");
    }

    public void clickYourAccountName() {
        WebElement yourAccountName = driver.findElement(By.cssSelector("a[title='View my customer account']"));
        yourAccountName.click();
    }
}