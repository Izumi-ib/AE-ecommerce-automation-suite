package stepDefinitions.ui.ProductsPage;

import pages.ProductsPages.ProductsPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class add_to_cart_products {

    WebDriver driver = DriverHelper.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);
    @When("user hovers over product with index {string} and clicks the Add to Cart button")
    public void user_hovers_over_product_with_index_and_clicks_the_Add_to_Cart_button(String i) {
        productsPage.addProductToCart(Integer.parseInt(i) - 1);
    }
    @When("user clicks Continue shopping button")
    public void user_clicks_continue_shopping_button() {
        productsPage.clickContinueShoppingButton();
    }
    @When("user clicks View Cart button on the modal form")
    public void user_clicks_view_cart_button_on_the_modal_form() {
        productsPage.clickViewCartModalButton();
    }

}
