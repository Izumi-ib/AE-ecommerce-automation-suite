package stepDefinitions.ui.CartPage;

import pages.CartPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class cart_product_details {

    WebDriver driver = DriverHelper.getDriver();
    CartPage cartPage = new CartPage(driver);

    @Then("user verifies that the total number of products in the cart is {string}")
    public void user_verifies_that_the_total_number_of_products_in_the_cart_is(String productsQuantity) {
        cartPage.verifyTheNumberOfAddedProducts(Integer.parseInt(productsQuantity));
    }
    @Then("user verifies that each product has the prices {string}, quantity {string} and total price {string}")
    public void user_verifies_that_each_product_has_the_prices_quantity_and_total_price(String prices, String quantities, String totalPrices) {
        cartPage.verifyProductsDetails(prices, quantities, totalPrices);
    }

    @Then("user verifies that the product quantity in the cart is {string}")
    public void user_verifies_that_the_product_quantity_in_the_cart_is(String expectedQuantity) {
        cartPage.verifyProductQuantity(expectedQuantity);
    }

    @Then("user verifies added to cart products are visible {string}")
    public void user_verifies_added_to_cart_products_are_visible(String productsId) {
        cartPage.validateProductsArePresent(productsId);
    }
}
