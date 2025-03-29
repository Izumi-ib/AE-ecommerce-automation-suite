package stepDefinitions.ui.CartPage;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import utils.DriverHelper;

public class searched_products_details {

    WebDriver driver = DriverHelper.getDriver();
    CartPage cartPage = new CartPage(driver);

    @Then("user verifies products in the cart related to the searched {string}")
    public void user_verifies_products_in_the_cart_related_to_the_searched(String searchedTitle) {
        cartPage.verifyProductsAreRelatedToSearch(searchedTitle);
    }
}
