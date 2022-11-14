package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage {
    public WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkReferenceAndTotalPriceAreSame(String orderReferenceOrderPage, String totalPriceOrderPage) {
        WebElement orderReferenceHistoryPage = driver.findElement(By.cssSelector("tbody tr:nth-child(1) th:nth-child(1)"));
        WebElement totalPriceHistoryPage = driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)"));

        String orderReference = orderReferenceHistoryPage.getText();
        String totalPrice = totalPriceHistoryPage.getText();

        boolean isEqual;
        if (orderReference.equals(orderReferenceOrderPage)) {
            if (totalPrice.equals(totalPriceOrderPage)) {
                isEqual = true;
            } else {
                isEqual = false;
            }
        } else {
            isEqual = false;
        }
        return isEqual;
    }

    public boolean checkStatusIsSame(String orderReferenceOrderPage) {
        WebElement orderReferenceHistoryPage = driver.findElement(By.cssSelector("tbody tr:nth-child(1) th:nth-child(1)"));
        WebElement statusHistoryPage = driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(5)"));

        String orderReference = orderReferenceHistoryPage.getText();
        String status = statusHistoryPage.getText();
        String expectedStatusText = "Awaiting check payment";

        boolean isEqual;
        if (orderReference.equals(orderReferenceOrderPage)) {
            if (status.equals(expectedStatusText)) {
                isEqual = true;
            } else {
                isEqual = false;
            }
        } else {
            isEqual = false;
        }
        return isEqual;
    }
}
