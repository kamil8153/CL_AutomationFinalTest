package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseAddressesToOrder() {
        List<WebElement> addressesRadioInput = driver.findElements(By.cssSelector("input[name='id_address_delivery']"));

        if (addressesRadioInput.get(0).isSelected()) {
        } else {
            addressesRadioInput.get(0).click();
        }
    }

    public void clickContinueButtonAddresses() {
        WebElement continueButton = driver.findElement(By.name("confirm-addresses"));
        continueButton.click();
    }

    public void chooseShippingMethod() {
        WebElement shippingMethodRadioInput = driver.findElement(By.id("delivery_option_1"));

        if (shippingMethodRadioInput.isSelected()) {
        } else {
            shippingMethodRadioInput.click();
        }
    }

    public void clickContinueButtonMethod() {
        WebElement continueButton = driver.findElement(By.name("confirmDeliveryOption"));
        continueButton.click();
    }

    public void choosePayment() {
        WebElement payByCheckRadioInput = driver.findElement(By.id("payment-option-1"));
        WebElement checkboxTermsOfService = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        payByCheckRadioInput.click();
        if (checkboxTermsOfService.isSelected()) {
        } else {
            checkboxTermsOfService.click();
        }
    }

    public void clickPlaceOrder() {
        WebElement placeOrderButton = driver.findElement(By.cssSelector("button[class='btn btn-primary center-block']"));
        placeOrderButton.click();
    }
}