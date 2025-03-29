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
    public void user_removes_product_index_from_cart(String index) {
        cartPage.removeProduct(index);
    }

    @Then("user verifies products length {string} are removed from the cart")
    public void user_verifies_products_length_are_removed_from_the_cart(String expectedAmountOfProducts) {
        cartPage.verifyProductsAreRemoved(Integer.parseInt(expectedAmountOfProducts));
    }

}
