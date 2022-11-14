package MyStoreTestLab;

import Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class MyStoreSteps {
    static WebDriver driver;


    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Given("The user is on {string} website")
    public void userIsOnWebsite(String url) {
        driver.get(url);
    }

    @When("The User click on Sign In tile")
    public void UserClickSignIn() {
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.clickOnSignIn();
    }

    @And("User types correct email address and password to their account and click the SIGN IN button in the form zone")
    public void userTypesEmailPassword() {
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.logIn("aaxx@wp.pl", "pas123");
    }

    @And("User click on the Addresses tile")
    public void userClickAddresses() {
        MyAccountPage onMyAccountPage = new MyAccountPage(driver);
        onMyAccountPage.clickAddressesTile();
    }

    @And("User click on the + Create new address tile")
    public void userClickCreateNewAddress() {
        MyAddressesPage onMyAddressesPage = new MyAddressesPage(driver);
        onMyAddressesPage.createNewAddressTile();
    }

    @And("User completes the new address form {string}, {string}, {string}, {string}, {string}, {string} and click " +
            "the SAVE button")
    public void userCompletesAddressesForm(String alias, String address, String city, String zipCode, String country,
                                           String phone) {
        NewAddressesFormPage onNewAddressesFormPage = new NewAddressesFormPage(driver);
        onNewAddressesFormPage.typesAddressesForm(alias, address, city, zipCode, country, phone);
    }

    @And("User address has been created")
    public void userCheckAddressesAdded() {
        MyAddressesPage onMyAddressesPage = new MyAddressesPage(driver);
        Assert.isTrue(onMyAddressesPage.checkAddressCreated(), "The address has not been added " +
                "correctly");
    }

    @And("User wants delete added addresses")
    public void userWantsDeleteAddedAddresses() {
        MyAddressesPage onMyAddressesPage = new MyAddressesPage(driver);
        onMyAddressesPage.deleteAddress();
    }

    @Then("Addresses deleted")
    public void addressesDeleted() {
        MyAddressesPage onMyAddressesPage = new MyAddressesPage(driver);
        Assert.isTrue(onMyAddressesPage.checkAddressDeleted(), "The address has not been removed");
    }

    @And("User click on Clothes tile")
    public void userClickOnClothesTile() {
        MyAccountPage onMyAccountPage = new MyAccountPage(driver);
        onMyAccountPage.clickClothesTile();
    }

    @And("User click on Hummingbird Printed Sweater tile")
    public void userClickOnProduct() {
        ClothesPage onClothesPage = new ClothesPage(driver);
        onClothesPage.clickHummingbirdSweater();
    }

    @And("User check if the discount on the product is 20%")
    public void userCheckIfTheDiscountOnTheProductIs() {
        ProductPage onProductPage = new ProductPage(driver);
        Assert.isTrue(onProductPage.checkDiscountPercentage(), "The discount is other than 20%");
        Assert.isTrue(onProductPage.checkDiscountText(), "The discount label is not 20%");

    }

    @And("User choose size {string}on drop down list")
    public void userChooseSizeMOnDropDownList(String size) {
        ProductPage onProductPage = new ProductPage(driver);
        Assert.isTrue(onProductPage.chooseSize(size), "The specified size does not exist or is not " +
                "available");
    }

    @And("User add {string}")
    public void userAddAndClickOnAddToCartButton(String qty) throws InterruptedException {
        ProductPage onProductPage = new ProductPage(driver);
        onProductPage.chooseQty(qty);
    }

    @And("User click on add to cart button")
    public void userClickOnAddToCartButton() throws InterruptedException {
        ProductPage onProductPage = new ProductPage(driver);
        onProductPage.clickAddToCart();
    }

    @And("User click proceed to checkout button on product page")
    public void clickProceedToCheckoutButtonOnProductPage() {
        ProductPage onProductPage = new ProductPage(driver);
        onProductPage.clickProceedToCheckout();
    }

    @And("User click proceed to checkout button on cart page")
    public void clickProceedToCheckoutButtonOnCartPage() {
        ShoppingCartPage onShoppingCartPage = new ShoppingCartPage(driver);
        onShoppingCartPage.clickProceedToCheckout();
    }

    @And("User choose main addresses and click CONTINUE button")
    public void chooseMainAddressesAndClickContinueButton() {
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.chooseAddressesToOrder();
        onOrderPage.clickContinueButtonAddresses();
    }

    @And("User choose PrestShop Pick Up in- store option and click continue button")
    public void userChooseDeliveryMethod() {
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.chooseShippingMethod();
        onOrderPage.clickContinueButtonMethod();
    }

    @And("User click Pay By Check option, check checkbox I agree to the terms... and click place order button")
    public void userClickPayByCheck() {
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.choosePayment();
        onOrderPage.clickPlaceOrder();
    }

    @And("Order has been created and confirmed, screenshot created")
    public void orderHasBeenCreatedAndConfirmed() throws IOException {
        OrderConfirmationPage onOrderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.isTrue(onOrderConfirmationPage.checkOrderConfirmed(), "An error occurred while creating" +
                " the order");
        onOrderConfirmationPage.takeScreenShot();
        onOrderConfirmationPage.getOrderInfo();
    }

    @And("User click on your account")
    public void userClickOnYourAccount() {
        OrderConfirmationPage onOrderConfirmationPage = new OrderConfirmationPage(driver);
        onOrderConfirmationPage.clickYourAccountName();
    }

    @And("User click on order history")
    public void userClickOnOrderHistory() {
        MyAccountPage onMyAccountPage = new MyAccountPage(driver);
        onMyAccountPage.clickOrderHistoryTile();
    }

    @Then("Check if order is on the list with status awaiting check payment and make sure the amount is the same " +
            "like on order page")
    public void checkIfOrderIsOnTheList() {
        OrderHistoryPage onOrderHistoryPage = new OrderHistoryPage(driver);
        String orderReferenceOrderPage = OrderConfirmationPage.getOrderReferenceOrderPage();
        String totalPriceOrderPage = OrderConfirmationPage.getTotalPriceOrderPage();
        Assert.isTrue(onOrderHistoryPage.checkReferenceAndTotalPriceAreSame(orderReferenceOrderPage, totalPriceOrderPage),
                "Order is not present or total price is different than total price on order page");
        Assert.isTrue(onOrderHistoryPage.checkStatusIsSame(orderReferenceOrderPage), "Status is " +
                "different than expected");
    }

    @After
    public void logout() {
        WebElement logoutButton = driver.findElement(By.cssSelector("a[href='https://mystore-testlab.coderslab.pl/" +
                "index.php?mylogout=']"));
        logoutButton.click();
    }

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
}