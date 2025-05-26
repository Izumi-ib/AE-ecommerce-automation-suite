package stepDefinitions.ui.CartPage;

import pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class remove_products {
    WebDriver driver = DriverHelper.getDriver();
    CartPage cartPage = new CartPage(driver);

    @When("user removes product index {string} from cart")
    public void user_removes_product_index_from_cart(String indexes) {

        String[] indexArray = indexes.split(",");

        for (int i = 0; i < indexArray.length; i++) {
            cartPage.removeProduct(indexArray[i].trim());
        }
    }

    @Then("user verifies products length {string} are removed from the cart")
    public void user_verifies_products_length_are_removed_from_the_cart(String expectedAmountOfProducts) {
        cartPage.verifyProductsAreRemoved(Integer.parseInt(expectedAmountOfProducts));
    }

    @Then("user should see cart is empty message {string}")
    public void user_should_see_cart_is_empty_message(String expectedMessage){
        cartPage.validateCartEmptyMessage(expectedMessage);
    }

}
