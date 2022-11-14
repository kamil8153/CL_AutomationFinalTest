package Pages;

import org.openqa.selenium.*;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkDiscountPercentage() {
        WebElement regularPrice = driver.findElement(By.cssSelector(".regular-price"));
        WebElement discountPrice = driver.findElement(By.cssSelector(".current-price-value"));
        double regularPriceDouble = Double.parseDouble(regularPrice.getText().replace("€", ""));
        double discountPriceDouble = Double.parseDouble(discountPrice.getText().replace("€", ""));
        double discountPercentage = 0.2;
        boolean isEqual;
        if (discountPriceDouble == ((1 - discountPercentage) * regularPriceDouble)) {
            isEqual = true;
        } else {
            isEqual = false;
        }
        return isEqual;
    }

    public boolean checkDiscountText() {
        WebElement discountBox = driver.findElement(By.xpath("//span[@class='discount discount-percentage']"));
        String discountText = discountBox.getText();
        String expectedDiscountText = "SAVE 20%";
        Boolean isPresent;
        if (discountText.equals(expectedDiscountText)) {
            isPresent = true;
        } else {
            isPresent = false;
        }
        return isPresent;
    }

    public boolean chooseSize(String size) {
        WebElement sizeDropDownList = driver.findElement(By.id("group_1"));
        String sizeUpper = size.toUpperCase();
        boolean isPresent;
        if (sizeUpper.equals("S") || sizeUpper.equals("M") || sizeUpper.equals("L") || sizeUpper.equals("XL")) {
            sizeDropDownList.sendKeys(sizeUpper);
            isPresent = true;
        } else {
            isPresent = false;
        }
        return isPresent;
    }

    public void chooseQty(String qty) throws InterruptedException {
        Thread.sleep(100);
        WebElement qtyInput = driver.findElement(By.name("qty"));
        qtyInput.click();
        Thread.sleep(100);
        qtyInput.sendKeys(Keys.ARROW_RIGHT, Keys.BACK_SPACE);
        qtyInput.sendKeys(qty);
    }

    public void clickAddToCart() throws InterruptedException {
        Thread.sleep(100);
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[data-button-action='add-to-cart'][type='submit']"));
        addToCartButton.click();
    }

    public void clickProceedToCheckout() {
        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
        proceedToCheckoutButton.click();
    }
}