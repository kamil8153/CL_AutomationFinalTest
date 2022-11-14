package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class NewAddressesFormPage {
    private WebDriver driver;

    public NewAddressesFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typesAddressesForm(String alias, String address, String city, String zipCode, String country, String phone) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement aliasInput = driver.findElement(By.cssSelector("input[name='alias']"));
        WebElement addressInput = driver.findElement(By.cssSelector("input[name='address1']"));
        WebElement cityInput = driver.findElement(By.cssSelector("input[name='city']"));
        WebElement zipCodeInput = driver.findElement(By.cssSelector("input[name='postcode']"));
        WebElement countryInput = driver.findElement(By.cssSelector("select[name='id_country']"));
        WebElement phoneInput = driver.findElement(By.cssSelector("input[name='phone']"));
        WebElement saveButton = driver.findElement(By.cssSelector("button[class='btn btn-primary form-control-submit float-xs-right']"));
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipCodeInput.sendKeys(zipCode);
        countryInput.sendKeys(country);
        phoneInput.sendKeys(phone);
        saveButton.click();
    }
}