package stepDefinitions.ui.CartPage;

import pages.CartPage;
import pages.CheckoutPage;
import pages.OrderPlacedPage;
import pages.PaymentPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHelper;

import java.time.Duration;

public class place_order {

    WebDriver driver = DriverHelper.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);
    OrderPlacedPage orderPlacedPage = new OrderPlacedPage(driver);
    @Then("user verifies the Cart Page is displayed")
    public void user_verifies_the_cart_page_is_displayed() {
        cartPage.checkUserIsOnTheCartPage(driver.getCurrentUrl());
    }
    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cartPage.clickProceedToCheckoutButton();
    }
    @When("user clicks Register and Login button on the modal")
    public void user_clicks_register_and_login_button_on_the_modal() {
        cartPage.clickRegisterAndLoginButton();
    }
    @Then("user verifies address details and reviews the order")
    public void user_verifies_address_details_and_reviews_the_order() {
        checkoutPage.verifyAddressSectionsIsVisible();
    }
    @When("user adds a comment {string} and places the order")
    public void user_adds_a_comment_and_places_the_order(String message) {
        checkoutPage.enterComment(message);
        checkoutPage.clickPlaceOrderButton();
    }
    @When("user enters payment details Name on Card {string}, Card number {string}, CVC {string}, Expiration Date {string}")
    public void user_enters_payment_details_name_on_card_card_number_cvc_expiration_date(String name, String number, String cvc, String expirationDate) {
        paymentPage.fillCartInformation(name, number, cvc, expirationDate);
    }
    @When("user confirms the payment")
    public void user_confirms_the_payment() {
        paymentPage.clickPayAndConfirmOrderButton();
    }
    @Then("user verifies order message {string} is visible")
    public void user_verifies_order_message_is_visible(String expectedMessage){
        orderPlacedPage.validateCongratulationsTitle(expectedMessage);
    }
    @Then("user verifies delivery address is same as registered {string}, {string}, {string}, {string}, {string}, {string} {string}")
    public void user_verifies_delivery_address_is_same_as_registered(String name, String company, String address1, String address2, String cityStateZip, String country, String phoneNumber) {
        checkoutPage.verifyDeliveryAddress(name, company, address1, address2, cityStateZip, country, phoneNumber);
    }
    @Then("user verifies billing address is same as registered {string}, {string}, {string}, {string}, {string}, {string} {string}")
    public void user_verifies_billing_address_is_same_as_registered(String name, String company, String address1, String address2, String cityStateZip, String country, String phoneNumber) {
        checkoutPage.verifyBillingAddress(name, company, address1, address2, cityStateZip, country, phoneNumber);
    }
    @When("user clicks download invoice button and verifies invoice was downloaded")
    public void user_clicks_download_invoice_button_and_verifies_invoice_was_downloaded() {
        orderPlacedPage.clickDownloadButtonVerifyInvoiceWasDownloaded();
    }
    @When("user clicks Continue button in Order Placed page")
    public void user_clicks_continue_button_in_order_placed_page() {
        orderPlacedPage.clickContinueButton();
    }

}
